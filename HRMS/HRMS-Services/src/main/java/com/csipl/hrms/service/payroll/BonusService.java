package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.payroll.Bonus;
import com.csipl.hrms.model.payrollprocess.FinancialYear;

public interface BonusService {

	public List<Bonus> getAllBonus(Long companyId);
	public Bonus getBonus(String financialYear,Grade grade,String activeStatus ,Long companyId);

	public Bonus findBonus(Long bonusId);
 	public Bonus save(Bonus bonus);
 
}
