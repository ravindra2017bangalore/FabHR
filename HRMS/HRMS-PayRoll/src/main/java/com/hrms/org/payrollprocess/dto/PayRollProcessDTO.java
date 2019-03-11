package com.hrms.org.payrollprocess.dto;

import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.payroll.ProfessionalTax;
import com.csipl.hrms.model.payrollprocess.PayOut;

public class PayRollProcessDTO {

	private PayOut payOut;
	private PayStructure payStructure;
	
	
	public PayOut getPayOut() {
		return payOut;
	}
	public void setPayOut(PayOut payOut) {
		this.payOut = payOut;
	}
	public PayStructure getPayStructure() {
		return payStructure;
	}
	public void setPayStructure(PayStructure payStructure) {
		this.payStructure = payStructure;
	}
	
	
}
