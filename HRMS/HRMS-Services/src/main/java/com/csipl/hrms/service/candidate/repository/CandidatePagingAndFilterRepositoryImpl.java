package com.csipl.hrms.service.candidate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.dto.candidate.CandidateSearchDTO;

@Repository
public class CandidatePagingAndFilterRepositoryImpl implements CandidatePagingAndFilterRepository {

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findCandidatePagedAndFilterResult(Long companyId, CandidateSearchDTO candidateSearcDto) {

		StringBuilder sb = new StringBuilder();
		sb.append(
				" SELECT candi.firstName, candi.lastName, candi.mobile, candi.emailId, candi.candidateLogoPath, candi.declineReason, candi.candidateId ,des.designationName FROM Candidate candi JOIN Designation des on des.designationId = candi.designationId  where candi.companyId =:companyId ");

		String candidateStatus = candidateSearcDto.getCandidateStatus();
		System.out.println("candidateStatus====" + candidateStatus);
		String active = candidateSearcDto.getActive();
		String sortDirection = candidateSearcDto.getSortDirection();
		int offset = candidateSearcDto.getOffset();
		buildCondtion(candidateSearcDto, sb);
		sortSearchQuery(sb, active, sortDirection);
		int limit = candidateSearcDto.getLimit();

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
	private void buildCondtion(CandidateSearchDTO candidateSearcDto, StringBuilder sb) {

		if (candidateSearcDto.getEmployeeName() != null && !candidateSearcDto.getEmployeeName().equals("")) {

			sb.append(" AND ( candi.firstName LIKE '" + candidateSearcDto.getEmployeeName() + "%' )");
		}

		sb.append(" AND candi.candidateStatus = '" + candidateSearcDto.getCandidateStatus() + "'");

	}

	/**
	 * @param sb
	 * @param active
	 * @param sortDirection
	 */
	private void sortSearchQuery(StringBuilder sb, String active, String sortDirection) {
		if (active != null && (active.trim().equals("") || active.trim().equals("undefined"))) {

			sb.append(" order by emp.firstName desc ");

		} else if (active != null && (active.trim().equals("candidateId"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by candi.candidateId asc ");
			} else {
				sb.append(" order by candi.candidateId desc ");
			}
		} else if (active != null && (active.trim().equals("firstName"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by candi.firstName asc ");
			} else {
				sb.append(" order by candi.firstName desc ");
			}

		} else if (active != null && (active.trim().equals("mobile"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by candi.mobile asc ");
			} else {
				sb.append(" order by candi.mobile desc ");
			}

		} else if (active != null && (active.trim().equals("email"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by candi.email asc ");
			} else {
				sb.append(" order by candi.email desc ");
			}

		} else if (active != null && (active.trim().equals("candidateReason"))) {

			if (sortDirection.equals("asc")) {
				sb.append(" order by candi.candidateReason asc ");
			} else {
				sb.append(" order by candi.candidateReason desc ");
			}

		}
	}

}
