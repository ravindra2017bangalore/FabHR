package com.csipl.hrms.service.candidate;

import java.util.List;

import com.csipl.hrms.dto.candidate.CandidateSearchDTO;
import com.csipl.hrms.dto.employee.EmployeeCountDTO;

public interface CandidatePagingAndFilterService {

	List<Object[]> getCandidateByPagingAndFilter(Long companyId, CandidateSearchDTO candidateSearcDto);

	void getCandidateCount(long longCompanyId,String candidateStatus, EmployeeCountDTO employeeCountDto);

}
