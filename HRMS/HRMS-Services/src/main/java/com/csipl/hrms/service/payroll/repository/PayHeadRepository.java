package com.csipl.hrms.service.payroll.repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.PayHead;



public interface PayHeadRepository extends CrudRepository<PayHead, Long> {
	

	@Query(" from PayHead where earningDeduction=?1 AND companyId=?2 ORDER BY  payHeadId  DESC  ")
    public List<PayHead> findAllPayHead(String earningDeduction,Long  companyId);
	
	@Query(" from PayHead where companyId=?1 ORDER BY  payHeadId  DESC  ")
    public List<PayHead> findAllPayHeadOfCompany( long  companyId );
	
	/*
	@Query(" from PayHead where earningDeduction=?1 ORDER BY  payHeadId  DESC  ")
    public List<PayHead> findAllPayHead1(String opt);*/
}
