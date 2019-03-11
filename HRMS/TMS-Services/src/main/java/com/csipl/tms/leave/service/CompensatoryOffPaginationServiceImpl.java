package com.csipl.tms.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.dto.leave.CompOffSearchDTO;
import com.csipl.tms.leave.repository.CompensatoryOffPaginatonRepository;
import com.csipl.tms.leave.repository.CompensatoryOffRepository;


@Service
public class CompensatoryOffPaginationServiceImpl implements CompensatoryOffPaginationService {
	@Autowired
	CompensatoryOffRepository compensatoryOffRepository;
	
	@Autowired
	CompensatoryOffPaginatonRepository compensatoryOffPaginatonRepository;
	
	@Override
	public void getCompOffCount(Long companyId,EntityCountDTO entityCountDTO,boolean status) {
		String strStatus=StatusMessage.PENDING_CODE;
		if(status)
			entityCountDTO.setCount(compensatoryOffRepository.countAllCompOffPendingReqList(companyId, strStatus)); 
		else
			entityCountDTO.setCount(compensatoryOffRepository.countAllCompOffExcludedPendingReqList(companyId, strStatus));
			
		
	}

	@Override
	public List<Object[]> findCandidatePagedAndFilterResult(Long companyId, CompOffSearchDTO compOffSearchDTO,boolean status) {
		return compensatoryOffPaginatonRepository.findCompOffPagedAndFilterResult(companyId, compOffSearchDTO,status);
	}

}
