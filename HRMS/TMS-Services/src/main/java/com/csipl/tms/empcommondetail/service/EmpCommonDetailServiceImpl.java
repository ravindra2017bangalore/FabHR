package com.csipl.tms.empcommondetail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.empcommondetail.repository.EmpCommonDetailRepository;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;

@Transactional
@Service("empCommonDetailService")
public class EmpCommonDetailServiceImpl implements EmpCommonDetailService {

	@Autowired
	EmpCommonDetailRepository empCommonDetailRepository;

	@Override
	public EmpCommonDetail getEmployeeCommonDetails(Long employeeId) {
		return empCommonDetailRepository.getEmployeeCommonDetails(employeeId);
	}

	@Override
	public List<EmpCommonDetail> getEmployeeCommonDetailsList(Long companyId) {
		return empCommonDetailRepository.getEmployeeCommonDetailsList(companyId);
	}

	@Override
	public Object[] getEmployeeJoiningDate(Long employeeId) {
		return empCommonDetailRepository.getEmployeeJoiningDate(employeeId);
	}

	@Override
	public void save(EmpCommonDetail empCommonDetail) {
		empCommonDetailRepository.save(empCommonDetail);

	}

}
