package com.csipl.hrms.service.candidate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.dto.candidate.CandidateSearchDTO;
import com.csipl.hrms.dto.employee.EmployeeCountDTO;
import com.csipl.hrms.service.candidate.repository.CandidatePagingAndFilterRepository;
import com.csipl.hrms.service.candidate.repository.CandidateRepository;

@Service
public class CandidatePagingAndFilterServiceImpl implements CandidatePagingAndFilterService{

	@Autowired
	CandidatePagingAndFilterRepository candidatePagingAndFilterRepository;
	
	@Autowired
	CandidateRepository candidateRepository;
 	
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getCandidateByPagingAndFilter(Long companyId, CandidateSearchDTO candidateSearcDto) {
		return candidatePagingAndFilterRepository.findCandidatePagedAndFilterResult(companyId,candidateSearcDto);
	}

	@Override
	public void getCandidateCount(long longCompanyId, String candidateStatus ,EmployeeCountDTO searchDto) {
		searchDto.setCount(candidateRepository.candidateCount(longCompanyId,candidateStatus));
	}
}
