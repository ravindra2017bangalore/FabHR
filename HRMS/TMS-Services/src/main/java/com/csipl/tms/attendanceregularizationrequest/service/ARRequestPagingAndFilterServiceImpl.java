package com.csipl.tms.attendanceregularizationrequest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.attendanceregularizationrequest.repository.ARRequestPagingAndFilterRepository;
import com.csipl.tms.dto.common.SearchDTO;


@Service("aRRequestPagingAndFilterService")
public class ARRequestPagingAndFilterServiceImpl implements ARRequestPagingAndFilterService{

	@Autowired
	ARRequestPagingAndFilterRepository aRRequestPagingAndFilterRepository;
	
	
	@Override
	public List<Object[]> getARByPagingAndFilter(Long companyId, Boolean status, SearchDTO searcDto) {
		return aRRequestPagingAndFilterRepository.findARRequestPagedAndFilterResult(companyId,status,searcDto);
	
	}

}
