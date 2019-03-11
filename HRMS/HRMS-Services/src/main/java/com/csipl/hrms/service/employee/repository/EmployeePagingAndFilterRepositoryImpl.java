package com.csipl.hrms.service.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.dto.search.EmployeeSearchDTO;

@Repository
public class EmployeePagingAndFilterRepositoryImpl implements EmployeePagingAndFilterRepository {

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findEmployeePagedAndFilterResult(long companyId, EmployeeSearchDTO employeeSearchDto) {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT emp.employeeId, emp.employeeCode, emp.firstName, emp.lastName, ");
		sb.append(
				"gd.gradesName, dept.departmentName,  design.designationName, emp.dateOfJoining ,emp.endDate, emp.employeeLogoPath , emp.dateOfBirth, emp1.firstName AS reportingFirstName, emp1.lastName AS reportingLastName");
		sb.append(
				" FROM  Employee emp LEFT JOIN Employee emp1 ON emp1.employeeId=emp.ReportingToEmployee LEFT JOIN PayStructureHd ph ON  ph.employeeId = emp.employeeId AND ( ");
		sb.append(
				" ph.dateEnd IS NULL OR ph.dateEnd > CURRENT_DATE ) AND ( ph.effectiveDate IS NOT NULL AND ph.effectiveDate <= CURRENT_DATE ");
		sb.append(
				") AND ph.activeStatus = 'AC' LEFT JOIN Grades gd ON gd.gradesId = ph.gradesId LEFT JOIN Department dept ON   emp.departmentId = dept.departmentId ");
		sb.append(
				" LEFT JOIN Designation design ON   emp.designationId = design.designationId   WHERE emp.companyId =:companyId  ");

		String active = employeeSearchDto.getActive();
		String sortDirection = employeeSearchDto.getSortDirection();
		int offset = employeeSearchDto.getOffset();

		buildCondtion(employeeSearchDto, sb);
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
	private void buildCondtion(EmployeeSearchDTO employeeSearchDto, StringBuilder sb) {
		if (employeeSearchDto.getEmployeeCode() != null && !employeeSearchDto.getEmployeeCode().equals("")
				&& !employeeSearchDto.getEmployeeCode().equalsIgnoreCase("null")
				&& !employeeSearchDto.getEmployeeCode().equalsIgnoreCase("undefined")) {

			sb.append(" and emp.employeeCode='" + employeeSearchDto.getEmployeeCode() + "'  ");
		}

		if (employeeSearchDto.getEmployeeName() != null && !employeeSearchDto.getEmployeeName().equals("")
				&& !employeeSearchDto.getEmployeeName().equalsIgnoreCase("null")
				&& !employeeSearchDto.getEmployeeName().equalsIgnoreCase("undefined")) {

			sb.append(" and ( emp.firstName LIKE '" + employeeSearchDto.getEmployeeName() + "%' or  emp.lastName LIKE '"
					+ employeeSearchDto.getEmployeeName() + "%'  )");
		}
		if (employeeSearchDto.getDepartment() != null && !employeeSearchDto.getDepartment().equals("")
				&& !employeeSearchDto.getDepartment().equalsIgnoreCase("null")
				&& !employeeSearchDto.getDepartment().equalsIgnoreCase("undefined")) {

			sb.append(" and dept.departmentName LIKE '" + employeeSearchDto.getDepartment() + "%' ");
		}

		if (employeeSearchDto.getDesignation() != null && !employeeSearchDto.getDesignation().equals("")
				&& !employeeSearchDto.getDesignation().equalsIgnoreCase("null")
				&& !employeeSearchDto.getDesignation().equalsIgnoreCase("undefined")) {

			sb.append(" and design.designationName LIKE '" + employeeSearchDto.getDesignation() + "%' ");
		}

		if (employeeSearchDto.getGrade() != null && !employeeSearchDto.getGrade().equals("")
				&& !employeeSearchDto.getGrade().equalsIgnoreCase("null")
				&& !employeeSearchDto.getGrade().equalsIgnoreCase("undefined")) {

			sb.append(" and gd.gradesName LIKE '" + employeeSearchDto.getGrade() + "%' ");
		}

		if (employeeSearchDto.getDoj() != null && !employeeSearchDto.getDoj().equals("")
				&& !employeeSearchDto.getDoj().equalsIgnoreCase("null")
				&& !employeeSearchDto.getDoj().equalsIgnoreCase("undefined")) {

			sb.append(" and emp.dateOfJoining  = '" + employeeSearchDto.getDoj() + "%' ");
		}

		if (employeeSearchDto.getTabName() != null && employeeSearchDto.getTabName().equals("empOnboard")) {
			sb.append(" and emp.endDate IS null ");
		}

		if (employeeSearchDto.getTabName() != null && employeeSearchDto.getTabName().equals("separating")) {
			sb.append(" and emp.endDate !='' ");
		}

		sb.append(" and  emp.activeStatus = '" + employeeSearchDto.getActiveStaus() + "' ");
	}

	/**
	 * @param sb
	 * @param active
	 * @param sortDirection
	 */
	private void sortSearchQuery(StringBuilder sb, String active, String sortDirection) {
		if (active != null && (active.trim().equals("") || active.trim().equals("undefined"))) {

			sb.append(" order by emp.employeeId desc ");

		} else if (active != null && (active.trim().equals("employeeCode"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by  LENGTH( emp.employeeCode ), emp.employeeCode   asc ");
			} else {
				sb.append(" order by  LENGTH( emp.employeeCode ), emp.employeeCode  desc ");
			}

		} else if (active != null && (active.trim().equals("employeeId"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by emp.employeeId asc ");
			} else {
				sb.append(" order by emp.employeeId desc ");
			}
		} else if (active != null && (active.trim().equals("firstName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by emp.firstName asc ");
			} else {
				sb.append(" order by emp.firstName desc ");
			}

		} else if (active != null && (active.trim().equals("gradeName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by gd.gradesName asc ");
			} else {
				sb.append(" order by gd.gradesName desc ");
			}

		} else if (active != null && (active.trim().equals("departmentName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by dept.departmentName asc ");
			} else {
				sb.append(" order by dept.departmentName desc ");
			}

		} else if (active != null && (active.trim().equals("designationName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by design.designationName asc ");
			} else {
				sb.append(" order by design.designationName desc ");
			}

		} else if (active != null && (active.trim().equals("dateOfJoining"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by emp.dateOfJoining asc ");
			} else {
				sb.append(" order by emp.dateOfJoining desc ");
			}

		} else {

			sb.append("order by emp.employeeId desc");
		}
	}

}
