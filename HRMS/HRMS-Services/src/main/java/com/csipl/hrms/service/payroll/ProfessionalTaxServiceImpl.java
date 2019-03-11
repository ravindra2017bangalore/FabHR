package com.csipl.hrms.service.payroll;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.ProfessionalTax;
import com.csipl.hrms.service.payroll.repository.ProfessionalTaxRepository;

@Service("professionalTaxService")
public class ProfessionalTaxServiceImpl implements ProfessionalTaxService {

	@Autowired
	private ProfessionalTaxRepository professionalTaxRepository;
	
	

	/**
	 * Save OR update ProfessionalTax
	 */
	@Override
	public ProfessionalTax save(ProfessionalTax professionalTax) {
		return professionalTaxRepository.save(professionalTax);
	}

	/**
	 * to get List of ProfessionalTax objects from database based on currentDate
	 */
	@Override
	public List<ProfessionalTax> getAllProfessionalTax(Long companyId) {
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		System.out.println("current date ....."+currentDate);
		return professionalTaxRepository.findAllProfessionalTax(currentDate, companyId);
	}

	/**
	 * to get ProfessionalTax object from database based on stateId
	 */
	@Override
	public ProfessionalTax findProfessionalTaxOfEmployee( long stateId, Long companyId ) {
		
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		List<ProfessionalTax> profTaxList = professionalTaxRepository.findProfessionalTaxOfEmployee(stateId, companyId, currentDate);
		ProfessionalTax professionalTax = null;
		if (profTaxList != null && profTaxList.size() > 0) {
			professionalTax = profTaxList.get(0);
		}
		return professionalTax;
	}

	/**
	 * to get ProfessionalTax object from database based on proTaxId (Primary Key)
	 */
	@Override
	public ProfessionalTax findProfessionalTax(long professionalHeadId ,Long companyId) {
		return professionalTaxRepository.findProfessionalTax(professionalHeadId ,companyId);
	}

}
