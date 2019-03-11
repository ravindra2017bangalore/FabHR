package com.csipl.tms.leave.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.dto.candidate.CandidateSearchDTO;
import com.csipl.tms.dto.leave.CompOffSearchDTO;
@Repository
public class CompensatoryOffPaginationRepositoryImpl implements CompensatoryOffPaginatonRepository {
	
	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@Override
	public List<Object[]> findCompOffPagedAndFilterResult(Long companyId, CompOffSearchDTO compOffSearchDTO,boolean status) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT CONCAT(e.firstName,' ',e.lastName) as employeeName, tc.fromDate, tc.toDate,tc.leaveTypeId,tc.status ,tc.dateCreated, tc.tmsCompensantoryOffId,tc.employeeId,tc.approvalRemark,tc.cancelRemark,tc.remark,d.designationName FROM TMSCompensantoryOff tc ,Employee e, Designation d WHERE e.employeeId=tc.employeeId AND e.designationId=d.designationId AND tc.companyId=:companyId ");

		//String candidateStatus = compOffSearchDTO.getCandidateStatus();
		//System.out.println("candidateStatus====" + candidateStatus);
		
		String active = compOffSearchDTO.getActive();
		System.out.println("active field================" +active);
		String sortDirection = compOffSearchDTO.getSortDirection();
		int offset = compOffSearchDTO.getOffset();
		buildCondtion(compOffSearchDTO, sb,status);
		sortSearchQuery(sb, active, sortDirection);
		int limit = compOffSearchDTO.getLimit();

		String search = sb.toString();

		System.out.println("Query Start-----------------------");
		System.out.println(search);
		System.out.println("Query End-----------------------");
		Query nativeQuery = em.createNativeQuery(search);
		nativeQuery.setParameter("companyId", companyId);
		nativeQuery.setFirstResult(offset);
		nativeQuery.setMaxResults(limit);
		final List<Object[]> resultList = nativeQuery.getResultList();
		System.out.println("result Size ---" + resultList.size());
		return resultList;
		
		
	}
	
	/**
	 * @param employeeSearchDto
	 * @param sb
	 */
	private void buildCondtion(CompOffSearchDTO compOffSearchDTO, StringBuilder sb,boolean statusFlag) {
		System.out.println("EmployeeName===================="+compOffSearchDTO.getEmployeeName());
		String status=StatusMessage.PENDING_CODE;

		if (compOffSearchDTO.getEmployeeName() != null && !compOffSearchDTO.getEmployeeName().equals("")) {

			sb.append(" AND ( e.firstName LIKE '" + compOffSearchDTO.getEmployeeName() + "%' )");
		}
		if(statusFlag) {
			sb.append(" and tc.status='"+status+"'");
  		}else {
 			sb.append(" and tc.status NOT IN ('"+status+"')");

    	}

		

	}

	/**
	 * @param sb
	 * @param active
	 * @param sortDirection
	 */
	private void sortSearchQuery(StringBuilder sb, String active, String sortDirection) {
		if (active != null && (active.trim().equals("") || active.trim().equals("undefined"))) {

			sb.append(" order by employeeName desc ");

		} else if (active != null && (active.trim().equals("employeeName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by e.firstName asc ");
			} else {
				sb.append(" order by e.firstName desc ");
			}
		} else if (active != null && (active.trim().equals("dateCreated"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by tc.dateCreated asc ");
			} else {
				sb.append(" order by tc.dateCreated desc ");
			}

		} 
		else if (active != null && (active.trim().equals("status"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by tc.status asc ");
			} else {
				sb.append(" order by tc.status desc ");
			}

		}
		else if (active != null && (active.trim().equals("fromDate"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by tc.fromDate asc ");
			} else {
				sb.append(" order by tc.fromDate desc ");
			}

		}
	}


}
