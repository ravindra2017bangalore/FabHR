package com.csipl.hrms.service.payroll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;
import com.csipl.hrms.service.payroll.repository.TdsStandardExemptionRepository;

@Service("tdsStandardExemptionService")
public class TdsStandardExemptionServiceImpl implements TdsStandardExemptionService {

	@Autowired 
	TdsStandardExemptionRepository tdsStandardExemptionRepository;
	
	@Autowired
	FinancialYearRepository financialYearRepository;
	
	@Override
	public List<TdsStandardExemption> getAllTdsStandardExemptionList(Long companyId) {
		return tdsStandardExemptionRepository.findAllTdsStandardExemption(companyId);
	}

	@Override
	public TdsStandardExemption save(TdsStandardExemption tdsStandardExemption) {
		return tdsStandardExemptionRepository.save(tdsStandardExemption);
	}

	@Override
	public TdsStandardExemption getTdsStandardExemption(Long companyId) {
		DateUtils dateUtils=new DateUtils();
		Date currentDate=dateUtils.getCurrentDate();
		FinancialYear financialYear=financialYearRepository.getFinancialYear(currentDate, companyId);
		return tdsStandardExemptionRepository.findTdsStandardExemption(companyId, financialYear.getFinancialYear());
	}
}
