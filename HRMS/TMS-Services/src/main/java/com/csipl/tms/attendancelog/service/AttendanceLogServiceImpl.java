package com.csipl.tms.attendancelog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.attendancelog.repository.AttendanceLogPaginationRepository;
import com.csipl.tms.attendancelog.repository.AttendanceLogRepository;
import com.csipl.tms.dto.attendancelog.AttendanceLogDetailsDTO;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.model.attendancelog.AttendanceLog;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;
import com.csipl.tms.model.halfdayrule.HalfDayRule;
import com.csipl.tms.model.leave.TMSLeaveEntry;
import com.csipl.tms.weekoffpattern.adaptor.WeekOffPatternAdaptor;
import com.csipl.tms.weekoffpattern.service.WeekOffPatternService;

@Transactional
@Service("attendanceLogService")
public class AttendanceLogServiceImpl implements AttendanceLogService {

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager entityManager;

	@Autowired
	AttendanceLogRepository attendanceLogRepository;

	@Autowired
	WeekOffPatternService weekOffPatternService;

	@Autowired
	public AttendanceLogPaginationRepository attendanceLogPaginationRepository;

	@Override
	public void savePunchTimeLog(List<AttendanceLog> attendanceLogList) {

		attendanceLogRepository.save(attendanceLogList);
	}

	@Override
	public List<Object[]> getAttendance(Long companyId, Long employeeId, String fromDate, String toDate) {

		String query = "SELECT * FROM AttendanceLogs al WHERE al.companyId=?1 AND al.employeeId=?2 AND al.attendanceDate >= ?3 AND al.attendanceDate <= ?4 ORDER BY attendanceDate ASC";
		Query nativeQuery = entityManager.createNativeQuery(query);
		nativeQuery.setParameter(1, companyId).setParameter(2, employeeId).setParameter(3, fromDate).setParameter(4,
				toDate);
		List<Object[]> resultList = nativeQuery.getResultList();
		System.out.println("Attendance resultList size------>" + resultList.size());
		return resultList;

	}

	@Override
	public List<AttendanceLog> getAttendanceLogDetails(Long companyId, String date) {

		/*
		 * String query =
		 * "SELECT al.inTime,al.location,al.mode,empdetail.employeeCode,empdetail.firstName,empdetail.lastName,empdetail.departmentName,empdetail.designationName,empdetail.companyId, al.outTime FROM AttendanceLogs al  JOIN EmpCommonDetails empdetail oN al.employeeCode = empdetail.employeeCode WHERE al.attendanceDate=?1 AND al.companyId =?2"
		 * ; Query nativeQuery = entityManager.createNativeQuery(query);
		 * nativeQuery.setParameter(1, date).setParameter(2, companyId); List<Object[]>
		 * resultList = nativeQuery.getResultList();
		 * System.out.println("Attendance resultList size------>" + resultList.size());
		 * return resultList;
		 */

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return attendanceLogRepository.getAttendanceLog(companyId, date1);

	}

	@Override
	public List<AttendanceLogDetailsDTO> getAttendanceLogDetailsDTOList(List<AttendanceLog> attendanceLogDetailsList,

			List<EmpCommonDetail> empCommonDetailList, HalfDayRule halfDayRule, List<TMSLeaveEntry> leaveList,
			List<HolidayDTO> holidayDtoList, Date date) {
		// TODO Auto-generated method stub

		System.out.println("attendanceLogDetailsList..." + attendanceLogDetailsList);
		List<AttendanceLogDetailsDTO> attendanceLogDetailsDtoList = new ArrayList<AttendanceLogDetailsDTO>();
		Long diffHours = 0l;
		for (EmpCommonDetail empCommonDetail : empCommonDetailList) {
			AttendanceLogDetailsDTO attendanceLogDetailsDto = new AttendanceLogDetailsDTO();
			attendanceLogDetailsDto.setDepartmentName(empCommonDetail.getDepartmentName());
			attendanceLogDetailsDto.setDesignationName(empCommonDetail.getDesignationName());
			attendanceLogDetailsDto.setName(empCommonDetail.getFirstName() + empCommonDetail.getLastName());
			attendanceLogDetailsDto.setEmployeeCode(empCommonDetail.getEmployeeCode());

			if ((holidayDtoList.size() != 0)
					&& (attendanceLogDetailsList == null || attendanceLogDetailsList.size() == 0)) {
				System.out.println("inside holiday....holidayDtoList.size()..." + holidayDtoList.size()
						+ " holiay list..." + holidayDtoList.toString());
				attendanceLogDetailsDto.setPublicHoliday("PH");
			} else {
				for (AttendanceLog attendanceLogDetails : attendanceLogDetailsList) {

					if (empCommonDetail.getEmployeeId().equals(attendanceLogDetails.getEmployeeId())) {

						attendanceLogDetailsDto.setPresent("P");
						attendanceLogDetailsDto.setFirstPunch(attendanceLogDetails.getInTime());
						attendanceLogDetailsDto.setLocation(attendanceLogDetails.getLocation());
						attendanceLogDetailsDto.setMode(attendanceLogDetails.getMode());

						/*
						 * shift (delayed time) calculation
						 */
						attendanceLogDetailsDto.setDelayedTime(attendanceLogDetails.getDelayedTime());

						/* calculation of worked hour */
						SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
						Date outDate = null;
						Date inDate = null;
						String outTime = attendanceLogDetails.getOutTime();
						String inTime = attendanceLogDetails.getInTime();
						try {
							outDate = (Date) sdf.parse(outTime);
							inDate = (Date) sdf.parse(inTime);
							Long diff = outDate.getTime() - inDate.getTime();
							diffHours = diff / (60 * 60 * 1000) % 24;

							System.out.println("worked hours.." + diffHours);
							attendanceLogDetailsDto.setWorkHours(diffHours);
						} catch (ParseException e) {
							e.printStackTrace();
						}

						// calculation of overtime &early going
						Calendar cal = Calendar.getInstance();
						cal.setTime(inDate);
						int hours = (halfDayRule.getMaximumRequireHour()).intValue();
						cal.add(Calendar.HOUR_OF_DAY, hours); // this will add two hours
						inDate = cal.getTime();
						System.out.println("intimeeee...." + inDate);

						if (diffHours < halfDayRule.getMaximumRequireHour()) {
							Long diff = inDate.getTime() - outDate.getTime();
							diffHours = diff / (60 * 60 * 1000) % 24;
							long diffMinutes = diff / (60 * 1000) % 60;
							attendanceLogDetailsDto.setEarlyGoing(diffHours + ":" + diffMinutes);
							attendanceLogDetailsDto.setOverTime("0");
							System.out.println("early going.." + diffHours + ":" + diffMinutes);
						} else {
							Long diff = outDate.getTime() - inDate.getTime();
							diffHours = diff / (60 * 60 * 1000) % 24;
							long diffMinutes = diff / (60 * 1000) % 60;
							attendanceLogDetailsDto.setEarlyGoing("0");
							attendanceLogDetailsDto
									.setOverTime(diffHours.toString() + "hours" + ":" + diffHours + ":" + diffMinutes);

							System.out.println("overtime..." + diffHours);
						}

					}

				}
				/* leave calculation */
				for (TMSLeaveEntry leaveEntry : leaveList) {
					if (empCommonDetail.getEmployeeId().equals(leaveEntry.getEmployeeId())) {
						System.out.println("insidee leave if");
						attendanceLogDetailsDto.setLeave("L");
						/*
						 * attendanceLogDetailsDto.setPresent("0");
						 * attendanceLogDetailsDto.setAbsent("0");
						 */
					}

				}

				/* weekoff calculation */
				System.out.println(empCommonDetail.getEmployeeId());

				Object[] weekOffPatternObj = weekOffPatternService
						.getWeekOffPatternByEmp(empCommonDetail.getCompanyId(), empCommonDetail.getEmployeeId());
				String weekOffPattern = null;
				if (weekOffPatternObj != null) {
					System.out.println("weekoffpattern.." + weekOffPatternObj[0]);
					weekOffPattern = weekOffPatternObj[0].toString();

					System.out.println("weekoffpatternobj.size()" + weekOffPatternObj[0]);

					WeekOffPatternAdaptor weekOffPatternAdaptor = new WeekOffPatternAdaptor();
					String[] weekOffPatternArray = weekOffPatternAdaptor.databaseModeObjlToUiDto(weekOffPattern);
					List<String> weekDayList = Arrays.asList(weekOffPatternArray);
					SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEE");
					String dayName = simpleDateformat.format(date);
					System.out.println("day name..." + dayName);
					if (weekDayList.contains(dayName.toUpperCase())) {
						System.out.println("weekoff patern ...");
						attendanceLogDetailsDto.setWeekOff("Off");
					}
				}
				// attendanceLogDetailsDto.setPublicHoliday("0");
			}
			if (attendanceLogDetailsDto.getPresent() == null && attendanceLogDetailsDto.getLeave() == null
					&& attendanceLogDetailsDto.getWeekOff() == null
					&& attendanceLogDetailsDto.getPublicHoliday() == null) {
				System.out.println("absent...");
				attendanceLogDetailsDto.setAbsent("A");
			}
			System.out.println("Object..." + attendanceLogDetailsDto.toString());
			attendanceLogDetailsDtoList.add(attendanceLogDetailsDto);
		}
		// System.out.println("attendanceAdaptor...." + attendanceLogDetailsDtoList);
		return attendanceLogDetailsDtoList;
	}

	@Override
	public List<AttendanceLog> markBulkAttendance(List<AttendanceLog> attendanceLogList) {
		List<AttendanceLog> attendanceLogList1 = (List<AttendanceLog>) attendanceLogRepository.save(attendanceLogList);
		return attendanceLogList1;
	}

}
