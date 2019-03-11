package com.csipl.tms.attendancelog.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service("attendanceCalculationService")
public class AttendanceCalculationServiceImpl  implements AttendanceCalculationService{


	@PersistenceContext(unitName = "sqlServer")
	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceCalculationServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Object[]> getAllPunchDetails(Object[] object) {

		String deviceName = (String) object[2];
		logger.info("deviceName------>" + deviceName);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);

		String miDate = new StringBuffer(dateFormat.format(cal.getTime())).append(" 00:00:00.000").toString();
		String mxDate = new StringBuffer(dateFormat.format(cal.getTime())).append(" 23:59:59.000").toString();
		logger.info("miDate------>" + miDate + " ----- " + "mxDate------>" + mxDate);
		logger.info("Previous date ----->" + cal.getTime());

		String query = "SELECT MIN(sno) as mintime, MIN(date)as mindate, MAX(sno)as maxtime, MAX(date)as maxdate ,DATEDIFF(n,MIN(date),MAX(date) ) AS MinsWorked,tktno ,flag, d.DeviceId FROM PunchTimeDetails p join Devices d ON d.DeviceSName=p.flag WHERE date >= ?1 AND date <= ?2  AND flag IN ("
				+ deviceName + ") GROUP BY tktno,flag,d.DeviceId";
		Query nativeQuery = em.createNativeQuery(query);
		nativeQuery.setParameter(1, miDate).setParameter(2, mxDate);
		final List<Object[]> resultList = nativeQuery.getResultList();
		logger.info("resultList size------>" + resultList.size());
		return resultList;
	}

}
