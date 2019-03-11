package com.csipl.tms.attendanceregularizationrequest.service;

import java.util.List;

import com.csipl.tms.dto.common.SearchDTO;

public interface ARRequestPagingAndFilterService {

	List<Object[]> getARByPagingAndFilter(Long companyId,Boolean status, SearchDTO searcDto);

}
