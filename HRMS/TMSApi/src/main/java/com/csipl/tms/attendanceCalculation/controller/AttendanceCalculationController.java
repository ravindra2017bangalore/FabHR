package com.csipl.tms.attendanceCalculation.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.csipl.tms.attendanceregularizationrequest.service.PunchTimeDetailsService;
import com.csipl.tms.deviceinfo.adaptor.DeviceInfoAdaptor;
import com.csipl.tms.deviceinfo.service.DeviceInfoService;
import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;
import com.csipl.tms.dto.employee.EmployeeDTO;
import com.csipl.tms.model.attendancelog.AttendanceLog;
import com.csipl.tms.model.deviceinfo.DeviceInfo;
import com.csipl.tms.attendanceCalculation.adaptor.AttendanceCalculationAdaptor;
import com.csipl.tms.attendancelog.service.AttendanceCalculationService;
import com.csipl.tms.attendancelog.service.AttendanceLogService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AttendanceCalculationController {

	@Autowired
	AttendanceCalculationService attendanceCalculationService;

	@Autowired
	AttendanceLogService attendanceLogService;

	@Autowired
	DeviceInfoService deviceInfoService;
	
	@Autowired
	PunchTimeDetailsService punchTimeDetailsService;

	/*@Autowired
	EmployeeInfoService employeeInfoService;*/
	
	AttendanceCalculationAdaptor attendanceCalculationAdaptor = new AttendanceCalculationAdaptor();

	DeviceInfoAdaptor deviceInfoAdaptor = new DeviceInfoAdaptor();

	private static final Logger logger = LoggerFactory.getLogger(AttendanceCalculationController.class);
	

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully save PunchTimeDetails data from ESSL mashine"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update the resource"),
			@ApiResponse(code = 403, message = "You were trying to save resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	
	
	@RequestMapping(value = "/punchtimedetails", method = RequestMethod.GET)
	public @ResponseBody void getAllPunchDetails() throws ParseException {

		List<DeviceInfo> deviceInfo = deviceInfoService.findDeviceInfo(1L);

		Object[] object = deviceInfoAdaptor.getDeviceInfo(deviceInfo);
		String prefix = (String) object[0];
		Long companyId = (Long) object[1];

		if ( companyId == null )
			companyId = 1l;

		EmployeeDTO employeeDto=getEmployeeIdByRestTamplate( companyId.toString() );
		
		List<EmployeeDTO> employeeDtoList = employeeDto.getEmployessList();
		logger.info("employeeDtoList Size------->"+employeeDtoList.size());
		
		Map<String, Long> mapEmpIdAndEmpCode = new HashMap<>();
		
		List<Object[]> objectList = attendanceCalculationService.getAllPunchDetails(object);
		List<AttendanceLogDTO> attendanceLogDtoList = attendanceCalculationAdaptor.objListToDto(objectList, prefix,
				companyId,employeeDtoList,mapEmpIdAndEmpCode);
	
		List<Object[]> empAttendanceList = punchTimeDetailsService.getEmpAttendaceList(1l);
		List<AttendanceLogDTO> systemAttendanceLogList= attendanceCalculationAdaptor.objectListToUImodel(empAttendanceList);
		List<AttendanceLogDTO> attendanceLogList= attendanceCalculationAdaptor.attendanceCalculation(attendanceLogDtoList, systemAttendanceLogList,mapEmpIdAndEmpCode);
		
			   
		List<AttendanceLog> attendanceLogList1 = attendanceCalculationAdaptor.uiDtoToDatabaseModelList(attendanceLogList);

		attendanceLogService.savePunchTimeLog(attendanceLogList1);
		logger.info(" attendanceLogList----->" + attendanceLogList);
	}
	
	private EmployeeDTO getEmployeeIdByRestTamplate(String companyId) {
		logger.info("Company Id----->" + companyId);
		logger.info("getEmployeeIdByRestTamplate is calling : ");
		String url = "http://localhost:8080/hrmsApi/employees/{companyId}";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String, String> params = new HashMap<>();
		params.put("companyId", companyId);
		return restTemplate.getForObject(url, EmployeeDTO.class, params);
	}

}
