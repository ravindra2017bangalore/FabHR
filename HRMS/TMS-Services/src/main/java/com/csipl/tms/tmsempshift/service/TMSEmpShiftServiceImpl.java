package com.csipl.tms.tmsempshift.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.tmsempshift.repository.TMSEmpShiftRepository;

@Transactional
@Service("tMSEmpShiftService")
public class TMSEmpShiftServiceImpl implements TMSEmpShiftService{

	@Autowired
	TMSEmpShiftRepository tMSEmpShiftRepository;
	
	@Override
	public Object[] getEmpShiftOnemployeeId(Long employeeId) {
		
		return tMSEmpShiftRepository.getEmpShiftOnemployeeId(employeeId);
	}

}
