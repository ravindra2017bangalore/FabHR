package com.csipl.hrms.mobile.controller;

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
import com.csipl.hrms.dto.report.AttritionChart;
import com.csipl.hrms.dto.report.AttritionDto;
import com.csipl.hrms.dto.report.Category;
import com.csipl.hrms.dto.report.Chart;
import com.csipl.hrms.dto.report.Data;
import com.csipl.hrms.dto.report.DataJoined;
import com.csipl.hrms.dto.report.DataResigned;
import com.csipl.hrms.dto.report.DatafinalResigned;
import com.csipl.hrms.dto.report.DatasetJoined;
import com.csipl.hrms.dto.report.DatasetResigned;
import com.csipl.hrms.dto.report.DepartmentChart;
import com.csipl.hrms.dto.report.DepartmentChartDto;
import com.csipl.hrms.dto.report.DepartmentChartEmpMaster;
import com.csipl.hrms.dto.report.DepartmentChartPayroll;
import com.csipl.hrms.dto.report.DepartmentData;
import com.csipl.hrms.dto.report.DepartmentPayrollChart;
import com.csipl.hrms.dto.report.DepartmentPayrollDto;
import com.csipl.hrms.dto.report.DepartmentReportDTO;
import com.csipl.hrms.dto.report.DesignationChart;
import com.csipl.hrms.dto.report.DesignationChartDto;
import com.csipl.hrms.dto.report.DesignationChartEmpMaster;
import com.csipl.hrms.dto.report.DesignationData;
import com.csipl.hrms.dto.report.DesignationPayrollChart;
import com.csipl.hrms.dto.report.EmployeeReportDTO;
import com.csipl.hrms.dto.report.GenderChart;
import com.csipl.hrms.dto.report.GenderDto;
import com.csipl.hrms.dto.report.GraphDto;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.report.DepartmentReportService;
import com.csipl.hrms.service.report.EmployeeReportService;

@RestController
public class EmpDashboardMobileController extends BaseController {

	@Autowired
	EmployeeReportService employeeReportService;

	@Autowired
	DepartmentReportService departmentReportService;

	@RequestMapping(path = "/countNotificationApp", method = RequestMethod.GET)
	public @ResponseBody EmployeeReportDTO countNotificationApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		EmployeeReportDTO employeeReportDTO = employeeReportService.countNotification(companyIdValue);
		if (employeeReportDTO != null)
			return employeeReportDTO;
		else
			throw new ErrorHandling("Data Not Found");

	}
	
	
	

	@RequestMapping(path = "/employeeNotificationApp", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> employeeNotificationApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> empList = employeeReportService.employeeNotification(companyIdValue,
				PFlageEnum.Notification.getpFlageEnum());
		if (empList != null)
			return empList;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empGenderWiseRatioApp", method = RequestMethod.GET)
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

	@RequestMapping(path = "/empAgeWiseRatioApp", method = RequestMethod.GET)
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

	@RequestMapping(path = "/empDashboardInfoApp", method = RequestMethod.GET)
	public @ResponseBody EmployeeReportDTO EmployeeDashboardInfoApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		EmployeeReportDTO employeeReportDTO = employeeReportService.countEMPIMPTODAYDATE(companyIdValue, "");
		if (employeeReportDTO != null)
			return employeeReportDTO;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empBirthDayInfoApp", method = RequestMethod.GET)
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

	@RequestMapping(path = "/empAnniversaryInfoApp", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeReportDTO> EmployeeAnniverSaryInfoApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);
		List<EmployeeReportDTO> empAnniversaryList = employeeReportService.fetchAnniversaryDayEmpList(companyIdValue,
				PFlageEnum.Anniversary.getpFlageEnum());
		if (empAnniversaryList.size() > 0)
			return empAnniversaryList;
		else
			throw new ErrorHandling("Data Not Found");

	}

	@RequestMapping(path = "/empWorkAnniversaryInfoApp", method = RequestMethod.GET)
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

	
	


	
	

	
	
	
	@RequestMapping(path = "/empCompanyAnnouncementApp", method = RequestMethod.GET)
	public @ResponseBody  List<EmployeeReportDTO> empCompanyAnnouncementApp(@RequestParam("companyId") String companyId) throws ErrorHandling, PayRollProcessException {
		Long companyIdValue=Long.parseLong(companyId);	
		List<EmployeeReportDTO> empList = employeeReportService.empCompanyAnnouncement(companyIdValue);
			
			if (empList != null)
				return empList;
			else
				throw new ErrorHandling("Data Not Found");

	}

	
	
	
	@RequestMapping(path = "/empTicketStatusApp", method = RequestMethod.GET)
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

	

}
