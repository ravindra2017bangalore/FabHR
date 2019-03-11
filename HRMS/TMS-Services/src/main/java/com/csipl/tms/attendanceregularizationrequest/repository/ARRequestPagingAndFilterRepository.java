package com.csipl.tms.attendanceregularizationrequest.repository;

import java.util.List;

import com.csipl.tms.dto.common.SearchDTO;

public interface ARRequestPagingAndFilterRepository {

	List<Object[]> findARRequestPagedAndFilterResult(Long companyId, Boolean status, SearchDTO searcDto);

}
