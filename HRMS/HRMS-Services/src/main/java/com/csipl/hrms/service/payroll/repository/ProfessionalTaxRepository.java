package com.csipl.hrms.service.payroll.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.ProfessionalTax;

 
public interface ProfessionalTaxRepository extends CrudRepository<ProfessionalTax, Long> {
 	@Query(" from ProfessionalTax  where  (effectiveEndDate is null or effectiveEndDate>?1) and (effectiveStartDate is NOT null and effectiveStartDate<=?1) and companyId=?2 ORDER BY  professionalHeadId  DESC")
    public List<ProfessionalTax> findAllProfessionalTax(Date today ,Long companyId);
 	
 	@Query(" from ProfessionalTax profTax where profTax.state.stateId=?1 and companyId=?2 and  (effectiveEndDate is null or effectiveEndDate>?3) and (effectiveStartDate is NOT null and effectiveStartDate<=?3) ")
    public List<ProfessionalTax> findProfessionalTaxOfEmployee( long stateId, long companyId, Date date );
 	
	@Query(" from ProfessionalTax  where professionalHeadId=?1 and companyId=?2 ")
    public ProfessionalTax findProfessionalTax( long professionalHeadId ,Long companyId);
 }



 