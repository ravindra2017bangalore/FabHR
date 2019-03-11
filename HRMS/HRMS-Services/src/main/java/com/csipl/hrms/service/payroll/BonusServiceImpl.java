package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.payroll.Bonus;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.BonusRepository;

@Service("bonusService")
public class BonusServiceImpl implements BonusService {

	@Autowired
	private BonusRepository bonusRepository;
	/**
	 * to get List of  bonus objects from database based on companyId
	 */
	@Override
	public List<Bonus> getAllBonus(Long companyId) {
		return bonusRepository.findAllBonus(companyId);
	}
	/**
	 * Save OR update bonus object  into Database 
	 */
	@Override
	public Bonus save(Bonus bonus) {
		return bonusRepository.save(bonus);
	}
 	/**
	 * to get  bonus object from database based on Long bonusId (Primary Key)
	 * 
	 */
	@Override
	public Bonus findBonus(Long bonusId) {
		
		return bonusRepository.findOne(bonusId);
	}
	/**
	 * to get  bonus object from database based on financialYear and gradesId and activeStatus and companyId
	 * 
	 */
	@Override
	public Bonus getBonus(String financialYear, Grade grade, String activeStatus, Long companyId) {
 		return bonusRepository.getBonus(financialYear,grade.getGradesId(),activeStatus,companyId);
	}

}
