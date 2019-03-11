package com.csipl.tms.attendanceregularizationrequest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csipl.tms.dto.common.SearchDTO;

@Repository
public class ARRequestPagingAndFilterRepositoryImpl implements ARRequestPagingAndFilterRepository {

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@Override
	public List<Object[]> findARRequestPagedAndFilterResult(Long companyId, Boolean status, SearchDTO searcDto) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				" SELECT ecd.employeeCode,ecd.firstName,ecd.lastName,d.departmentName,ar.arID,ar.dateCreated,ar.arCategory,ar.actionableDate,ar.fromDate,ar.toDate,ar.days,ar.status,ar.employeeId,ar.employeeRemark,ar.userId  ,de.designationName, ar.approvalRemark  FROM TMSARRequest ar JOIN Employee ecd on ecd.employeeId=ar.employeeId JOIN Department d on d.departmentId=ecd.departmentId JOIN Designation de on de.designationId= ecd.designationId where ar.companyId =:companyId ");

		String active = searcDto.getActive();
		System.out.println(" 1-Active  - "+active);
		String sortDirection = searcDto.getSortDirection();
		int offset = searcDto.getOffset();
		buildCondtion(status, sb);
		sortSearchQuery(sb, active, sortDirection);
		int limit = searcDto.getLimit();

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
	private void buildCondtion(Boolean status, StringBuilder sb) {

		if (status) {
			sb.append(" AND ar.status = 'PEN'");

		} else {
			sb.append(" AND ar.status !='PEN'");
		}
	}

	/**
	 * @param sb
	 * @param active
	 * @param sortDirection
	 */
	private void sortSearchQuery(StringBuilder sb, String active, String sortDirection) {
		System.out.println("Active - " + active);
		if (active != null && (active.trim().equals("") || active.trim().equals("undefined"))) {

			sb.append(" order by ecd.firstName desc ");

		} else if (active != null && (active.trim().equals("dateCreated"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by ar.dateCreated asc ");
			} else {
				sb.append(" order by ar.dateCreated desc ");
			}
		} else if (active != null && (active.trim().equals("firstName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by ar.dateCreated asc ");
			} else {
				sb.append(" order by ar.dateCreated desc ");
			}

		} else if (active != null && (active.trim().equals("fromDate"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by ar.fromDate asc ");
			} else {
				sb.append(" order by ar.fromDate desc ");
			}

		} else if (active != null && (active.trim().equals("days"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by ar.days asc ");
			} else {
				sb.append(" order by ar.days desc ");
			}

		} else if (active != null && (active.trim().equals("status"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by ar.status asc ");
			} else {
				sb.append(" order by ar.status desc ");
			}

		} else if (active != null && (active.trim().equals("arCategory"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by ar.arCategory asc ");
			} else {
				sb.append(" order by ar.arCategory desc ");
			}

		}
	}

}
