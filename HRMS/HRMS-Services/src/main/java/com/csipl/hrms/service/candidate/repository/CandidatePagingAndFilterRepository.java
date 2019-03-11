package com.csipl.hrms.service.candidate.repository;

import java.util.List;

import com.csipl.hrms.dto.candidate.CandidateSearchDTO;

public interface CandidatePagingAndFilterRepository {

	List<Object[]> findCandidatePagedAndFilterResult(Long companyId, CandidateSearchDTO candidateSearcDto);


}
