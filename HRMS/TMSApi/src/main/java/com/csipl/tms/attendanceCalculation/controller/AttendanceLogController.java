package com.csipl.tms.attendanceCalculation.controller;

import java.io.IOException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.tms.attendanceCalculation.adaptor.AttendanceLogAdaptor;
import com.csipl.tms.attendancelog.service.AttendanceLogPaginationService;
import com.csipl.tms.attendancelog.service.AttendanceLogPagingAndFilterService;
import com.csipl.tms.attendancelog.service.AttendanceLogService;
import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;
import com.csipl.tms.dto.attendancelog.AttendanceLogDetailsDTO;
import com.csipl.tms.dto.attendancelog.AttendanceLogSearchDTO;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.dto.common.PageIndex;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.empcommondetail.service.EmpCommonDetailService;
import com.csipl.tms.holiday.adaptor.HolidayAdaptor;
import com.csipl.tms.holiday.service.HolidayService;
import com.csipl.tms.leave.service.EmployeeLeaveService;
import com.csipl.tms.model.attendancelog.AttendanceLog;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.leave.TMSLeaveEntry;
import com.csipl.tms.rules.service.RulesService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/attendanceLog")

public class AttendanceLogController {
	@Autowired
	AttendanceLogService attendanceLogService;

	@Autowired
	EmpCommonDetailService empCommonDetailService;

	@Autowired
	RulesService rulesService;

	@Autowired
	EmployeeLeaveService employeeLeaveService;

	@Autowired
	HolidayService holidayService;

	@Autowired
	AttendanceLogPagingAndFilterService attendanceLogPagingAndFilterService;

	@Autowired
	AttendanceLogPaginationService attendanceLogPaginationService;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceLogController.class);
	AttendanceLogAdaptor attendanceLogAdaptor = new AttendanceLogAdaptor();
	HolidayAdaptor holidayAdaptor = new HolidayAdaptor();

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully save PunchTimeDetails data from ESSL mashine"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update the resource"),
			@ApiResponse(code = 403, message = "You were trying to save resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/attendanceLogDetails", method = RequestMethod.GET)
	public @ResponseBody List<AttendanceLogDetailsDTO> getAttendanceLogDetails(@RequestParam("date") String date,
			@RequestParam("companyId") Long companyId) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date formatedDate = formatter.parse(date);
		List<AttendanceLog> attendanceLogDetailsList = attendanceLogService.getAttendanceLogDetails(companyId, date);
		logger.info("attendanceLogDetailsList..." + attendanceLogDetailsList);
		List<EmpCommonDetail> empCommonDetailList = empCommonDetailService.getEmployeeCommonDetailsList(companyId);

		HalfDayRule halfDayRule = rulesService.getHalfDayRule(companyId);
		List<TMSLeaveEntry> leaveList = employeeLeaveService.getEmployeeLeaveEntryListByDate(formatedDate);
		List<Object[]> tmsHolidays = holidayService.findMonthHoliday(companyId, date, date);
		List<HolidayDTO> holidayDtoList = holidayAdaptor.databaseModelObjToUiDtoList(tmsHolidays);

		List<AttendanceLogDetailsDTO> attendanceLogDetailsDtoList = attendanceLogService.getAttendanceLogDetailsDTOList(
				attendanceLogDetailsList, empCommonDetailList, halfDayRule, leaveList, holidayDtoList, formatedDate);

		return attendanceLogDetailsDtoList;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AttendanceLogDetailsDTO> getAttendanceLog(@RequestBody AttendanceLogSearchDTO attendanceLogSearchDto) { //
		logger.info(" getAttendanceLog is calling :");
		AttendanceLogAdaptor attendanceLogAdaptor = new AttendanceLogAdaptor();
		String attendanceDate = new SimpleDateFormat("yyyy-MM-dd").format(attendanceLogSearchDto.getAttendanceDate());
		List<Object[]> attendanceLogDetails = attendanceLogPagingAndFilterService
				.getAttendanceLogByPagingAndFilter(attendanceLogSearchDto, attendanceDate);
		return attendanceLogAdaptor.modeltoDTOList(attendanceLogDetails);
	}

	@RequestMapping(value = "/count/{pageSize}", method = RequestMethod.POST)
	public @ResponseBody EntityCountDTO getAttendanceLogCount(@PathVariable("pageSize") String pageSize,
			@RequestBody AttendanceLogSearchDTO attendanceLogSearchDto) throws ParseException {
		int count;
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String attendanceDate = new SimpleDateFormat("yyyy-MM-dd").format(attendanceLogSearchDto.getAttendanceDate());

		logger.info(
				"---before---" + new SimpleDateFormat("yyyy-MM-dd").format(attendanceLogSearchDto.getAttendanceDate()));
		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();
		int parPageRecord = Integer.parseInt(pageSize);
		EntityCountDTO entityCountDto = new EntityCountDTO();
		attendanceLogPagingAndFilterService.getAttendanceLogCount(entityCountDto, attendanceLogSearchDto,
				attendanceDate);
		count = entityCountDto.getCount();
		logger.info("Count :" + count);
		int pages = (count + parPageRecord - 1) / parPageRecord;
		logger.info("Pages : -" + pages);
		for (int i = 1; i <= pages; i++) {
			PageIndex pageIndex = new PageIndex();
			pageIndex.setPageIndex(i);
			pageIndexList.add(pageIndex);
		}
		entityCountDto.setPageIndexs(pageIndexList);
		entityCountDto.setCount(count);
		return entityCountDto;
	}

	@RequestMapping(value = "/bulkAttendance/{attendanceDate}/{attendanceStatus}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AttendanceLogDTO> markBulkAttendance(@RequestBody List<AttendanceLogDTO> attendanceLogDtoList,
			@PathVariable("attendanceDate") Date attendanceDate,
			@PathVariable("attendanceStatus") String attendanceStatus) {

		List<AttendanceLog> attendanceLogList = attendanceLogAdaptor.uiDtoToDatabaseModelList(attendanceLogDtoList,
				attendanceDate, attendanceStatus);

		List<AttendanceLog> attendanceLogList1 = attendanceLogService.markBulkAttendance(attendanceLogList);

		List<AttendanceLogDTO> attendanceLogDTOList = attendanceLogAdaptor.databaseModelToUiDtoList(attendanceLogList1);

		return attendanceLogDTOList;
	}

	@RequestMapping(value = "/attendanceLogs/{attendanceDate}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AttendanceLogDTO> getAttendanceLogPaginationList(@RequestBody EmployeeSearchDTO employeeSearcDto,
			@PathVariable("attendanceDate") Date attendanceDate) {
		String strAttendanceDate = new SimpleDateFormat("yyyy-MM-dd").format(attendanceDate);
		logger.info("deptId " + employeeSearcDto.getDepartmentId() + "desigId " + employeeSearcDto.getDesignationId()
				+ " AttendanceStatus>>" + employeeSearcDto.getAttendaceStatus() + "EmpCode "
				+ employeeSearcDto.getEmployeeCode());
		List<Object[]> objAttendanceLogList = attendanceLogPaginationService
				.getAttendanceLogForMarkAttendance(employeeSearcDto, strAttendanceDate);
		List<AttendanceLogDTO> attendanceDtoList = attendanceLogAdaptor
				.databaseObjModelToUiDtoList(objAttendanceLogList);
		return attendanceDtoList;
	}

	@RequestMapping(path = "/attendanceReport/{companyId}/{attendanceDate}", method = RequestMethod.GET)
	public void attendanceReport(@PathVariable("companyId") Long companyId,
			@PathVariable("attendanceDate") Date attendanceDate, HttpServletRequest req, HttpServletResponse response)
			throws ErrorHandling, ParseException {

		System.out.println(">>>>>> attendanceReport <<<<<<<<<<<<<<<<<<<");

		String[] columns = { "Sr. No.","Employee", "Status", "Punch Record", "Punch Location", "Mode", "Reported Late By",
				"Left Early By" };

		List<Object[]> attendanceLogDetails = attendanceLogPagingAndFilterService.attendanceReport(companyId,
				attendanceDate);

		List<AttendanceLogDetailsDTO> attendanceLogDetailsDtoList = attendanceLogAdaptor
				.modeltoDTOList(attendanceLogDetails);

		try {
			response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;filename=attandanceReport.xlsx");

			if (attendanceLogDetailsDtoList.size() > 0) {
				Workbook workbook = AttendanceReportExcelWriter.attendanceReport(attendanceLogDetailsDtoList, columns);
				ServletOutputStream fileOut = response.getOutputStream();
				workbook.write(fileOut);
			}

		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}}