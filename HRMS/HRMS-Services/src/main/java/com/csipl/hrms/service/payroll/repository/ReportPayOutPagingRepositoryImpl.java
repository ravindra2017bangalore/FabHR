package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.dto.payrollprocess.ReportPayoutSearchDTO;

@Repository
public class ReportPayOutPagingRepositoryImpl implements ReportPayOutPagingRepository {
	
	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findReportPayOutPagingResulst(long companyId, ReportPayoutSearchDTO reportPayoutSearchDto) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"SELECT rp.Name,rp.employeeCode,rp.bankName,rp.accountNumber,rp.dateOfJoining,rp.Basic,rp.GrossSalary,rp.otherAllowance,rp.absense,"
						+ "rp.casualleave,rp.seekleave,rp.payableDays,rp.presense,rp.publicholidays,rp.weekoff,rp.overtime,"
						+ "rp.BasicEarning,rp.TotalEarning,rp.otherAllowanceEarning,rp.EmployeeLoansAdvnace,rp.ProvidentFundEmployee,rp.ESI_Employee,rp.PT,rp.TDS,rp.TotalDeduction "
						+ " FROM  ReportPayOut rp where rp.companyId =:companyId ");
		buildCondtion(reportPayoutSearchDto, sb);


		int offset = reportPayoutSearchDto.getOffset();

		int limit = reportPayoutSearchDto.getLimit();
		String search = sb.toString();
		System.out.println("Query=----" + search);
		Query nativeQuery = em.createNativeQuery(search);
		nativeQuery.setParameter("companyId", companyId);
		nativeQuery.setFirstResult(offset);
		nativeQuery.setMaxResults(limit);
		final List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	/**
	 * @param reportPayoutSearchDto
	 * @param sb
	 */
	private void buildCondtion(ReportPayoutSearchDTO reportPayoutSearchDto, StringBuilder sb) {
		if (reportPayoutSearchDto.getDepartmentId() != null) {

			sb.append(" AND rp.departmentId=" + reportPayoutSearchDto.getDepartmentId() + " ");
			sb.append(" AND rp.processMonth='" + reportPayoutSearchDto.getProcessMonth() + "' ");
			/*
			 * sb.
			 * append(" AND rp.employeeId not in (select p.employeeId from Provision p where p.processMonth='"
			 * + reportPayoutSearchDto.getProcessMonth() +
			 * "' ) ORDER BY rp.departmentId DESC ");
			 */
		}

		else {
			if (reportPayoutSearchDto.getProcessMonth() != null && !reportPayoutSearchDto.getProcessMonth().equals("")
					&& !reportPayoutSearchDto.getProcessMonth().equalsIgnoreCase("null")
					&& !reportPayoutSearchDto.getProcessMonth().equalsIgnoreCase("undefined")) {

				sb.append(" AND rp.processMonth='" + reportPayoutSearchDto.getProcessMonth() + "' ");
				/*
				 * sb.
				 * append(" AND rp.employeeId not in (select p.employeeId from Provision p where p.processMonth='"
				 * + reportPayoutSearchDto.getProcessMonth() + "' ) ");
				 */
			}
		}

	}

	public List<Object> payrollValidationByEmployeeCode(Long companyId, String processMonth, String employeeCode) {

		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT employeeCode FROM reportpayout rp  WHERE rp.companyId =:companyId AND rp.processMonth =:processMonth AND employeeCode IN ("
						+ employeeCode + ") ");
		String search = sb.toString();
		System.out.println("Query=----" + search);
		Query nativeQuery = em.createNativeQuery(search);
		nativeQuery.setParameter("companyId", companyId);
		nativeQuery.setParameter("processMonth", processMonth);
		@SuppressWarnings("unchecked")
		final List<Object> countL = nativeQuery.getResultList();
		System.out.println("List Object----------->" + countL);
		return countL;
	}

}
