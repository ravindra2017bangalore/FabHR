package com.csipl.tms.holiday.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.holiday.repository.HolidayRepository;
import com.csipl.tms.model.holiday.TMSHolidays;

@Transactional
@Service("holidayService")
public class HolidayServiceImpl implements HolidayService {
  
private static final Logger log = LoggerFactory.getLogger(HolidayServiceImpl.class);

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager entityM;

	@Autowired
	private HolidayRepository holidayRepository;

	@Override
	public TMSHolidays save(TMSHolidays holiday) {
		return holidayRepository.save(holiday);
	}

	@Override
	public List<TMSHolidays> findAllHoliday(Long companyId) {
		return holidayRepository.findAllHoliday(companyId);
	}

	@Override
	public TMSHolidays findHoliday(Long shiftId) {
		return holidayRepository.findHoliday(shiftId);
	}

	@Override
	public List<Object[]> findMonthHoliday(long companyId, String fromDate, String toDate) {

		String query = "SELECT * FROM TMSHolidays where companyId=?1 and fromDate >=?2  and toDate <=?3 ORDER BY fromDate ASC";
		Query nativeQuery = entityM.createNativeQuery(query);
		nativeQuery.setParameter(1, companyId).setParameter(2, fromDate).setParameter(3, toDate);
		final List<Object[]> resultList = nativeQuery.getResultList();
		System.out.println("MonthHoliday resultList size------>" + resultList.size());
		return resultList;
	}

	@Override
	public HolidayDTO holidayCount(long companyId) {
		BigDecimal count = holidayRepository.holidaycount(companyId);
		HolidayDTO holiodayDto = new HolidayDTO();
		holiodayDto.setCount(count);
		return holiodayDto;
	}

	@Override
	public List<TMSHolidays> monthlyHolidayList(long companyId) {
		System.out.println("===============================IN TMSHOLIDAYS======================");
		List<TMSHolidays> monthlyHolidayList=holidayRepository.findMonthlyHolidayList(companyId);
		return monthlyHolidayList;
		
}

	/* (non-Javadoc)
	 * @see com.csipl.tms.holiday.service.HolidayService#findAllLeavePeriod(java.lang.Long)
	 */
	@Override
	public List<TMSHolidays> findAllLeavePeriod(Long leavePeriodId) {
		
		log.info("HolidayServiceImpl.findAllLeavePeriod()");
		return holidayRepository.findAllLeavePeriod(leavePeriodId);
	}
}