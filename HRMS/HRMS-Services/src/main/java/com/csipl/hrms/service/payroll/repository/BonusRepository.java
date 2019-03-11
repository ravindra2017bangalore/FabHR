package com.csipl.hrms.service.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.payroll.Bonus;
import com.csipl.hrms.model.payrollprocess.FinancialYear;

public interface BonusRepository extends CrudRepository<Bonus, Long> {

	@Query(" from Bonus where companyId =?1 ORDER BY  bonusId  DESC ")
    public List<Bonus> findAllBonus(Long companyId);
	
	@Query(" from Bonus where financialYear=?1 and gradesId=?2 and activeStatus=?3 and companyId =?4  ORDER BY  bonusId  DESC ")
    public Bonus getBonus(String financialYear, long gradesId, String activeStatus, Long companyId);
	
} 
