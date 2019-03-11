package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.PayHead;

public interface PayHeadService {

	public List<PayHead> getAllPayHeads(String opt,Long companyId);

	public PayHead save(PayHead payhead);

 	public PayHead findPayHeadById( long payHeadId );
	
	public List<PayHead> findAllPayHeadOfCompany( long  companyId ); 

}
