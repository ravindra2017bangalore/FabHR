package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.ProfessionalTax;

public interface ProfessionalTaxService {

	public List<ProfessionalTax> getAllProfessionalTax(Long companyId);

	public ProfessionalTax save(ProfessionalTax professionalTax);
	
	 public ProfessionalTax findProfessionalTaxOfEmployee( long stateId, Long companyId );
	 public ProfessionalTax findProfessionalTax( long professionalHeadId ,Long companyId);
}
