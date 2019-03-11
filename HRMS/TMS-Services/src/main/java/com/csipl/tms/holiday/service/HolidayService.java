package com.csipl.tms.holiday.service;
import java.util.List;

import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.model.holiday.TMSHolidays;


public interface HolidayService {
	public TMSHolidays save(TMSHolidays holiday);
	public List<TMSHolidays> findAllHoliday(Long companyId);
	public TMSHolidays findHoliday( Long shiftId);
	public List<Object[]> findMonthHoliday(long companyId, String fromDate, String toDate);
	public HolidayDTO holidayCount(long companyId);
	public List<TMSHolidays> monthlyHolidayList(long companyId);
	
	public List<TMSHolidays> findAllLeavePeriod(Long leavePeriodId);
}
