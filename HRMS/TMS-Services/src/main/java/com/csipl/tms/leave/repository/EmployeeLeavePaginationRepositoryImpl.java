package com.csipl.tms.leave.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.csipl.tms.model.leave.LeaveSearchDTO;

@Repository
public class EmployeeLeavePaginationRepositoryImpl implements EmployeeLeavePaginationRepository {
	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@Override
	public List<Object[]> getPendingEmployeeLeavebyPagination(Long companyId, LeaveSearchDTO leaveSearchDto) {
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT le.leaveId , le.employeeId, le.approvalId,le.dateCreated,le.days,le.status");
		sb.append(
				",desig.designationName,emp.firstName,emp.lastName,LTM.leaveName,le.employeeRemark,le.approvalRemark,le.cancleRemark,le.fromDate,le.toDate ");
		sb.append(
  				"FROM TMSLeaveEntries le JOIN Employee emp ON emp.employeeId=le.employeeId JOIN Designation desig ON desig.designationId=emp.designationId ");
		sb.append(
				"JOIN TMSLeaveType LT ON LT.leaveTypeId=le.leaveTypeId JOIN TMSLeaveTypeMaster LTM ON LT.leaveTypeMasterId=LTM.leaveId ");
		/*sb.append(
				"JOIN TMSLeaveType LT ON LT.leaveTypeId=le.leaveTypeId ");*/
		sb.append(
				" WHERE le.companyId =:companyId ");
		
	//	sb.append("WHERE le.status='C'");

		String active = leaveSearchDto.getActive();
		String sortDirection = leaveSearchDto.getSortDirection();
		int offset = leaveSearchDto.getOffset();

		buildCondtion(leaveSearchDto, sb);
		sortSearchQuery(sb, active, sortDirection);

		int limit = leaveSearchDto.getLimit();

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
	private void buildQuery(LeaveSearchDTO leaveSearchDTO, StringBuilder sb) {
		
       if(leaveSearchDTO.getStatus().equals("APR")||leaveSearchDTO.getStatus().equals("REJ")) {
    	   sb.append(",appEmp.firstName,appEmp.lastName,appDesig.designationName");
    	   sb.append(
   				" FROM TMSLeaveEntries le JOIN Employee emp ON emp.employeeId=le.employeeId");
	  sb.append("JOIN Employee appEmp ON appEmp.employeeId=le.approvalId");
	  sb.append("JOIN Designation appDesig ON appDesig.designationId=appEmp.designationId");
       }
       else {
    	   sb.append(
      				" FROM TMSLeaveEntries le JOIN Employee emp ON emp.employeeId=le.employeeId ");
       }

		
	
		
	}
	
	/**
	 * @param employeeSearchDto
	 * @param sb
	 */
	private void buildCondtion(LeaveSearchDTO leaveSearchDTO, StringBuilder sb) {
		if(leaveSearchDTO.getStatusFlag())
			sb.append(" and le.status='PEN'");
		else
			sb.append("and (le.status='CEN' OR le.status='APR' OR le.status='REJ')");
     
		if (leaveSearchDTO.getEmployeeName() != null && !leaveSearchDTO.getEmployeeName().equals("")
				&& !leaveSearchDTO.getEmployeeName().equalsIgnoreCase("null")
				&& !leaveSearchDTO.getEmployeeName().equalsIgnoreCase("undefined")) {

			sb.append(" and ( emp.firstName LIKE '" + leaveSearchDTO.getEmployeeName() + "%' or  emp.lastName LIKE '"
					+ leaveSearchDTO.getEmployeeName() + "%'  )");
		}
		

		
	
		sb.append(" and  emp.activeStatus = '" + leaveSearchDTO.getActiveStaus() + "' ");
	}
	/**
	 * @param sb
	 * @param active
	 * @param sortDirection
	 */
	private void sortSearchQuery(StringBuilder sb, String active, String sortDirection) {
		if (active != null && (active.trim().equals("") || active.trim().equals("undefined"))) {

			sb.append(" order by le.leaveId desc ");

		/*} else if (active != null && (active.trim().equals("employeeCode"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by  LENGTH( emp.employeeCode ), emp.employeeCode   asc ");
			} else {
				sb.append(" order by  LENGTH( emp.employeeCode ), emp.employeeCode  desc ");
			}
*/
		} else if (active != null && (active.trim().equals("employeeName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by emp.firstName asc ");
			} else {
				sb.append(" order by emp.firstName desc ");
			}
		}
			else if (active != null && (active.trim().equals("dateCreated"))) {

				if (sortDirection.equals("asc")) {
					sb.append(" order by emp.dateCreated asc ");
				} else {
					sb.append(" order by emp.dateCreated desc ");
				}

		} else if (active != null && (active.trim().equals("leaveName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by LTM.leaveName asc ");
			} else {
				sb.append(" order by LTM.leaveName desc ");
			}

		} else if (active != null && (active.trim().equals("days"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by le.days asc ");
			} else {
				sb.append(" order by le.days desc ");
			}

		} else if (active != null && (active.trim().equals("designationName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by design.designationName asc ");
			} else {
				sb.append(" order by design.designationName desc ");
			}

		} else if (active != null && (active.trim().equals("status"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by le.status asc ");
			} else {
				sb.append(" order by le.status desc ");
			}

		} else {

			sb.append("order by le.leaveId desc");
		}
	}

}
