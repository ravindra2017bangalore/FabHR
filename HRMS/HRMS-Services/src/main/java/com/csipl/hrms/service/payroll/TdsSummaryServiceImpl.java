package com.csipl.hrms.service.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.payroll.TdsSummary;
import com.csipl.hrms.model.payroll.TdsSummaryChange;
import com.csipl.hrms.service.payroll.repository.TdsSummaryChangeRepository;

@Service("tdsSummaryService")
public class TdsSummaryServiceImpl implements TdsSummaryService {

	@Autowired
	TdsSummaryChangeRepository tdsSummaryChangeRepository;
	
	@Override
	public void saveTdsSummary(TdsSummary tdsSummary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TdsSummaryChange getTdsSummary(Long employeeId, String financialYear) {
		return tdsSummaryChangeRepository.findTdsSummary(employeeId, financialYear);
	}

}
