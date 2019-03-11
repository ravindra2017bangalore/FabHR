package com.csipl.tms.holiday.repository;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.model.holiday.TMSHolidays;

public interface HolidayRepository extends CrudRepository <TMSHolidays, Long> {
	@Query(" from TMSHolidays where companyId =?1 AND activeStatus ='"+StatusMessage.ACTIVE_CODE+"'")
//	@Query(" from TMSHolidays where companyId =?1  and year=year(Now()) ORDER BY  holidayId  DESC ")
    public List<TMSHolidays> findAllHoliday(Long companyId);
	
	@Query(" from TMSHolidays where holidayId=?1 ORDER BY  holidayId  DESC ")
    public TMSHolidays findHoliday( Long holidayId);
	
	String holidaycount="SELECT \r\n" + 
			"CASE\r\n" + 
			"WHEN  Month(tm.fromDate)=Month(Now())\r\n" + 
			"THEN (SELECT SUM(fun_calculate_days_fromdate_todate(tm.fromDate,tm.toDate)))\r\n" + 
			"\r\n" + 
			"ELSE\r\n" + 
			"(SELECT SUM(day(toDate)))\r\n" + 
			"\r\n" + 
			"END \r\n" + 
			"\r\n" + 
			"FROM TMSHolidays tm WHERE companyId=?1 and year=year(Now()) and Month(fromDate)=Month(Now()) or Month(toDate)=Month(Now())";
	
	@Query(value=holidaycount,nativeQuery = true)
	public  BigDecimal holidaycount( Long companyId);
	
	@Query(" FROM TMSHolidays  WHERE companyId=?1  AND MONTH(fromDate)=MONTH(NOW()) OR MONTH(toDate)=MONTH(NOW()) AND year=YEAR(NOW())")
	public List<TMSHolidays> findMonthlyHolidayList(Long companyId);
	
	@Query(" from TMSHolidays where leavePeriodId =?1")
    public List<TMSHolidays> findAllLeavePeriod(Long leavePeriodId);
}

