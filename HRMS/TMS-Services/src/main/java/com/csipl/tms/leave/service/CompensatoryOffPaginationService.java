package com.csipl.tms.leave.service;
import java.util.List;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.dto.leave.CompOffSearchDTO;


public interface CompensatoryOffPaginationService {

	public List<Object[]> findCandidatePagedAndFilterResult(Long companyId, CompOffSearchDTO compOffSearchDTO,boolean status);
	
	public void getCompOffCount(Long company,EntityCountDTO entityCountDTO,boolean status);
}
