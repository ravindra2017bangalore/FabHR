package com.csipl.tms.calendar.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.tms.attendanceregularizationrequest.adaptor.AttendanceAdaptor;
import com.csipl.tms.attendanceregularizationrequest.adaptor.AttendanceRegularizationRequestAdaptor;
import com.csipl.tms.attendanceregularizationrequest.controller.AttendanceRegularizationRequestController;
import com.csipl.tms.attendanceregularizationrequest.service.AttendanceRegularizationRequestService;
import com.csipl.tms.calendar.service.CalendarService;
import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;
import com.csipl.tms.dto.attendanceregularizationrequest.AttendanceRegularizationRequestDTO;
import com.csipl.tms.dto.calendar.CalendarDTO;
import com.csipl.tms.dto.halfdayrule.HalfDayRuleDTO;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.dto.leave.LeaveEntryDTO;
import com.csipl.tms.empcommondetail.service.EmpCommonDetailService;
import com.csipl.tms.halfdayrule.adaptor.HalfDayRuleAdaptor;
import com.csipl.tms.holiday.adaptor.HolidayAdaptor;
import com.csipl.tms.holiday.service.HolidayService;
import com.csipl.tms.leave.adaptor.LeaveEntryAdaptor;
import com.csipl.tms.leave.service.EmployeeLeaveService;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.shift.Shift;
import com.csipl.tms.rules.service.RulesService;
import com.csipl.tms.tmsempshift.service.TMSEmpShiftService;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.attendancelog.service.AttendanceLogService;
import com.csipl.tms.weekoffpattern.adaptor.WeekOffPatternAdaptor;
import com.csipl.tms.weekoffpattern.service.WeekOffPatternService;

@RestController
public class CalendarController {

	@Autowired
	AttendanceLogService attendanceLogService;

	@Autowired
	AttendanceRegularizationRequestService attendanceRegularizationRequestService;

	@Autowired
	WeekOffPatternService weekOffPatternService;

	@Autowired
	HolidayService holidayService;

	@Autowired
	TMSEmpShiftService tMSEmpShiftService;

	@Autowired
	EmployeeLeaveService employeeLeaveService;

	@Autowired
	RulesService rulesService;

	@Autowired
	CalendarService calendarService;

	@Autowired
	EmpCommonDetailService empCommonDetailService;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(AttendanceRegularizationRequestController.class);

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public @ResponseBody CalendarDTO getCalendar(@RequestParam("companyId") Long companyId,
			@RequestParam("employeeId") Long employeeId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) throws ParseException {

		String weekOffPattern = null;
		String empShiftName = null;
		DateFormat inputFormat = new SimpleDateFormat("E MMM dd yyyy ");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = dateFormat.format(inputFormat.parse(fromDate));
		String endDate = dateFormat.format(inputFormat.parse(toDate));
		Date fDate = inputFormat.parse(fromDate);
		Date tDate = inputFormat.parse(toDate);

		// Object[] empJoiningDateObj =
		// empCommonDetailService.getEmployeeJoiningDate(employeeId);

		List<Object[]> attendanceLogList = attendanceLogService.getAttendance(companyId, employeeId, startDate,
				endDate);

		List<Object[]> arRequestList = attendanceRegularizationRequestService.getARRequestforMonth(companyId,
				employeeId, startDate, endDate);

		Object[] weekOffPatternObj = weekOffPatternService.getWeekOffPatternByEmp(companyId, employeeId);

		if (weekOffPatternObj[0].toString() != null) {
			weekOffPattern = weekOffPatternObj[0].toString();
		}

		List<Object[]> tmsHolidays = holidayService.findMonthHoliday(companyId, startDate, endDate);
		// EmpCommonDetail
		// empCommonDetail=empCommonDetailService.getEmployeeCommonDetails(employeeId);
		Employee employee = employeePersonalInformationService.getEmployeeInfo(employeeId);
		Date empJoiningDateObj = employee.getDateOfJoining();
		Object[] empShiftNameObj = employeePersonalInformationService.getEmpShiftName(employeeId);
		System.out.println("empShiftNameObj" + empShiftNameObj.length);
		if (empShiftNameObj != null && empShiftNameObj.length > 0) {
			empShiftName = empShiftNameObj[1].toString();
		}
		Shift shift = new Shift();
		shift.setShiftId(employee.getShiftId());
		shift.setShiftFName(empShiftName);

		// Object[] shiftNameObj =
		// tMSEmpShiftService.getEmpShiftOnemployeeId(employeeId);

		List<Object[]> leaveEntryObj = employeeLeaveService.getMonthEmployeeLeaveEntry(companyId, employeeId, startDate,
				endDate);

		HalfDayRule halfDayRule = rulesService.getHalfDayRule(companyId);

		WeekOffPatternAdaptor weekOffPatternAdaptor = new WeekOffPatternAdaptor();
		HolidayAdaptor holidayAdaptor = new HolidayAdaptor();
		LeaveEntryAdaptor leaveEntryAdaptor = new LeaveEntryAdaptor();
		HalfDayRuleAdaptor halfDayRuleAdaptor = new HalfDayRuleAdaptor();
		AttendanceAdaptor attendanceAdaptor = new AttendanceAdaptor();
		AttendanceRegularizationRequestAdaptor arRequestAdaptor = new AttendanceRegularizationRequestAdaptor();

		List<AttendanceLogDTO> attendanceLogDtoList = attendanceAdaptor.objArraytoDtoList(attendanceLogList);
		List<AttendanceRegularizationRequestDTO> arRequestDtoList = arRequestAdaptor
				.arModelListToArDtoList(arRequestList);

		String[] weekOffPatternArray = weekOffPatternAdaptor.databaseModeObjlToUiDto(weekOffPattern);
		List<HolidayDTO> holidayDtoList = holidayAdaptor.databaseModelObjToUiDtoList(tmsHolidays);
		List<LeaveEntryDTO> leaveEntryDtoList = leaveEntryAdaptor.databaseModelObjToUiDtoList(leaveEntryObj);
		HalfDayRuleDTO halfDayRuleDto = halfDayRuleAdaptor.databaseModelToUiDto(halfDayRule);

		CalendarDTO calendarDto = calendarService.calendarLogs(empJoiningDateObj, fDate, tDate, attendanceLogDtoList,
				arRequestDtoList, weekOffPatternArray, holidayDtoList, shift, leaveEntryDtoList, halfDayRuleDto);

		logger.info("calendarDtoList------->" + calendarDto.getEvents().size());

		return calendarDto;

	}

	/*
	 * @RequestMapping(value = "/dateLog", method = RequestMethod.GET)
	 * public @ResponseBody DayLogsDTO getdateLog(@RequestParam("date") String date)
	 * {
	 * 
	 * return calendarService.getDayLog(date);
	 * 
	 * }
	 */
}
