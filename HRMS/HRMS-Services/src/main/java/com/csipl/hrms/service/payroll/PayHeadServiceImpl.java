package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.payroll.PayHead;
import com.csipl.hrms.service.payroll.repository.PayHeadRepository;

@Service("payHeadService")
public class PayHeadServiceImpl implements PayHeadService {

	@Autowired
	private PayHeadRepository payheadRepository;

	/**
	 * to get List of  PayHead objects from database based on companyId and earning OR
	 * deduction
	 */
	@Override
	public List<PayHead> getAllPayHeads(String opt,Long companyId) {
		return payheadRepository.findAllPayHead(opt,companyId);
	}
	/**
	 * Method Performed save OR update operation
 	 */
 	@Override
	public PayHead save(PayHead payHead) {
		return payheadRepository.save(payHead);
	}
 	/**
	 * to get List of PayHead objects from database based on companyId  
 	 */
	@Override
	public List<PayHead> findAllPayHeadOfCompany( long  companyId ) {
		return payheadRepository.findAllPayHeadOfCompany( companyId );
	}
	/**
	 * to  PayHead object from database based on payHeadId (Primary Key)  
 	 */
	@Override
	public PayHead findPayHeadById(long payHeadId) {
 		return	payheadRepository.findOne( payHeadId );
 	}
 }
