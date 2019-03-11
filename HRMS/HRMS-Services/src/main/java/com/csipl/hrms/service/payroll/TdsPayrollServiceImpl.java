package com.csipl.hrms.service.payroll;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.TdsPayrollHd;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;
import com.csipl.hrms.service.payroll.repository.TdsPayrollRepository;

@Service("tdsPayrollService")
public class TdsPayrollServiceImpl implements TdsPayrollService {

	@Autowired
	private TdsPayrollRepository tdsPayrollRepository;
	
	@Autowired
	FinancialYearRepository financialYearRepository;
	
	DateUtils dateUtils=new DateUtils();
	Date currentDate=dateUtils.getCurrentDate();
	
	/**
	 * to getTdsPayrollHd Object from database based on employeeId  and companyId
	 */
	@Override
	public TdsPayrollHd getTdsPayrollHd(Long employeeId, String financialYear) {
		return tdsPayrollRepository.findTdsPayroll(employeeId, financialYear);
	}

}
