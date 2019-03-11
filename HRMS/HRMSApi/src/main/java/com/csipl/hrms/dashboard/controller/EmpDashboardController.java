package com.csipl.hrms.dashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.common.enums.AgeChartEnum;
import com.csipl.hrms.common.enums.AttritionEnum;
import com.csipl.hrms.common.enums.DepartmentGraphEnum;
import com.csipl.hrms.common.enums.DesignationChartEnum;
import com.csipl.hrms.common.enums.GenderChartEnum;
import com.csipl.hrms.common.enums.GraphEnum;
import com.csipl.hrms.common.enums.PFlageEnum;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.report.AgeChart;
import com.csipl.hrms.dto.report.AgeData;
import com.csipl.hrms.dto.report.AgeDto;
import com.csipl.hrms.dto.report.AttendanceChart;
import com.csipl.hrms.dto.report.AttendanceData;
import com.csipl.hrms.dto.report.AttendanceDto;
import com.csipl.hrms.dto.report.AttritionChart;
import com.csipl.hrms.dto.report.AttritionDto;
import com.csipl.hrms.dto.report.Category;
import com.csipl.hrms.dto.report.Chart;
import com.csipl.hrms.dto.report.Data;
import com.csipl.hrms.dto.report.DataJoined;
import com.csipl.hrms.dto.report.DataResigned;
import com.csipl.hrms.dto.report.DatasetJoined;
import com.csipl.hrms.dto.report.DatasetResigned;
import com.csipl.hrms.dto.report.DepartmentChart;
import com.csipl.hrms.dto.report.DepartmentChartDto;
import com.csipl.hrms.dto.report.DepartmentChartEmpMaster;
import com.csipl.hrms.dto.report.DepartmentData;
import com.csipl.hrms.dto.report.DepartmentReportDTO;
import com.csipl.hrms.dto.report.DesignationChartDto;
import com.csipl.hrms.dto.report.DesignationChartEmpMaster;
import com.csipl.hrms.dto.report.DesignationData;
import com.csipl.hrms.dto.report.EmployeeReportDTO;
import com.csipl.hrms.dto.report.GenderChart;
import com.csipl.hrms.dto.report.GenderDto;
import com.csipl.hrms.dto.report.GraphDto;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.report.DepartmentReportService;
import com.csipl.hrms.service.report.EmployeeReportService;

@RestController
public class EmpDashboardController  {

	@Autowired
	EmployeeReportService employeeReportService;

	@Autowired
	DepartmentReportService departmentReportService;

	@RequestMapping(path = "/countNotification", method = RequestMethod.GET)
	public @ResponseBody EmployeeReportDTO countNotificationApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		EmployeeReportDTO employeeReportDTO = employeeReportService.countNotification(companyIdValue);
		if (employeeReportDTO != null)
			return employeeReportDTO;
		else
			throw new ErrorHandling("Data Not Found");

	}
	

	// countNotificationForSessionRole

	@RequestMapping(path = "/countNotificationForSessionRole", method = RequestMethod.GET)
	public @ResponseBody EmployeeReportDTO countNotificationForSessionRole(
			@RequestParam("currentRole") String currentRole,@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException

	{
		HttpSession session = req.getSession();
		session.setAttribute("currentRole", currentRole);
		Long companyIdValue=Long.parseLong(companyId);
		EmployeeReportDTO employeeReportDTO = employeeReportService.countNotification(companyIdValue);
		if (employeeReportDTO != null)
			return employeeReportDTO;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/employeeNotification", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> employeeNotificationApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.employeeNotification(companyIdValue,
				PFlageEnum.Notification.getpFlageEnum());
		if (empList != null)
			return empList;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empGenderWiseRatio", method = RequestMethod.GET)
	public @ResponseBody GenderDto empGenderWiseRatioApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> employeeReportDTO = employeeReportService.empGenderWiseRatio(companyIdValue);

		ArrayList<Data> arrayData = new ArrayList<Data>();

		GenderChart chart = new GenderChart(GenderChartEnum.showBorder.getPieChartValue(),
				GenderChartEnum.use3DLighting.getPieChartValue(), GenderChartEnum.enableSmartLabels.getPieChartValue(),
				GenderChartEnum.startingAngle.getPieChartValue(), GenderChartEnum.showLabels.getPieChartValue(),
				GenderChartEnum.showPercentValues.getPieChartValue(), GenderChartEnum.showLegend.getPieChartValue(),
				GenderChartEnum.centerLabelBold.getPieChartValue(), GenderChartEnum.showTooltip.getPieChartValue(),
				GenderChartEnum.decimals.getPieChartValue(),
				GenderChartEnum.useDataPlotColorForLabels.getPieChartValue(), GenderChartEnum.theme.getPieChartValue());

		for (EmployeeReportDTO empDt : employeeReportDTO) {
			Data maleData = new Data("Male", empDt.getMalePer(), "");
			Data femaleData = new Data("Female", empDt.getFemalePer(), "fd3c94");
			Data other=null;
			if(empDt.getOtherPer().equalsIgnoreCase("0%")) {
				
			}else {
				other = new Data("Not Available", empDt.getOtherPer(), "");	
			}
			
			arrayData.add(maleData);
			arrayData.add(femaleData);
			arrayData.add(other);
		}

		GenderDto gt = new GenderDto(chart, arrayData);

		return gt;

	}
	@RequestMapping(path = "/empAgeWiseRatio", method = RequestMethod.GET)
	public @ResponseBody AgeDto empAgeWiseRatioApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> employeeReportDTO = employeeReportService.empAgeWiseRatio(companyIdValue);

		ArrayList<AgeData> arrayData = new ArrayList<AgeData>();

		AgeChart chart = new AgeChart(AgeChartEnum.formatnumberscale.getPieChartValue(),
				AgeChartEnum.use3DLighting.getPieChartValue(), AgeChartEnum.enableSmartLabels.getPieChartValue(),
				AgeChartEnum.startingAngle.getPieChartValue(), AgeChartEnum.showLabels.getPieChartValue(),
				AgeChartEnum.showPercentValues.getPieChartValue(), AgeChartEnum.showLegend.getPieChartValue(),
				AgeChartEnum.centerLabelBold.getPieChartValue(), AgeChartEnum.showTooltip.getPieChartValue(),
				AgeChartEnum.decimals.getPieChartValue(), AgeChartEnum.useDataPlotColorForLabels.getPieChartValue(),
				AgeChartEnum.theme.getPieChartValue());

		for (EmployeeReportDTO empDt : employeeReportDTO) {
			if(empDt.getEmpAge().equalsIgnoreCase("0")) {
				
			}else {
				AgeData data = new AgeData(empDt.getEmpRange(), empDt.getEmpAge());
				arrayData.add(data);
			}
			
		}

		AgeDto at = new AgeDto(chart, arrayData);

		return at;

	}
	@RequestMapping(path = "/empAttendanceRatio", method = RequestMethod.GET)
	public @ResponseBody AttendanceDto empAttendanceMonthly(@RequestParam("companyId") String companyId,@RequestParam("employeeId") String employeeId) throws ErrorHandling, PayRollProcessException {
		
		Long companyIdValue=Long.parseLong(companyId);
		Long employeeIdValue=Long.parseLong(employeeId);
		List<EmployeeReportDTO> employeeReportDTO = employeeReportService.empAttendanceRatio(companyIdValue,employeeIdValue);

		ArrayList<AttendanceData> arrayData = new ArrayList<AttendanceData>();

		AttendanceChart chart = new AttendanceChart(AgeChartEnum.formatnumberscale.getPieChartValue(),
				AgeChartEnum.use3DLighting.getPieChartValue(), AgeChartEnum.enableSmartLabels.getPieChartValue(),
				AgeChartEnum.startingAngle.getPieChartValue(), AgeChartEnum.showLabels.getPieChartValue(),
				AgeChartEnum.showPercentValues.getPieChartValue(), AgeChartEnum.showLegend.getPieChartValue(),
				AgeChartEnum.centerLabelBold.getPieChartValue(), AgeChartEnum.showTooltip.getPieChartValue(),
				AgeChartEnum.decimals.getPieChartValue(), AgeChartEnum.useDataPlotColorForLabels.getPieChartValue(),
				AgeChartEnum.theme.getPieChartValue());

		for (EmployeeReportDTO empDt : employeeReportDTO) {
			if(empDt.getEmpAttenance().equalsIgnoreCase("0")) {
				
			}else {
				AttendanceData data = new AttendanceData(empDt.getEmpAttendanceeRange(), empDt.getEmpAttenance());
				arrayData.add(data);
			}
			
		}

		AttendanceDto at = new AttendanceDto(chart, arrayData);
        System.out.println("attendance dto.."+at.toString());
		return at;

	}


	@RequestMapping(path = "/empDashboardInfo", method = RequestMethod.GET)
	public @ResponseBody EmployeeReportDTO EmployeeDashboardInfoApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		EmployeeReportDTO employeeReportDTO = employeeReportService.countEMPIMPTODAYDATE(companyIdValue, "");
		if (employeeReportDTO != null)
			return employeeReportDTO;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empBirthDayInfo", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> EmployeeBirthDayInfo(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		System.out.println(" empBirthDayInfo ");
		List<EmployeeReportDTO> empBirthDayList = employeeReportService.fetchBirthDayEmpList(companyIdValue,
				PFlageEnum.BirthDay.getpFlageEnum());
		if (empBirthDayList.size() > 0)
			return empBirthDayList;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empAnniversaryInfo", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> EmployeeAnniverSaryInfoApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> empAnniversaryList = employeeReportService.fetchAnniversaryDayEmpList(companyIdValue,
				PFlageEnum.Anniversary.getpFlageEnum());
		if (empAnniversaryList.size() > 0)
			return empAnniversaryList;
		else
			throw new ErrorHandling("Data Not Found");

	}


	@RequestMapping(path = "/empWorkAnniversaryInfo", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> EmployeeWorkAnniverSaryInfoApp(@RequestParam("companyId") String companyId)
			throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> empAnniversaryList = employeeReportService
				.fetchWorkAnniversaryDayEmpList(companyIdValue, PFlageEnum.Joinig.getpFlageEnum());
		if (empAnniversaryList.size() > 0)
			return empAnniversaryList;
		else
			throw new ErrorHandling("Data Not Found");

	}
	@RequestMapping(path = "/employeeDocumentConfirmationInfo", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> EmployeeDocumentConfirmationInfo(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empAnniversaryList = employeeReportService
				.fetchEmployeeDocumentConfirmation(longcompanyId);
		if (empAnniversaryList.size() > 0)
			return empAnniversaryList;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/employeeSeprationInfo", method = RequestMethod.GET)

	public @ResponseBody List<EmployeeReportDTO> EmployeeSeprationInfo(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empAnniversaryList = employeeReportService
				.fetchEmployeeSeprationInfo(longcompanyId);
		if (empAnniversaryList.size() > 0)
			return empAnniversaryList;
		else
			throw new ErrorHandling("Data Not Found");
	}

	@RequestMapping(path = "/empCountByDesignationWise", method = RequestMethod.GET)
	public @ResponseBody DesignationChartDto empCountByDesignationWise(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.empCountByDesignationWise(longcompanyId);
		ArrayList<DesignationData> arrayData = new ArrayList<DesignationData>();

		DesignationChartEmpMaster chart = new DesignationChartEmpMaster(DesignationChartEnum.caption.getPieChartValue(),
				"", DesignationChartEnum.formatnumberscale.getPieChartValue(),
				DesignationChartEnum.showBorder.getPieChartValue(),
				DesignationChartEnum.use3DLighting.getPieChartValue(),
				DesignationChartEnum.enableSmartLabels.getPieChartValue(),
				DesignationChartEnum.startingAngle.getPieChartValue(),
				DesignationChartEnum.showLabels.getPieChartValue(),
				DesignationChartEnum.showPercentValues.getPieChartValue(),
				DesignationChartEnum.showLegend.getPieChartValue(),
				DesignationChartEnum.thousandSeparatorPosition.getPieChartValue(),
				DesignationChartEnum.baseFont.getPieChartValue(), DesignationChartEnum.baseFontSize.getPieChartValue(),
				DesignationChartEnum.baseFontColor.getPieChartValue(),
				DesignationChartEnum.centerLabelBold.getPieChartValue(),
				DesignationChartEnum.showTooltip.getPieChartValue(), DesignationChartEnum.decimals.getPieChartValue(),
				DesignationChartEnum.useDataPlotColorForLabels.getPieChartValue(),
				DesignationChartEnum.theme.getPieChartValue());

		// System.out.println("==========="+chart.getTheme()+"======"+chart.getStartingangle()+"==="+chart.getEnablemultislicing());
		for (EmployeeReportDTO empDt : empList) {
			if (empDt.getEmpCount().equalsIgnoreCase("0")) {

			} else {
				DesignationData data = new DesignationData(empDt.getEmpDesignation(), empDt.getEmpCount());
				arrayData.add(data);

			}

		}

		DesignationChartDto dt = new DesignationChartDto(chart, arrayData);

		return dt;

	}

	@RequestMapping(path = "/empCountByDepartmentWise", method = RequestMethod.GET)
	public @ResponseBody DepartmentChartDto empCountByDepartmentWise(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.empCountByDepartmentWise(longcompanyId);
		ArrayList<DepartmentData> arrayData = new ArrayList<DepartmentData>();

		DepartmentChartEmpMaster chart = new DepartmentChartEmpMaster(DesignationChartEnum.caption.getPieChartValue(),
				"", DesignationChartEnum.formatnumberscale.getPieChartValue(),
				DesignationChartEnum.showBorder.getPieChartValue(),
				DesignationChartEnum.use3DLighting.getPieChartValue(),
				DesignationChartEnum.enableSmartLabels.getPieChartValue(),
				DesignationChartEnum.startingAngle.getPieChartValue(),
				DesignationChartEnum.showLabels.getPieChartValue(),
				DesignationChartEnum.showPercentValues.getPieChartValue(),
				DesignationChartEnum.showLegend.getPieChartValue(),
				DesignationChartEnum.thousandSeparatorPosition.getPieChartValue(),
				DesignationChartEnum.baseFont.getPieChartValue(), DesignationChartEnum.baseFontSize.getPieChartValue(),
				DesignationChartEnum.baseFontColor.getPieChartValue(),
				DesignationChartEnum.centerLabelBold.getPieChartValue(),
				DesignationChartEnum.showTooltip.getPieChartValue(), DesignationChartEnum.decimals.getPieChartValue(),
				DesignationChartEnum.useDataPlotColorForLabels.getPieChartValue(),

				DesignationChartEnum.theme.getPieChartValue());

		// System.out.println("==========="+chart.getTheme()+"======"+chart.getStartingangle()+"==="+chart.getEnablemultislicing());
		for (EmployeeReportDTO empDt : empList) {
			if (empDt.getEmpCount().equalsIgnoreCase("0")) {

			} else {
				DepartmentData data = new DepartmentData(empDt.getEmpDetp(), empDt.getEmpCount());
				arrayData.add(data);

			}

		}

		DepartmentChartDto dt = new DepartmentChartDto(chart, arrayData);

		return dt;

	}

	// Department Wise CTC

	@RequestMapping(path = "/departmentWiseCTCInfo", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.payroll.dashboard.GraphDto DepartmentWiseCTCInfo(
			@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<DepartmentReportDTO> deptReportDto = departmentReportService.departmentWiseCTC(longcompanyId, 0L);
		ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data>();

		com.csipl.hrms.dto.payroll.dashboard.Chart chart = new com.csipl.hrms.dto.payroll.dashboard.Chart(
				DepartmentGraphEnum.caption.getPieChartValue(), DepartmentGraphEnum.numberPrefix.getPieChartValue(),
				DepartmentGraphEnum.formatnumberscale.getPieChartValue(),
				DepartmentGraphEnum.showBorder.getPieChartValue(), DepartmentGraphEnum.use3DLighting.getPieChartValue(),
				DepartmentGraphEnum.enableSmartLabels.getPieChartValue(),
				DepartmentGraphEnum.startingAngle.getPieChartValue(), DepartmentGraphEnum.showLabels.getPieChartValue(),
				DepartmentGraphEnum.showPercentValues.getPieChartValue(),
				DepartmentGraphEnum.showLegend.getPieChartValue(),
				DepartmentGraphEnum.thousandSeparatorPosition.getPieChartValue(),
				DepartmentGraphEnum.baseFont.getPieChartValue(), DepartmentGraphEnum.baseFontSize.getPieChartValue(),
				DepartmentGraphEnum.baseFontColor.getPieChartValue(),
				DepartmentGraphEnum.centerLabelBold.getPieChartValue(),
				DepartmentGraphEnum.showTooltip.getPieChartValue(), DepartmentGraphEnum.decimals.getPieChartValue(),
				DepartmentGraphEnum.theme.getPieChartValue()

		);
		for (DepartmentReportDTO deptDt : deptReportDto) {
			System.out.println("departmentWiseCTCInfo" + deptDt.getDeptNAME());
			com.csipl.hrms.dto.payroll.dashboard.Data data = new com.csipl.hrms.dto.payroll.dashboard.Data(
					deptDt.getDeptNAME(), deptDt.getDeptCTC());
			arrayData.add(data);
		}

		com.csipl.hrms.dto.payroll.dashboard.GraphDto gt = new com.csipl.hrms.dto.payroll.dashboard.GraphDto(chart,
				arrayData);
		// arrayData.clear();
		return gt;
	}

	@RequestMapping(path = "/departmentWiseCTCInfoWithMonth", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.payroll.dashboard.GraphDto DepartmentWiseCTCInfoWithMonth(
			@RequestParam("processMonth") String processMonth,@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long p_process_month = Long.parseLong(processMonth);
		Long longcompanyId = Long.parseLong(companyId);
		List<DepartmentReportDTO> deptReportDto = departmentReportService.departmentWiseCTC(longcompanyId,
				p_process_month);
		ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data>();

		com.csipl.hrms.dto.payroll.dashboard.Chart chart = new com.csipl.hrms.dto.payroll.dashboard.Chart(
				DepartmentGraphEnum.caption.getPieChartValue(), DepartmentGraphEnum.numberPrefix.getPieChartValue(),
				DepartmentGraphEnum.formatnumberscale.getPieChartValue(),
				DepartmentGraphEnum.showBorder.getPieChartValue(), DepartmentGraphEnum.use3DLighting.getPieChartValue(),
				DepartmentGraphEnum.enableSmartLabels.getPieChartValue(),
				DepartmentGraphEnum.startingAngle.getPieChartValue(), DepartmentGraphEnum.showLabels.getPieChartValue(),
				DepartmentGraphEnum.showPercentValues.getPieChartValue(),
				DepartmentGraphEnum.showLegend.getPieChartValue(),
				DepartmentGraphEnum.thousandSeparatorPosition.getPieChartValue(),
				DepartmentGraphEnum.baseFont.getPieChartValue(), DepartmentGraphEnum.baseFontSize.getPieChartValue(),
				DepartmentGraphEnum.baseFontColor.getPieChartValue(),
				DepartmentGraphEnum.centerLabelBold.getPieChartValue(),
				DepartmentGraphEnum.showTooltip.getPieChartValue(), DepartmentGraphEnum.decimals.getPieChartValue(),
				DepartmentGraphEnum.theme.getPieChartValue()

		);
		for (DepartmentReportDTO deptDt : deptReportDto) {

			com.csipl.hrms.dto.payroll.dashboard.Data data = new com.csipl.hrms.dto.payroll.dashboard.Data(
					deptDt.getDeptNAME(), deptDt.getDeptCTC());
			arrayData.add(data);
		}

		com.csipl.hrms.dto.payroll.dashboard.GraphDto gt = new com.csipl.hrms.dto.payroll.dashboard.GraphDto(chart,
				arrayData);

		return gt;
	}

	// Designation Wise CTC

	@RequestMapping(path = "/designationWiseCTCInfo", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.payroll.dashboard.GraphDto DesignationWiseCTCInfo(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.fetchDesignationWiseCTC(companyIdValue, 0L);
		ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data>();
        
		com.csipl.hrms.dto.payroll.dashboard.Chart chart = new com.csipl.hrms.dto.payroll.dashboard.Chart("", "₹", "0",
				"0", "1", "0", "310", "1", "0", "1", "2,3", "Verdana", "11", "#333333 ", "0", "1", "0", "FintTheme"

		);
		for (EmployeeReportDTO emptDt : empList) {
			System.out.println("designationWiseCTCInfo" + emptDt.getEmpDesignation());
			com.csipl.hrms.dto.payroll.dashboard.Data data = new com.csipl.hrms.dto.payroll.dashboard.Data(
					emptDt.getEmpDesignation(), emptDt.getEmpCtc());
			arrayData.add(data);
		}

		com.csipl.hrms.dto.payroll.dashboard.GraphDto gt = new com.csipl.hrms.dto.payroll.dashboard.GraphDto(chart,
				arrayData);
		// arrayData.clear();
		return gt;

	}

	@RequestMapping(path = "/designationWiseCTCInfoWithMonth", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.payroll.dashboard.GraphDto DesignationWiseCTCInfo(
			@RequestParam("processMonth") String processMonth,@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);

		Long p_process_month = Long.parseLong(processMonth);
		List<EmployeeReportDTO> empList = employeeReportService.fetchDesignationWiseCTC(longcompanyId,
				p_process_month);
		ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data>();
		com.csipl.hrms.dto.payroll.dashboard.Chart chart = new com.csipl.hrms.dto.payroll.dashboard.Chart("", "₹", "0",
				"0", "1", "0", "310", "1", "0", "1", "2,3", "Verdana", "11", "#333333 ", "0", "1", "0", "FintTheme"

		);
		for (EmployeeReportDTO emptDt : empList) {
			System.out.println("designationWiseCTCInfo" + emptDt.getEmpDesignation());
			com.csipl.hrms.dto.payroll.dashboard.Data data = new com.csipl.hrms.dto.payroll.dashboard.Data(
					emptDt.getEmpDesignation(), emptDt.getEmpCtc());
			arrayData.add(data);
		}

		com.csipl.hrms.dto.payroll.dashboard.GraphDto gt = new com.csipl.hrms.dto.payroll.dashboard.GraphDto(chart,
				arrayData);
		// arrayData.clear();
		return gt;

	}

	// Bank Percentage headcount_by_bankpay

	@RequestMapping(path = "/headCountByBankPayInfo", method = RequestMethod.GET)
	public @ResponseBody GraphDto HeadCountByBankPay(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);

		List<EmployeeReportDTO> empList = employeeReportService.fetchHeadCountByBankPay(longcompanyId);
		/*
		 * if(empList.size()>0 ) return empList; else throw new
		 * ErrorHandling("Data Not Found");
		 */

		ArrayList<Data> arrayData = new ArrayList<Data>();
		Chart chart = new Chart(GraphEnum.numberPrefix.getPieChartValue(), GraphEnum.decimals.getPieChartValue(),
				GraphEnum.skipOverlapLabels.getPieChartValue(), GraphEnum.theme.pieChartValue);
		for (EmployeeReportDTO empDt : empList) {
			Data data = new Data(empDt.getEmpBankName(), empDt.getBankPer());
			arrayData.add(data);
		}

		GraphDto gt = new GraphDto(chart, arrayData);

		return gt;
	}

	// Bank Percentage headcount_by_bankpay

	@RequestMapping(path = "/empPayrollStatus", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> empPayrollstatusbyMonth(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.empPayrollstatusbyMonth(longcompanyId);
		if (empList != null)
			return empList;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empPFContributionInfo", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.esipf.dashboard.GraphDto EmpPfContribution(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.fetchEmpPfContribution(longcompanyId, 0L);
		ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data>();
		com.csipl.hrms.dto.esipf.dashboard.Chart chart = new com.csipl.hrms.dto.esipf.dashboard.Chart(
				GraphEnum.numberPrefix.getPieChartValue(), GraphEnum.formatnumberscale.getPieChartValue(),
				GraphEnum.decimals.getPieChartValue(), GraphEnum.skipOverlapLabels.getPieChartValue(),
				GraphEnum.theme.getPieChartValue());
		for (EmployeeReportDTO empDt : empList) {

			if (empDt.getAmtEmployee() != null) {
				com.csipl.hrms.dto.esipf.dashboard.Data data = new com.csipl.hrms.dto.esipf.dashboard.Data("Employee",
						empDt.getAmtEmployee());
				arrayData.add(data);

			}
			if (empDt.getAmtEmployer() != null) {

				com.csipl.hrms.dto.esipf.dashboard.Data data1 = new com.csipl.hrms.dto.esipf.dashboard.Data("Employer",
						empDt.getAmtEmployer());
				arrayData.add(data1);

			}
			if (empDt.getAmtPension() != null) {

				com.csipl.hrms.dto.esipf.dashboard.Data data2 = new com.csipl.hrms.dto.esipf.dashboard.Data("Pension",
						empDt.getAmtPension());
				arrayData.add(data2);

			}

		}

		com.csipl.hrms.dto.esipf.dashboard.GraphDto gt = new com.csipl.hrms.dto.esipf.dashboard.GraphDto(chart,
				arrayData);

		return gt;

	}

	@RequestMapping(path = "/empPFContributionInfoWithMonth", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.esipf.dashboard.GraphDto EmpPfContributionWithMonth(
			@RequestParam("processMonth") String processMonth,@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long p_process_month = Long.parseLong(processMonth);
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.fetchEmpPfContribution(longcompanyId,
				p_process_month);
		ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data>();
		com.csipl.hrms.dto.esipf.dashboard.Chart chart = new com.csipl.hrms.dto.esipf.dashboard.Chart(
				GraphEnum.numberPrefix.getPieChartValue(), GraphEnum.formatnumberscale.getPieChartValue(),
				GraphEnum.decimals.getPieChartValue(), GraphEnum.skipOverlapLabels.getPieChartValue(),
				GraphEnum.theme.getPieChartValue());
		for (EmployeeReportDTO empDt : empList) {

			com.csipl.hrms.dto.esipf.dashboard.Data data = new com.csipl.hrms.dto.esipf.dashboard.Data("Employee",
					empDt.getAmtEmployee());
			arrayData.add(data);

			com.csipl.hrms.dto.esipf.dashboard.Data data1 = new com.csipl.hrms.dto.esipf.dashboard.Data("Employer",
					empDt.getAmtEmployer());
			arrayData.add(data1);

			com.csipl.hrms.dto.esipf.dashboard.Data data2 = new com.csipl.hrms.dto.esipf.dashboard.Data("Pension",
					empDt.getAmtPension());
			arrayData.add(data2);

		}

		com.csipl.hrms.dto.esipf.dashboard.GraphDto gt = new com.csipl.hrms.dto.esipf.dashboard.GraphDto(chart,
				arrayData);

		return gt;

	}

	@RequestMapping(path = "/empESIContributionInfo", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.esipf.dashboard.GraphDto EmpESIContribution(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.fetchEmpESIContribution(longcompanyId, 0L);
		ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data>();
		com.csipl.hrms.dto.esipf.dashboard.Chart chart = new com.csipl.hrms.dto.esipf.dashboard.Chart(
				GraphEnum.numberPrefix.getPieChartValue(), GraphEnum.formatnumberscale.getPieChartValue(),
				GraphEnum.decimals.getPieChartValue(), GraphEnum.skipOverlapLabels.getPieChartValue(),
				GraphEnum.theme.pieChartValue);
		for (EmployeeReportDTO empDt : empList) {

			com.csipl.hrms.dto.esipf.dashboard.Data data = new com.csipl.hrms.dto.esipf.dashboard.Data("Employee",
					empDt.getAmtEmployee());
			arrayData.add(data);
			com.csipl.hrms.dto.esipf.dashboard.Data data1 = new com.csipl.hrms.dto.esipf.dashboard.Data("Employer",
					empDt.getAmtEmployer());
			arrayData.add(data1);

		}

		com.csipl.hrms.dto.esipf.dashboard.GraphDto gt = new com.csipl.hrms.dto.esipf.dashboard.GraphDto(chart,
				arrayData);

		return gt;

	}

	@RequestMapping(path = "/empESIContributionInfoWithMonth", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.esipf.dashboard.GraphDto EmpESIContributionWithMonth(
			@RequestParam("processMonth") String processMonth,@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {

		Long p_process_month = Long.parseLong(processMonth);
		Long longcompanyId = Long.parseLong(companyId);
		System.out.println("====month ====" + p_process_month);
		List<EmployeeReportDTO> empList = employeeReportService.fetchEmpESIContribution(longcompanyId,
				p_process_month);
		ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.esipf.dashboard.Data>();
		com.csipl.hrms.dto.esipf.dashboard.Chart chart = new com.csipl.hrms.dto.esipf.dashboard.Chart(
				GraphEnum.numberPrefix.getPieChartValue(), GraphEnum.formatnumberscale.getPieChartValue(),
				GraphEnum.decimals.getPieChartValue(), GraphEnum.skipOverlapLabels.getPieChartValue(),
				GraphEnum.theme.pieChartValue);
		for (EmployeeReportDTO empDt : empList) {

			com.csipl.hrms.dto.esipf.dashboard.Data data = new com.csipl.hrms.dto.esipf.dashboard.Data("Employee",
					empDt.getAmtEmployee());
			arrayData.add(data);
			com.csipl.hrms.dto.esipf.dashboard.Data data1 = new com.csipl.hrms.dto.esipf.dashboard.Data("Employer",
					empDt.getAmtEmployer());
			arrayData.add(data1);

		}

		com.csipl.hrms.dto.esipf.dashboard.GraphDto gt = new com.csipl.hrms.dto.esipf.dashboard.GraphDto(chart,
				arrayData);

		return gt;

	}

	@RequestMapping(path = "/departmentWiseRatio", method = RequestMethod.GET)
	public @ResponseBody GraphDto departmentWiseRatio(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.departmentWiseRatio(longcompanyId);
		ArrayList<Data> arrayData = new ArrayList<Data>();

		DepartmentChart chart = new DepartmentChart(GraphEnum.numberPrefix.getPieChartValue(),
				GraphEnum.theme.getPieChartValue(), GraphEnum.startingAngle.getPieChartValue(),
				GraphEnum.showlabels.getPieChartValue(), GraphEnum.showlegend.getPieChartValue(),
				GraphEnum.enablemultislicing.getPieChartValue(), GraphEnum.slicingdistance.getPieChartValue(),
				GraphEnum.showpercentvalues.getPieChartValue(), GraphEnum.showpercentintooltip.getPieChartValue());

		for (EmployeeReportDTO empDt : empList) {
			Data data = new Data(empDt.getEmpDetp(), empDt.getDeptCount());
			arrayData.add(data);

		}

		GraphDto gt = new GraphDto(chart, arrayData);

		return gt;

	}

	@RequestMapping(path = "/lastSixMonthCTCInfo", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.payroll.dashboard.GraphDto LastSixMonthCTCInfo(
			@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<DepartmentReportDTO> deptReportDto = departmentReportService.LastSixMonthCTC(longcompanyId, 0L);
		ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data>();

		com.csipl.hrms.dto.payroll.dashboard.Chart chart = new com.csipl.hrms.dto.payroll.dashboard.Chart(
				GraphEnum.caption.getPieChartValue(), GraphEnum.numberPrefix.getPieChartValue(),
				GraphEnum.formatnumberscale.getPieChartValue(), GraphEnum.showBorder.pieChartValue,
				GraphEnum.use3DLighting.pieChartValue, GraphEnum.enableSmartLabels.pieChartValue,
				GraphEnum.startingAngle.pieChartValue, GraphEnum.showLabels.pieChartValue,
				GraphEnum.showPercentValues.pieChartValue, GraphEnum.showLegend.pieChartValue,
				GraphEnum.thousandSeparatorPosition.pieChartValue, GraphEnum.baseFont.pieChartValue,
				GraphEnum.baseFontSize.pieChartValue, GraphEnum.baseFontColor.pieChartValue,
				GraphEnum.centerLabelBold.pieChartValue, GraphEnum.showTooltip.pieChartValue,
				GraphEnum.decimals.pieChartValue, GraphEnum.theme.pieChartValue

		);

		for (DepartmentReportDTO deptDt : deptReportDto) {
			// String str[]= deptDt.getLastMonth().split("-");
			com.csipl.hrms.dto.payroll.dashboard.Data data = new com.csipl.hrms.dto.payroll.dashboard.Data(
					deptDt.getLastMonth(), deptDt.getDeptCTC());
			arrayData.add(data);
		}

		com.csipl.hrms.dto.payroll.dashboard.GraphDto gt = new com.csipl.hrms.dto.payroll.dashboard.GraphDto(chart,
				arrayData);

		return gt;
	}

	@RequestMapping(path = "/lastSixMonthCTCInfowithMonth", method = RequestMethod.GET)
	public @ResponseBody com.csipl.hrms.dto.payroll.dashboard.GraphDto LastSixMonthCTCInfoWithMonth(
			@RequestParam("processMonth") String processMonth,@RequestParam("companyId") String companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long p_process_month = Long.parseLong(processMonth);
		Long longcompanyId = Long.parseLong(companyId);
		System.out.println("====month ====" + p_process_month);
		List<DepartmentReportDTO> deptReportDto = departmentReportService.LastSixMonthCTC(longcompanyId,
				p_process_month);
		ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data> arrayData = new ArrayList<com.csipl.hrms.dto.payroll.dashboard.Data>();

		com.csipl.hrms.dto.payroll.dashboard.Chart chart = new com.csipl.hrms.dto.payroll.dashboard.Chart(
				GraphEnum.caption.getPieChartValue(), GraphEnum.numberPrefix.getPieChartValue(),
				GraphEnum.formatnumberscale.getPieChartValue(), GraphEnum.showBorder.pieChartValue,
				GraphEnum.use3DLighting.pieChartValue, GraphEnum.enableSmartLabels.pieChartValue,
				GraphEnum.startingAngle.pieChartValue, GraphEnum.showLabels.pieChartValue,
				GraphEnum.showPercentValues.pieChartValue, GraphEnum.showLegend.pieChartValue,
				GraphEnum.thousandSeparatorPosition.pieChartValue, GraphEnum.baseFont.pieChartValue,
				GraphEnum.baseFontSize.pieChartValue, GraphEnum.baseFontColor.pieChartValue,
				GraphEnum.centerLabelBold.pieChartValue, GraphEnum.showTooltip.pieChartValue,
				GraphEnum.decimals.pieChartValue, GraphEnum.theme.pieChartValue

		);

		for (DepartmentReportDTO deptDt : deptReportDto) {
			// String str[]= deptDt.getLastMonth().split("-");
			com.csipl.hrms.dto.payroll.dashboard.Data data = new com.csipl.hrms.dto.payroll.dashboard.Data(
					deptDt.getLastMonth(), deptDt.getDeptCTC());
			arrayData.add(data);
		}

		com.csipl.hrms.dto.payroll.dashboard.GraphDto gt = new com.csipl.hrms.dto.payroll.dashboard.GraphDto(chart,
				arrayData);

		return gt;
	}

	@RequestMapping(path = "/empAttrition", method = RequestMethod.GET)
	public @ResponseBody AttritionDto EmpAttritionJoinedResigned(@RequestParam("companyId") String companyId,HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long longcompanyId = Long.parseLong(companyId);
		List<EmployeeReportDTO> empResignedList = employeeReportService.EmpAttritionofResigned(longcompanyId);
		List<EmployeeReportDTO> empJoinedList = employeeReportService.EmpAttritionofJoined(longcompanyId);
		HashMap<String, ArrayList<Category>> hashMap = new HashMap<String, ArrayList<Category>>();
		ArrayList<HashMap<String, ArrayList<Category>>> categories = new ArrayList<HashMap<String, ArrayList<Category>>>();

		ArrayList<Category> category = new ArrayList<Category>();
		ArrayList<Object> dataset = new ArrayList<Object>();

		/* new logic for attrition two graph */

		ArrayList<String> joinMonth = new ArrayList<>();
		ArrayList<String> joinValue = new ArrayList<>();
		ArrayList<String> resValue = new ArrayList<>();

		HashMap<String, String> hs = new HashMap<String, String>();
		hs.put("Jan", "");
		hs.put("Feb", "");
		hs.put("Mar", "");
		hs.put("Apr", "");
		hs.put("May", "");
		hs.put("Jun", "");
		hs.put("Jul", "");
		hs.put("Aug", "");
		hs.put("Sep", "");
		hs.put("Oct", "");
		hs.put("Nov", "");
		hs.put("Dec", "");

		HashMap<String, String> hsRes = new HashMap<String, String>();
		hsRes.put("Jan", "");
		hsRes.put("Feb", "");
		hsRes.put("Mar", "");
		hsRes.put("Apr", "");
		hsRes.put("May", "");
		hsRes.put("Jun", "");
		hsRes.put("Jul", "");
		hsRes.put("Aug", "");
		hsRes.put("Sep", "");
		hsRes.put("Oct", "");
		hsRes.put("Nov", "");
		hsRes.put("Dec", "");

		for (EmployeeReportDTO empDt : empJoinedList) {
			hs.replace(empDt.getProcessMonth(), empDt.getEmpCount());

		}

		for (EmployeeReportDTO empDt : empResignedList) {
			hsRes.replace(empDt.getProcessMonth(), empDt.getEmpCount());

		}

		joinMonth.add("Jan");
		joinMonth.add("Feb");
		joinMonth.add("Mar");
		joinMonth.add("Apr");
		joinMonth.add("May");
		joinMonth.add("Jun");
		joinMonth.add("Jul");
		joinMonth.add("Aug");
		joinMonth.add("Sep");
		joinMonth.add("Oct");
		joinMonth.add("Nov");
		joinMonth.add("Dec");

		for (int j = 0; j < joinMonth.size(); j++) {
			joinValue.add(hs.get(joinMonth.get(j)));
			System.out.println("========" + joinValue.get(j));
		}
		for (int j = 0; j < joinMonth.size(); j++) {
			resValue.add(hsRes.get(joinMonth.get(j)));
			System.out.println("========" + resValue.get(j));
		}

		AttritionChart chart = new AttritionChart(AttritionEnum.caption.getPieChartValue(),
				AttritionEnum.yAxisName.getPieChartValue(), AttritionEnum.plotgradientcolor.getPieChartValue(),
				AttritionEnum.bgcolor.getPieChartValue(), AttritionEnum.showalternatehgridcolor.getPieChartValue(),
				AttritionEnum.divlinecolor.getPieChartValue(), AttritionEnum.showvalues.getPieChartValue(),
				AttritionEnum.showcanvasborder.getPieChartValue(), AttritionEnum.canvasborderalpha.getPieChartValue(),
				AttritionEnum.canvasbordercolor.getPieChartValue(),
				AttritionEnum.canvasborderthickness.getPieChartValue(), AttritionEnum.yaxismaxvalue.getPieChartValue(),
				AttritionEnum.captionpadding.getPieChartValue(), AttritionEnum.linethickness.getPieChartValue(),
				AttritionEnum.yaxisvaluespadding.getPieChartValue(), AttritionEnum.legendshadow.getPieChartValue(),
				AttritionEnum.legendborderalpha.getPieChartValue(), AttritionEnum.palettecolors.getPieChartValue(),
				AttritionEnum.showborder.getPieChartValue());

		for (String empMonth : joinMonth) {

			Category c = new Category(empMonth, "false", "true");
			category.add(c);
		}
		hashMap.put("category", category);
		categories.add(hashMap);

		ArrayList<DataJoined> arr = new ArrayList<DataJoined>();
		for (String value : joinValue) {

			DataJoined data = new DataJoined(value);
			arr.add(data);

		}

		DatasetJoined dj = new DatasetJoined(arr);
		dataset.add(dj);

		ArrayList<DataResigned> arr1 = new ArrayList<DataResigned>();

		for (String value : resValue) {

			DataResigned data = new DataResigned(value);
			arr1.add(data);

		}

		DatasetResigned dr = new DatasetResigned(arr1);
		dataset.add(dr);

		AttritionDto dto = new AttritionDto(chart, categories, dataset);

		return dto;
	}

	@RequestMapping(path = "/empCompanyAnnouncement", method = RequestMethod.GET)
	public @ResponseBody  List<EmployeeReportDTO> empCompanyAnnouncementApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);	
		List<EmployeeReportDTO> empList = employeeReportService.empCompanyAnnouncement(companyIdValue);
			
			if (empList != null)
				return empList;
			else
				throw new ErrorHandling("Data Not Found");

	}

	
	@RequestMapping(path = "/empTicketStatus", method = RequestMethod.GET)
	public @ResponseBody  EmployeeReportDTO empTicketStatusApp(@RequestParam("companyId") String companyId,@RequestParam("userId") String userId,@RequestParam("currentRole") String currentRole) throws ErrorHandling, PayRollProcessException {
		System.out.println("=====companyId========"+companyId+"===userId==="+userId+"====currentRole==="+currentRole);
			
			Long companyIdValue=Long.parseLong(companyId);
			Long userIdValue=Long.parseLong(userId);
			EmployeeReportDTO empList = employeeReportService.empTicketStatus(companyIdValue, userIdValue, currentRole);
				
				if (empList != null)
					return empList;
				else
					throw new ErrorHandling("Data Not Found");

		}

	@RequestMapping(path = "/empTicketStatusWithMonth", method = RequestMethod.GET)
	public @ResponseBody EmployeeReportDTO empTicketStatuswithMonth(@RequestParam("lastMonth") String lastMonth,@RequestParam("companyId") String companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		Long last_Month = Long.parseLong(lastMonth);
		Long companyIdValue=Long.parseLong(companyId);
		EmployeeReportDTO empList = employeeReportService.empTicketStatuswithMonth(companyIdValue, last_Month);

		if (empList != null)

			return empList;
		else

			throw new ErrorHandling("Data Not Found");

	}

}
