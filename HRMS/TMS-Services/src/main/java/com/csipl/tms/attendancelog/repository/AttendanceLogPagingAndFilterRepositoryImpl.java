package com.csipl.tms.attendancelog.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;

import com.csipl.tms.dto.attendancelog.AttendanceLogSearchDTO;

@Repository
public class AttendanceLogPagingAndFilterRepositoryImpl implements AttendanceLogPagingAndFilterRepository {

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceLogPagingAndFilterRepositoryImpl.class);

	@Override
	public int getAttendanceLogCount(AttendanceLogSearchDTO attendanceLogSearchDto, String attendanceDate) {
		String Query = "CALL pro_attendancelog_count_report(:p_selected_date ,:p_emp_name,:p_sorttype ,:p_activestatus,:p_emp_code ,:p_offset,:p_limit ,:p_active_value,:p_comp_id,:p_dept_id,:p_desg_id,:p_title)";
		Query nativeQuery = em.createNativeQuery(Query);
		nativeQuery.setParameter("p_selected_date", attendanceDate);
		logger.info("count attendanceDate---" + attendanceDate + " ---offset-" + attendanceLogSearchDto.getOffset()
				+ "---limit-" + attendanceLogSearchDto.getLimit());

		if (attendanceLogSearchDto.getEmployeeName() != null) {
			nativeQuery.setParameter("p_emp_name", attendanceLogSearchDto.getEmployeeName());
			logger.info("count EmployeeName---" + attendanceLogSearchDto.getEmployeeName());
		} else {
			nativeQuery.setParameter("p_emp_name", "");

		}

		if (attendanceLogSearchDto.getEmployeeCode() != null) {
			logger.info("count EmployeeCode()---" + attendanceLogSearchDto.getEmployeeCode());
			nativeQuery.setParameter("p_emp_code", attendanceLogSearchDto.getEmployeeCode());
		} else {
			nativeQuery.setParameter("p_emp_code", "");
		}

		if (attendanceLogSearchDto.getDepartmentId() != null) {
			logger.info(" count dept Id()---" + attendanceLogSearchDto.getDepartmentId());
			nativeQuery.setParameter("p_dept_id", attendanceLogSearchDto.getDepartmentId());
		} else {
			nativeQuery.setParameter("p_dept_id", "");
		}

		if (attendanceLogSearchDto.getDesignationId() != null) {
			logger.info("count desg Id()---" + attendanceLogSearchDto.getDesignationId());
			nativeQuery.setParameter("p_desg_id", attendanceLogSearchDto.getDesignationId());
		} else {
			nativeQuery.setParameter("p_desg_id", "");
		}
		
		if (attendanceLogSearchDto.getSortDirection() != null) {
			logger.info(" count sort Type()---" + attendanceLogSearchDto.getSortDirection());
			nativeQuery.setParameter("p_sorttype", attendanceLogSearchDto.getSortDirection());
		} else {
			nativeQuery.setParameter("p_sorttype", "");
		}
		
		if (attendanceLogSearchDto.getAttendanceTitle() != null) {
			logger.info(" count AttendanceTitle()---" + attendanceLogSearchDto.getAttendanceTitle());
			nativeQuery.setParameter("p_title", attendanceLogSearchDto.getAttendanceTitle());
		} else {
			nativeQuery.setParameter("p_title", "");
		}


		//nativeQuery.setParameter("p_sorttype", "");
		nativeQuery.setParameter("p_activestatus", "");
		nativeQuery.setParameter("p_offset", attendanceLogSearchDto.getOffset());
		nativeQuery.setParameter("p_limit", attendanceLogSearchDto.getLimit());
		nativeQuery.setParameter("p_active_value", "");
		nativeQuery.setParameter("p_comp_id", attendanceLogSearchDto.getCompanyId());

		@SuppressWarnings("unchecked")
		final List<Object[]> resultList = nativeQuery.getResultList();
		logger.info("count result Size ---" + resultList.size());
		return resultList.size();
	}

	@Override
	public List<Object[]> getAttendanceLogByPagingAndFilter(AttendanceLogSearchDTO attendanceLogSearchDto,
			String attendanceDate) {
		String Query = "CALL pro_attendancelog_report(:p_selected_date ,:p_emp_name,:p_sorttype ,:p_activestatus,:p_emp_code ,:p_offset,:p_limit ,:p_active_value,:p_comp_id,:p_dept_id,:p_desg_id,:p_title)";
		Query nativeQuery = em.createNativeQuery(Query);
		nativeQuery.setParameter("p_selected_date", attendanceDate);
		logger.info("attendanceDate---" + attendanceDate + " ---offset-" + attendanceLogSearchDto.getOffset()
				+ "---limit-" + attendanceLogSearchDto.getLimit());
		if (attendanceLogSearchDto.getEmployeeName() != null) {
			nativeQuery.setParameter("p_emp_name", attendanceLogSearchDto.getEmployeeName());
			logger.info("EmployeeName---" + attendanceLogSearchDto.getEmployeeName());
		} else {
			nativeQuery.setParameter("p_emp_name", "");

		}

		if (attendanceLogSearchDto.getEmployeeCode() != null) {
			logger.info("EmployeeCode()---" + attendanceLogSearchDto.getEmployeeCode());
			nativeQuery.setParameter("p_emp_code", attendanceLogSearchDto.getEmployeeCode());
		} else {
			nativeQuery.setParameter("p_emp_code", "");
		}

		if (attendanceLogSearchDto.getDepartmentId() != null) {
			logger.info("dept Id()---" + attendanceLogSearchDto.getDepartmentId());
			nativeQuery.setParameter("p_dept_id", attendanceLogSearchDto.getDepartmentId());
		} else {
			nativeQuery.setParameter("p_dept_id", "");
		}

		if (attendanceLogSearchDto.getDesignationId() != null) {
			logger.info("desg Id()---" + attendanceLogSearchDto.getDesignationId());
			nativeQuery.setParameter("p_desg_id", attendanceLogSearchDto.getDesignationId());
		} else {
			nativeQuery.setParameter("p_desg_id", "");
		}

		if (attendanceLogSearchDto.getSortDirection() != null) {
			logger.info("sort Type()---" + attendanceLogSearchDto.getSortDirection());
			nativeQuery.setParameter("p_sorttype", attendanceLogSearchDto.getSortDirection());
		} else {
			nativeQuery.setParameter("p_sorttype", "");
		}

		if (attendanceLogSearchDto.getActive() != null) {
			logger.info("Active()---" + attendanceLogSearchDto.getActive());
			nativeQuery.setParameter("p_active_value", attendanceLogSearchDto.getActive());
		} else {
			nativeQuery.setParameter("p_active_value", "");
		}

		if (attendanceLogSearchDto.getAttendanceTitle() != null) {
			logger.info("AttendanceTitle()---" + attendanceLogSearchDto.getAttendanceTitle());
			nativeQuery.setParameter("p_title", attendanceLogSearchDto.getAttendanceTitle());
		} else {
			nativeQuery.setParameter("p_title", "");
		}

		nativeQuery.setParameter("p_activestatus", "");
		nativeQuery.setParameter("p_offset", attendanceLogSearchDto.getOffset());
		nativeQuery.setParameter("p_limit", attendanceLogSearchDto.getLimit());
		nativeQuery.setParameter("p_comp_id", attendanceLogSearchDto.getCompanyId());
		@SuppressWarnings("unchecked")
		final List<Object[]> resultList = nativeQuery.getResultList();
		logger.info("result Size ---" + resultList.size());
		return resultList;
	}

	@Override
	public List<Object[]> attendanceReport(Long companyId, Date attendanceDate) {
		String Query = "CALL pro_attendancelog_report(:p_selected_date ,:p_emp_name,:p_sorttype ,:p_activestatus,:p_emp_code ,:p_offset,:p_limit ,:p_active_value,:p_comp_id,:p_dept_id,:p_desg_id,:p_title)";
		Query nativeQuery = em.createNativeQuery(Query);
		
		logger.info("Query >>>" +Query+"companyId>>>> "+companyId+" attendanceDate>>"+attendanceDate);

		nativeQuery.setParameter("p_selected_date", attendanceDate);
 		 
			nativeQuery.setParameter("p_emp_name", "");
  			nativeQuery.setParameter("p_emp_code", "");
  			nativeQuery.setParameter("p_dept_id", "");
   			nativeQuery.setParameter("p_desg_id", "");
  			nativeQuery.setParameter("p_sorttype", "desc");
  			nativeQuery.setParameter("p_active_value", "");
 			nativeQuery.setParameter("p_title", "");
 		nativeQuery.setParameter("p_activestatus", "");
		nativeQuery.setParameter("p_offset",0);
		nativeQuery.setParameter("p_limit", 1000);
		nativeQuery.setParameter("p_comp_id", companyId);
		@SuppressWarnings("unchecked")
		final List<Object[]> resultList = nativeQuery.getResultList();
		logger.info("result Size ---" + resultList.size());
		return resultList;
	}

  }

/**
 * @param sb
 * @param active
 * @param sortDirection
 *//*
	 * private void sortSearchQuery(StringBuilder sb, String active, String
	 * sortDirection) { logger.info("Active - " + active); if (active != null &&
	 * (active.trim().equals("") || active.trim().equals("undefined"))) {
	 * 
	 * sb.append(" order by e1.firstName desc ");
	 * 
	 * } else if (active != null && (active.trim().equals("firstName"))) {
	 * 
	 * if (sortDirection.equals("asc")) { sb.append(" order by e1.firstName asc ");
	 * } else { sb.append(" order by e1.firstName desc "); }
	 * 
	 * }
	 * 
	 * else if (active != null && (active.trim().equals("status"))) {
	 * 
	 * if (sortDirection.equals("asc")) { sb.append(" order by a.status asc "); }
	 * else { sb.append(" order by a.status desc "); }
	 * 
	 * } else if (active != null && (active.trim().equals("location"))) {
	 * 
	 * if (sortDirection.equals("asc")) { sb.append(" order by a.location asc "); }
	 * else { sb.append(" order by a.location desc "); }
	 * 
	 * } else if (active != null && (active.trim().equals("inTime"))) {
	 * 
	 * if (sortDirection.equals("asc")) { sb.append(" order by a.inTime asc "); }
	 * else { sb.append(" order by a.inTime desc "); }
	 * 
	 * } else if (active != null && (active.trim().equals("mode"))) {
	 * 
	 * if (sortDirection.equals("asc")) { sb.append(" order by a.mode asc "); } else
	 * { sb.append(" order by a.mode desc "); }
	 * 
	 * } }
	 */

/*
 * private void buildCondtion(AttendanceLogSearchDTO attendanceLogSearchDto,
 * StringBuilder sb) {
 * 
 * if (attendanceLogSearchDto.getDepartmentId() != null) {
 * sb.append(" And e1.departmentId =" +
 * attendanceLogSearchDto.getDepartmentId()); }
 * 
 * if (attendanceLogSearchDto.getDesignationId() != null) {
 * sb.append(" And e1.designationId =" +
 * attendanceLogSearchDto.getDesignationId()); }
 * 
 * if (attendanceLogSearchDto.getEmployeeCode() != null) {
 * sb.append(" And e1.employeeCode ='" +
 * attendanceLogSearchDto.getEmployeeCode() + "'"); }
 * 
 * if (attendanceLogSearchDto.getAttendanceTitle().equals("P")) {
 * sb.append(" And a.status ='H' OR a.status='P' "); }
 * 
 * if (attendanceLogSearchDto.getAttendanceTitle().equals("A")) {
 * sb.append(" And a.status ='A' OR a.status='L' "); }
 * 
 * if (attendanceLogSearchDto.getEmployeeName() != null &&
 * !attendanceLogSearchDto.getEmployeeName().equals("")) {
 * 
 * sb.append(" AND ( e1.firstName LIKE '" +
 * attendanceLogSearchDto.getEmployeeName() + "%' )"); } }
 */
