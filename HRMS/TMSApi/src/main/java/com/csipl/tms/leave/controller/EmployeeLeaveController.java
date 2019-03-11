package com.csipl.tms.leave.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.enums.GenderChartEnum;
import com.csipl.hrms.common.enums.LeaveChartEnum;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.report.Data;
import com.csipl.hrms.dto.report.EmployeeReportDTO;
import com.csipl.hrms.dto.report.GenderChart;
import com.csipl.hrms.dto.report.GenderDto;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.dto.common.PageIndex;
import com.csipl.tms.dto.common.SearchDTO;
import com.csipl.tms.dto.leave.LeaveBalanceDTO;
import com.csipl.tms.dto.leave.LeaveBalanceSummryDTO;
import com.csipl.tms.dto.leave.LeaveEntryChart;
import com.csipl.tms.dto.leave.LeaveEntryChartDTO;
import com.csipl.tms.dto.leave.LeaveEntryDTO;
import com.csipl.tms.dto.leave.TeamLeaveOnCalenderDTO;
import com.csipl.tms.empcommondetail.service.EmpCommonDetailService;
import com.csipl.tms.leave.adaptor.LeaveEntryAdaptor;
import com.csipl.tms.leave.adaptor.TMSLeaveEarnAdaptor;
import com.csipl.tms.leave.service.EmployeeLeavePaginationService;
import com.csipl.tms.leave.service.EmployeeLeaveService;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;
import com.csipl.tms.model.leave.LeaveSearchDTO;
import com.csipl.tms.model.leave.TMSLeaveEntry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description = "Operations pertaining to Leave in Time Management")
@RequestMapping("/leaveApply")
public class EmployeeLeaveController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeLeaveController.class);

	LeaveEntryAdaptor leaveEntryAdaptor = new LeaveEntryAdaptor();
	TMSLeaveEarnAdaptor tmsLeaveEarnAdaptor = new TMSLeaveEarnAdaptor();

	@Autowired
	EmployeeLeaveService employeeLeaveService;
	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	
	@Autowired
	EmpCommonDetailService empCommonDetailService;
	@Autowired
	EmployeeLeavePaginationService employeeLeavePaginationService;
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "Save or Update LeaveEntry")
	@RequestMapping( method = RequestMethod.POST)
	public void saveLeaveEntry(@RequestBody LeaveBalanceSummryDTO leaveBalanceSummryDto) throws ParseException, ErrorHandling {
		Employee employeeEmp=null;
		boolean validateLeave;
		logger.info("saveLeaveEntry is calling : leaveEntryDto " + leaveBalanceSummryDto.toString());
	
		if(leaveBalanceSummryDto.getApprovalId()==null)
		validateLeave= employeeLeaveService.validateLeaveEntry(leaveBalanceSummryDto);
		
		TMSLeaveEntry leaveEntry = leaveEntryAdaptor.uiDtoToDatabaseModel(leaveBalanceSummryDto);
		employeeLeaveService.saveLeaveEntry(leaveEntry);
		
		//logger.info("saveLeaveEntry is end  :" + leaveEntry.toString());
	}

	/**
	 * @param leaveId
	 *            to get leaveEntrie object from database based on leavId
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value="/{leaveId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LeaveEntryDTO getLeaveEntry(@PathVariable("leaveId") Long leaveId) {
	
		logger.info("getLeaveEntry is calling : leaveId =>>" + leaveId);
		LeaveEntryDTO leaveEntryDto = employeeLeaveService.getLeaveEntry(leaveId);
		logger.info("getLeaveEntry is end   leaveEntry=>>:" + leaveEntryDto.toString());

	
	//logger.info("getLeaveEntry employeeDto---->" + employeeEmp.toString());
		return leaveEntryDto;
	}

	/**
	 * @param employeeId
	 *            to get all leaveEntries object from database based on employeeId
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View List of LeaveEntry  of Employee based on employeeId ")
	@RequestMapping(value = "/employeeLeaveEntry/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<LeaveEntryDTO> getEmployeeLeaveEntry(@PathVariable("employeeId") Long employeeId) {
		logger.info("getEmployeeLeaveEntry is calling : employeeId =>>" + employeeId);
		List<TMSLeaveEntry> employeeLeaveEntryList = employeeLeaveService.getEmployeeLeaveEntry(employeeId);
		return leaveEntryAdaptor.databaseModelToUiDtoList(employeeLeaveEntryList);
	}
	/**
	 * @param employeeId
	 *            to get all leaveEntries object from database based on employeeId
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "View  Pending LeaveEntry List of Employee based on employee Id")
	@RequestMapping(value = "/employeePendingLeaveEntry/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<LeaveEntryDTO> getEmployeePendingLeaveEntry(@PathVariable("employeeId") Long employeeId) {
		logger.info("getEmployeeLeaveEntry is calling : employeeId =>>" + employeeId);
		List<TMSLeaveEntry> employeeLeaveEntryList = employeeLeaveService.getEmployeePendingLeaveEntry(employeeId);
		return leaveEntryAdaptor.databaseModelToUiDtoList(employeeLeaveEntryList);
	}

	/**
	 * @param companyId
	 *            to get all leaveEntries from database based on companyId
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "View List of leaveEntries based on company ID")
	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody List<LeaveEntryDTO> getleaveEntryList(@RequestParam("companyId") Long companyId) {
		logger.info(" getleaveEntryList is calling companyId >>:" + companyId);
		List<Object[]> objLeaveEntryList = employeeLeaveService.leaveEntryList(companyId);
		return leaveEntryAdaptor.databaseObjToUiDtoList(objLeaveEntryList);
	}

	/**
	 * @param employeId
	 *            to get all leave balance calculation based on employeeId
	 */
/*	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "View List of leave Balance List of Employee based on employee ID")
	@RequestMapping(value = "/leaveBalance/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LeaveBalanceDTO> getEmployeeLeaveBalanceList(
			@PathVariable("employeeId") Long employeeId) {
		logger.info("getEmployeeLeaveBalanceList employeeId--->" + employeeId);
		return employeeLeaveService.getEmployeeLeaveBalance(employeeId);
	}
*/
	/**
	 * @param leaveEntryDto
	 *            to get actual leave applied days based on leave apply from date
	 *            and leave apply to date
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "get actual leave applied days ")
	@RequestMapping(value = "/appliedLeaveDays", method = RequestMethod.POST)
	public BigDecimal appliedLeaveDays(@RequestBody LeaveEntryDTO leaveEntryDto) throws ParseException {
		logger.info("appliedLeaveDays is calling : leaveEntryDto " + leaveEntryDto.toString());
		BigDecimal appliedLeaveDays = employeeLeaveService.appliedLeaveDays(leaveEntryDto);
		logger.info("appliedLeaveDays: leaveEntryDto " + appliedLeaveDays);
		return appliedLeaveDays;
	}

	/**
	 * @param employeeId
	 *            to get employee object based on employee id
	 */
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

	/**
	 * @param employeeId
	 *            to get all leaveEntries object from database based on employeeId
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@ApiOperation(value = "View  Approved or rejected LeaveEntry List of Employee based on employee Id")
	@RequestMapping(value = "/empLeaveEntry/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<LeaveEntryDTO> getEmployeeApprovedLeaveEntry(
			@PathVariable("employeeId") Long employeeId) {
		logger.info("getEmployeeLeaveEntry is calling : employeeId =>>" + employeeId);
		List<TMSLeaveEntry> employeeLeaveEntryList = employeeLeaveService.getEmployeeApprovedLeaveEntry(employeeId);
		return leaveEntryAdaptor.databaseModelToUiDtoList(employeeLeaveEntryList);
	}
	
	/**
	 * @param employeeId
	 *            to get all leaveEntries object from database based on employeeId
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@ApiOperation(value = "View  Approved or rejected LeaveEntry List of Employee based on company Id")
	@RequestMapping(value = "/allEmpLeaveEntry/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<LeaveEntryDTO> getAllEmployeeApprovedLeaveEntry(
			@PathVariable("companyId") Long companyId) {
		logger.info("getEmployeeLeaveEntry is calling : companyId =>>" + companyId);
		List<TMSLeaveEntry> employeeLeaveEntryList = employeeLeaveService.getAllEmployeeApprovedLeaveEntry(companyId);
		return leaveEntryAdaptor.databaseModelToUiDtoList(employeeLeaveEntryList);
	}
	
	
	
	/**
	 * @param employeeId,companyId
	 *           to get count of all pending status of LeaveEntryDTO from database based on companyId and employeeId 
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@ApiOperation(value = "View  count of leaveEntry based on company Id and employeeId")
	@RequestMapping(value = "/count/{companyId}/{employeeId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LeaveEntryDTO getLeaveCount(
			@PathVariable("companyId") Long companyId ,@PathVariable("employeeId") Long employeeId) {
		logger.info("leaveCount is calling : companyId =>>" + companyId);
		return employeeLeaveService.leaveCount(companyId,employeeId);
	}
	@GetMapping(value = "/entitycount/{companyId}/{pageSize}")
	public @ResponseBody EntityCountDTO getAllEmployeeCount(@PathVariable("companyId") String companyId,
			@PathVariable("pageSize") String pageSize, HttpServletRequest req) throws PayRollProcessException {

		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();
		int count;
		Long longCompanyId = Long.parseLong(companyId);
		int parPageRecord = Integer.parseInt(pageSize);
		EntityCountDTO entityCountDto = new EntityCountDTO();
		employeeLeavePaginationService.getEntityCount(longCompanyId, entityCountDto);
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
	@GetMapping(value = "/pendingEntitycount/{companyId}/{pageSize}")
	public @ResponseBody EntityCountDTO getPendingEmployeeCount(@PathVariable("companyId") String companyId,
			@PathVariable("pageSize") String pageSize, HttpServletRequest req) throws PayRollProcessException {

		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();
		int count;
		Long longCompanyId = Long.parseLong(companyId);
		int parPageRecord = Integer.parseInt(pageSize);
		EntityCountDTO entityCountDto = new EntityCountDTO();
		employeeLeavePaginationService.getPendingEntityCount(longCompanyId, entityCountDto);
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
	
	/**
	 * to get all employees List from data base based of company
	 * 
	 * @throws PayRollProcessException
	 */

	@RequestMapping(value = "/searchEntity",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LeaveEntryDTO> searchPendingEmployeeLeaveDetails(@RequestBody LeaveSearchDTO leavesearchDto)
			throws PayRollProcessException {
		logger.info(" active employees is calling :");

		List<Object[]> employeeLeaveList = employeeLeavePaginationService
				.getPendingEmployeeLeavebyPagination(leavesearchDto.getCompanyId(), leavesearchDto);
		
		List<LeaveEntryDTO> leaveEntryDtoList= leaveEntryAdaptor.modeltoDTOList(employeeLeaveList, leavesearchDto);
		return leaveEntryDtoList;
		
	}
	
	/**
	 * @param employeId
	 *            to get all leave balance summry  based on employeeId
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "View List of leave Balance List of Employee based on employee ID")
	@RequestMapping(value = "/leaveBalance/{employeeId}/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LeaveBalanceSummryDTO> getEmployeeLeaveBalanceSummryList(
			@PathVariable("employeeId") Long employeeId,@PathVariable("companyId") Long companyId) {
		logger.info("getEmployeeLeaveBalanceList employeeId--->" + employeeId);
		return employeeLeaveService.getEmployeeLeaveBalanceSummry(employeeId,companyId);
	}
	
	
	/**
	 * @param employeId
	 *            to get all team leave of all month  based on employeeId and current date
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@ApiOperation(value = "View List of leave Balance List of Employee based on employee ID")

	@RequestMapping(value = "/teamonleave/{employeeId}/{currentDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TeamLeaveOnCalenderDTO> TeamOnLeave(@PathVariable("employeeId") String employeeId,@PathVariable("currentDate") String currentDate) {
		logger.info("getEmployeeLeaveBalanceList employeeId--->" + employeeId);
		logger.info("getEmployeeLeaveBalanceList employeeId--->" + currentDate);
		
		return employeeLeaveService.getTeamLeaveOnCalender(employeeId,currentDate);
	}
	
	
	@RequestMapping(path = "/leaveWiseRatio/{employeeId}/{companyId}", method = RequestMethod.GET)
	public @ResponseBody LeaveEntryChartDTO empleaveWiseRatio(@PathVariable("employeeId") Long employeeId,@PathVariable("companyId") Long companyId) throws ErrorHandling, PayRollProcessException {
		
		List<LeaveBalanceSummryDTO> leaveBlanceList = employeeLeaveService.getEmployeeLeaveBalanceSummry(employeeId,companyId);
		logger.info("empleaveWiseRatio employeeId--->" + employeeId);
		BigDecimal sumBalanceLeave=new BigDecimal(0),sumConsumedLeave=new BigDecimal(0);
		for (LeaveBalanceSummryDTO leaveBalanceSummryDTO : leaveBlanceList) {
		
			sumBalanceLeave=sumBalanceLeave.add(leaveBalanceSummryDTO.getLeaveBalancedCount());
			sumConsumedLeave=sumConsumedLeave.add(leaveBalanceSummryDTO.getLeaveConsumedCount());
		}
		ArrayList<Data> arrayData = new ArrayList<Data>();

		LeaveEntryChart chart = new LeaveEntryChart(LeaveChartEnum.showBorder.getPieChartValue(),
				LeaveChartEnum.use3DLighting.getPieChartValue(), LeaveChartEnum.enableSmartLabels.getPieChartValue(),
				LeaveChartEnum.startingAngle.getPieChartValue(), LeaveChartEnum.showLabels.getPieChartValue(),
				LeaveChartEnum.showPercentValues.getPieChartValue(), LeaveChartEnum.showLegend.getPieChartValue(),
				LeaveChartEnum.centerLabelBold.getPieChartValue(), LeaveChartEnum.showTooltip.getPieChartValue(),
				LeaveChartEnum.decimals.getPieChartValue(),
				LeaveChartEnum.useDataPlotColorForLabels.getPieChartValue(), LeaveChartEnum.theme.getPieChartValue(),
				LeaveChartEnum.chartLeftMargin.getPieChartValue(),LeaveChartEnum.chartRightMargin.getPieChartValue(),LeaveChartEnum.defaultCenterLabel.getPieChartValue(),LeaveChartEnum.centerLabelColor.getPieChartValue(),LeaveChartEnum.doughnutRadius.getPieChartValue());

	//	for (LeaveBalanceSummryDTO empDt : leaveBlanceList) {
		logger.info("empleaveWiseRatio sumBalanceLeave.toString()--->" +sumBalanceLeave +"---umConsumedLeave.toString()---"+sumConsumedLeave);
			Data BalanceData = new Data("Balance", sumBalanceLeave.toString(), "");
			Data consumedData = new Data("Consumed", sumConsumedLeave.toString(), "fd3c94");
			
			
			arrayData.add(BalanceData);
			arrayData.add(consumedData);
			
		//}

			LeaveEntryChartDTO gt = new LeaveEntryChartDTO(chart, arrayData);

		return gt;

	}
	
}
