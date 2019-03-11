package com.csipl.hrms.service.payroll;

import java.util.List;
import com.csipl.hrms.model.payroll.Bank;

public interface CorpBankService {
	
	public List<Bank> getAllBanks(Long companyId);

	public Bank save(Bank bank);
  	
	public Bank findBank(Long bankId);

}
