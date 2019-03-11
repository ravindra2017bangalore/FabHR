package com.csipl.hrms.service.payroll;

import java.util.List;
import com.csipl.hrms.model.payroll.TdsGroup;

public interface InvestmentService {

	public List<TdsGroup> getInvestmentList( Long companyId);
	public TdsGroup getInvestment(long tdsGroupId);
	public void save(TdsGroup tdsGroup);
}
