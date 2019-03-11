package com.csipl.tms.attendanceregularizationrequest.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.model.employee.Employee;

import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.attendanceregularizationrequest.adaptor.AttendanceRegularizationRequestAdaptor;
import com.csipl.tms.attendanceregularizationrequest.service.ARRequestPagingAndFilterService;
import com.csipl.tms.attendanceregularizationrequest.service.AttendanceRegularizationRequestService;
import com.csipl.tms.dto.attendanceregularizationrequest.AttendanceRegularizationRequestDTO;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.dto.common.PageIndex;
import com.csipl.tms.dto.common.SearchDTO;
import com.csipl.tms.empcommondetail.service.EmpCommonDetailService;
import com.csipl.tms.model.attendanceregularizationrequest.AttendanceRegularizationRequest;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/attendanceregularizationrequest")
@RestController
@Api(description = "Operations pertaining to AttendanceRegularizationRequest in Time Management")
public class AttendanceRegularizationRequestController {

	@Autowired
	AttendanceRegularizationRequestService attendanceRegularizationRequestService;

	@Autowired
	EmpCommonDetailService empCommonDetailService;

	@Autowired
	ARRequestPagingAndFilterService aRRequestPagingAndFilterService;

	/*
	 * @Autowired private final RestTemplate restTemplate;
	 */

	// @Qualifier("employeeService")
	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(AttendanceRegularizationRequestController.class);

	AttendanceRegularizationRequestAdaptor attendanceRegularizationRequestAdaptor = new AttendanceRegularizationRequestAdaptor();

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "Save or update AttendanceRegularizationRequest")
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody AttendanceRegularizationRequestDTO attendanceRegularizationRequestDto)
			throws ErrorHandling {
		logger.info("save AttendanceRegularizationRequest is calling : " + " : attendanceRegularizationRequestDto "
				+ attendanceRegularizationRequestDto);

		AttendanceRegularizationRequest attendanceRegularizationRequest = attendanceRegularizationRequestAdaptor
				.uiDtoToDatabaseModel(attendanceRegularizationRequestDto);
		logger.info("AttendanceRegularizationRequest  : " + attendanceRegularizationRequest);
		attendanceRegularizationRequestService.save(attendanceRegularizationRequest);

		logger.info("save AttendanceRegularizationRequest is end  :" + attendanceRegularizationRequest);
	}

	/**
	 * to get all AttendanceRegularizationRequest List from database based on
	 * companyId
	 * 
	 * @param companyId
	 * @throws ErrorHandling
	 */
/*	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a AttendanceRegularizationRequest based on companyId ")
	@RequestMapping(value = "/all_pending/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<AttendanceRegularizationRequestDTO> getAllPendingARRequest(
			@PathVariable("companyId") Long companyId) throws ErrorHandling {
		logger.info("getAllARRequest is calling : ");
		List<Object[]> arRequestObjList = attendanceRegularizationRequestService.getAllPendingARRequest(companyId);
		logger.info("getAllARRequest is end  :" + arRequestObjList);
		if (arRequestObjList != null)
			return attendanceRegularizationRequestAdaptor.objarListToObjUiDtoList(arRequestObjList);
		else
			throw new ErrorHandling("AttendanceRegularizationRequest not found");
	}*/

	/*@RequestMapping(value = "/all_ar/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<AttendanceRegularizationRequestDTO> getAllARRequest(
			@PathVariable("companyId") Long companyId) throws ErrorHandling {
		logger.info("getAllARRequest is calling : ");
		List<Object[]> arRequestObjList = attendanceRegularizationRequestService.getAllARRequest(companyId);
		logger.info("getAllARRequest is end  :" + arRequestObjList);
		if (arRequestObjList != null)
			return attendanceRegularizationRequestAdaptor.objarListToObjUiDtoList(arRequestObjList);
		else
			throw new ErrorHandling("AttendanceRegularizationRequest not found");
	}*/

	/**
	 *
	 * to get AttendanceRegularizationRequest object from database based on arId
	 * 
	 * @param arId
	 */

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a AttendanceRegularizationRequest based on arId ")
	@RequestMapping(value = "/{arId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AttendanceRegularizationRequestDTO getARRequest(@PathVariable("arId") Long arId) {
		Employee approvalEmp = null;
		Employee employeeEmp = null;
		logger.info("getARRequest is calling : arId =" + arId);
		AttendanceRegularizationRequest arRequest = attendanceRegularizationRequestService.getARRequest(arId);
		if (arRequest.getEmployeeId() != null) {
			Long employeeId = arRequest.getEmployeeId();
			// employeeEmp = empCommonDetailService.getEmployeeCommonDetails(employeeId);
			employeeEmp = employeePersonalInformationService.getEmployeeInfo(employeeId);
		}
		if (arRequest.getApprovalId() != null) {
			Long approvalId = arRequest.getApprovalId();
			approvalEmp = employeePersonalInformationService.getEmployeeInfo(approvalId);
		}

		// logger.info("employeeDto---->" + employeeEmp.toString());

		AttendanceRegularizationRequestDTO aRRequestDto = attendanceRegularizationRequestAdaptor
				.arRequestDetailsObjToUiDto(arRequest, employeeEmp, approvalEmp);

		logger.info("AR Data->" + aRRequestDto.toString());

		return aRRequestDto;
	}

	/**
	 * to get all AttendanceRegularizationRequest List from database based on
	 * companyId
	 * 
	 * @param employeeId
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a AttendanceRegularizationRequest based on employeeId ")
	@RequestMapping(value = "/pending/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<AttendanceRegularizationRequestDTO> getEmployeePendingARRequest(
			@PathVariable("employeeId") Long employeeId) throws ErrorHandling {
		logger.info("getEmployeeARRequest is calling : ");
		List<AttendanceRegularizationRequest> attendanceRegularizationRequestList = attendanceRegularizationRequestService
				.getEmployeePendingARRequest(employeeId);

		logger.info("getEmployeeARRequest is end  :" + attendanceRegularizationRequestList);
		if (attendanceRegularizationRequestList != null)
			return attendanceRegularizationRequestAdaptor.databaseModelToUiDtoList(attendanceRegularizationRequestList);
		else
			throw new ErrorHandling("Employee AttendanceRegularizationRequest  not found");
	}

	@RequestMapping(value = "/ar_request/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<AttendanceRegularizationRequestDTO> getEmployeeARRequest(
			@PathVariable("employeeId") Long employeeId) throws ErrorHandling {
		logger.info("getEmployeeARRequest is calling : ");
		List<AttendanceRegularizationRequest> attendanceRegularizationRequestList = attendanceRegularizationRequestService
				.getEmployeeARRequest(employeeId);

		logger.info("getEmployeeARRequest is end  :" + attendanceRegularizationRequestList);
		if (attendanceRegularizationRequestList != null)
			return attendanceRegularizationRequestAdaptor.databaseModelToUiDtoList(attendanceRegularizationRequestList);
		else
			throw new ErrorHandling("Employee AttendanceRegularizationRequest  not found");
	}

	/**
	 * to get count of all pending status of AttendanceRegularizationRequest from
	 * database based on companyId and employeeId
	 * 
	 * @param employeeId
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View a count of AttendanceRegularizationRequest based on companyId and employeeId ")
	@RequestMapping(value = "/count/{companyId}/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody AttendanceRegularizationRequestDTO getArCount(@PathVariable("companyId") Long companyId,
			@PathVariable("employeeId") Long employeeId) throws ErrorHandling {

		return attendanceRegularizationRequestService.arCount(companyId, employeeId);
	}

	@RequestMapping(value = "/ar/{companyId}/{status}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AttendanceRegularizationRequestDTO> getARRequestPaging(@PathVariable("companyId") Long companyId,
			@PathVariable("status") Boolean status, @RequestBody SearchDTO searcDto) throws PayRollProcessException { //
		logger.info(" ar is calling :" + searcDto.toString());
		List<Object[]> arRequestList = aRRequestPagingAndFilterService.getARByPagingAndFilter(companyId, status,
				searcDto);

		return attendanceRegularizationRequestAdaptor.modeltoDTOList(arRequestList, searcDto);
	}

	@GetMapping(value = "/pendingARCount/{companyId}/{pageSize}/{status}")
	public @ResponseBody EntityCountDTO getPendingCount(@PathVariable("companyId") String companyId,
			@PathVariable("pageSize") String pageSize, @PathVariable("status") String status, HttpServletRequest req)
			throws PayRollProcessException {
		int count;
		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();

		Long longCompanyId = Long.parseLong(companyId);
		int parPageRecord = Integer.parseInt(pageSize);
		EntityCountDTO entityCountDto = new EntityCountDTO();
		attendanceRegularizationRequestService.getPendingARCount(longCompanyId, entityCountDto);
		count = entityCountDto.getCount();
		System.out.println("Count :" + count);
		int pages = (count + parPageRecord - 1) / parPageRecord;
		System.out.println("Pages : -" + pages);
		for (int i = 1; i <= pages; i++) {
			PageIndex pageIndex = new PageIndex();
			pageIndex.setPageIndex(i);
			pageIndexList.add(pageIndex);
		}
		entityCountDto.setPageIndexs(pageIndexList);
		entityCountDto.setCount(count);
		return entityCountDto;
	}

	@GetMapping(value = "/nonPendingARCount/{companyId}/{pageSize}/{status}")
	public @ResponseBody EntityCountDTO getNonPendingCount(@PathVariable("companyId") String companyId,
			@PathVariable("pageSize") String pageSize, @PathVariable("status") String status, HttpServletRequest req)
			throws PayRollProcessException {
		int count;
		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();

		Long longCompanyId = Long.parseLong(companyId);
		int parPageRecord = Integer.parseInt(pageSize);
		EntityCountDTO entityCountDto = new EntityCountDTO();
		attendanceRegularizationRequestService.getNonPendingARCount(longCompanyId, entityCountDto);
		count = entityCountDto.getCount();
		System.out.println("Count :" + count);
		int pages = (count + parPageRecord - 1) / parPageRecord;
		System.out.println("Pages : -" + pages);
		for (int i = 1; i <= pages; i++) {
			PageIndex pageIndex = new PageIndex();
			pageIndex.setPageIndex(i);
			pageIndexList.add(pageIndex);
		}
		entityCountDto.setPageIndexs(pageIndexList);
		entityCountDto.setCount(count);
		return entityCountDto;
	}

	/*
	 * private EmployeeDTO getEmployeeByRestTamplate(String employeeId) {
	 * logger.info("Employee Id----->" + employeeId);
	 * logger.info("getEmployeeBy RestTamplate is calling : "); String url =
	 * "http://localhost:8080/hrmsApi/employee/{employeeId}"; RestTemplate
	 * restTemplate = new RestTemplate(); HttpHeaders header = new HttpHeaders();
	 * header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); Map<String,
	 * String> params = new HashMap<>(); params.put("employeeId", employeeId);
	 * return restTemplate.getForObject(url, EmployeeDTO.class, params); }
	 */
}
