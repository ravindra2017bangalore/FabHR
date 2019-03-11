package com.csipl.hrms.service.payroll;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.payroll.Bank;
import com.csipl.hrms.service.payroll.repository.CorpBankRepository;

@Service("corpBankService")
public class CorpBankServiceImpl implements CorpBankService {
	
	@Autowired
	  private CorpBankRepository corpBankRepository;
	/**
	 * to get all banks List from database based on companyId
	 */
	@Override
	public List<Bank> getAllBanks(Long companyId) {
		return corpBankRepository.findAllBank(companyId);
	}
	/**
	 * Save OR update bank object  into Database 
	 */
	@Override
	public Bank save(Bank bank) {
 		return corpBankRepository.save(bank);
	}

	 
	/**
	 * to get bank object from database based on bankId (Primary Key)
	 */
	@Override
	public Bank findBank(Long bankId) {
 		return corpBankRepository.findOne(bankId);
	}
}
