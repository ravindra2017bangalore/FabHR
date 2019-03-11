package com.csipl.hrms.service.payroll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.PayRollLock;
import com.csipl.hrms.service.payroll.repository.PayRollLockRepository;
import com.csipl.hrms.service.util.ConverterUtil;

@Service("payRollLockService")
public class PayRollLockServiceImpl implements PayRollLockService {
	@Autowired
	private PayRollLockRepository payRollLockRepository;
	
	@Override
	public void save(List<PayRollLock>  payRollLock) {
		// TODO Auto-generated method stub
		 payRollLockRepository.save(payRollLock);
	}

	@Override
	public int isSalaryProcessStartedForCompany(Long companyId, String processMonth) {
		
		return payRollLockRepository.isSalaryProcessStartedForCompany(companyId, processMonth);
	}

	@Override
	public int isSalaryProcessStartedForDepartment(Long departmentId, String processMonth) {
		
		return payRollLockRepository.isSalaryProcessStartedForDepartment(departmentId, processMonth);
	}

	@Override
	public void save(PayRollLock payRollLock) {
		 payRollLockRepository.save(payRollLock);
		
	}

	@Override
	public PayRollLock findpayRollLock(String processMonth, Long departmentId) {
		// TODO Auto-generated method stub
		return payRollLockRepository.findpayRollLock(processMonth, departmentId);
	}

	@Override
	public List<PayRollLock> findpayRollLock(String processMonth) {
		// TODO Auto-generated method stub
		
		return payRollLockRepository.findpayRollLock(processMonth);
	}

	@Override
	public List<Department> findDepartmentForSalaryGenerate(long companyId, String processMonth) {
		
		List<Object[]>  departmentObj  = payRollLockRepository.findDepartmentForSalaryGenerate( companyId, processMonth);
		List<Department> departmentList = new ArrayList<Department>();
				
				for ( Object [] dept : departmentObj ) { 
					Department departMent = new Department();
					departMent.setDepartmentId(ConverterUtil.getLong(dept[0]));
					departMent.setDepartmentName(ConverterUtil.getString(dept[1]));
					departmentList.add( departMent );
			     	}	
		
		
		return departmentList;
 	}
	
	
}
