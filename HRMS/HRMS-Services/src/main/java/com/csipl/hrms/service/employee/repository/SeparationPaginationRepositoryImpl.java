package com.csipl.hrms.service.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.dto.search.EmployeeSearchDTO;

@Repository
public class SeparationPaginationRepositoryImpl implements SeparationPaginationRepository {
	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getSeparationPaginationList(long companyId, EmployeeSearchDTO employeeSearchDto,boolean status) {

		StringBuilder sb = new StringBuilder();
 		sb.append(" SELECT  sp.separationId ,sp.dateCreated,sp.resoan,sp.endDate,sp.status,emp.firstName,emp.lastName,emp.noticePeriodDays ,emp.employeeId,desig.designationName ,sp.description,sp.remark ");
		sb.append( "FROM Separation sp JOIN Employee emp ON emp.employeeId=sp.employeeId  ");
		sb.append( " JOIN Designation desig ON desig.designationId=emp.designationId where emp.companyId=:companyId  ");
 		
		String active = employeeSearchDto.getActive();
  		String sortDirection = employeeSearchDto.getSortDirection();
		int offset = employeeSearchDto.getOffset();
 		buildCondtion(employeeSearchDto, sb,status);
		sortSearchQuery(sb, active, sortDirection);
 		int limit = employeeSearchDto.getLimit();
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
	private void buildCondtion(EmployeeSearchDTO employeeSearchDto, StringBuilder sb,boolean statusFlag) {
		String status="PEN";
		
  		if (employeeSearchDto.getEmployeeName() != null && !employeeSearchDto.getEmployeeName().equals("")
				&& !employeeSearchDto.getEmployeeName().equalsIgnoreCase("null")
				&& !employeeSearchDto.getEmployeeName().equalsIgnoreCase("undefined")) {

			sb.append(" and ( emp.firstName LIKE '" + employeeSearchDto.getEmployeeName() + "%' or  emp.lastName LIKE '"
					+ employeeSearchDto.getEmployeeName() + "%'  )");
		}
 		if(statusFlag) {
 			sb.append(" and sp.status NOT IN ('"+status+"')");
  		}else {
 			sb.append(" and sp.status='"+status+"'");

    		}
  	}  

	/**
	 * @param sb
	 * @param active
	 * @param sortDirection
	 */
	private void sortSearchQuery(StringBuilder sb, String active, String sortDirection) {
		if (active != null && (active.trim().equals("") || active.trim().equals("undefined"))) {

			sb.append(" order by sp.separationId desc ");

		} else if (active != null && (active.trim().equals("dateCreated"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by  LENGTH( sp.dateCreated ), sp.dateCreated   asc ");
			} else {
				sb.append(" order by  LENGTH( sp.dateCreated ), sp.dateCreated  desc ");
			}

		} else if (active != null && (active.trim().equals("resoan"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by sp.resoan asc ");
			} else {
				sb.append(" order by sp.resoan desc ");
			}
		}
			else if (active != null && (active.trim().equals("firstName"))) {

				if (sortDirection.equals("asc")) {
					sb.append(" order by emp.firstName asc ");
				} else {
					sb.append(" order by emp.firstName desc ");
				}

		} else if (active != null && (active.trim().equals("noticePeriodDays"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by emp.noticePeriodDays asc ");
			} else {
				sb.append(" order by emp.noticePeriodDays desc ");
			}

		} else if (active != null && (active.trim().equals("endDate"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by sp.endDate asc ");
			} else {
				sb.append(" order by sp.endDate desc ");
			}

		}  else if (active != null && (active.trim().equals("status"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by sp.status asc ");
			} else {
				sb.append(" order by sp.status desc ");
			}

		} else {

			sb.append("order by sp.separationId desc");
		}
	}

}
