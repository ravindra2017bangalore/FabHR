package com.csipl.hrms.service.payroll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.service.payroll.repository.PayrollControlRepository;
import com.csipl.hrms.service.util.ConverterUtil;

@Service("payrollControlService")
public class PayrollControlServiceImpl implements PayrollControlService {

	@Autowired
	PayrollControlRepository payrollControlRepository;

	/**
	 * to get PayrollControl object based on companyId
	 */
	@Override
	public List<PayrollControl> findPayrollControl(long companyId) {
		return payrollControlRepository.findPayrollControl(companyId);

	}

	/**
	 * Method Performed save operation, save List of PayrollControl objects
	 */
	@Override
	public void save(List<PayrollControl> payrollControlList) {
		payrollControlRepository.save(payrollControlList);
	}

	/**
	 * to get PayrollControl object based on companyId and processMonth
	 */
	@Override
	public PayrollControl findPayrollControlByMonth(long companyId, String processMonth) {
		return payrollControlRepository.findPayrollControlByMonth(companyId, processMonth);
	}

	/**
	 * to get List of Department objects from database based on companyId and
	 * processMonth and method also check departments are within payroll lock
	 * criteria OR not
	 */
	@Override
	public List<Department> findAllDepartmentNotINPayrollLock(long companyId, String processMonth) {
		// TODO Auto-generated method stub

		List<Object[]> departmentObj = payrollControlRepository.findAllDepartmentNotINPayrollLock(companyId,
				processMonth);
		List<Department> departmentList = new ArrayList<Department>();

		for (Object[] dept : departmentObj) {
			Department departMent = new Department();
			departMent.setDepartmentId(ConverterUtil.getLong(dept[0]));
			departMent.setDepartmentName(ConverterUtil.getString(dept[1]));
			departmentList.add(departMent);
		}

		return departmentList;
	}

	/**
	 * to get List of Department objects from database based on companyId and
	 * processMonth and method also check departments are within ReportPayOut
	 * criteria OR not
	 */
	@Override
	public List<Department> findAllDepartmentNotINReportPayOut(long companyId, String processMonth) {
		List<Object[]> departmentObj = payrollControlRepository.findAllDepartmentNotINReportPayOut(companyId,
				processMonth);
		List<Department> departmentList = new ArrayList<Department>();

		for (Object[] dept : departmentObj) {
			Department departMent = new Department();
			departMent.setDepartmentId(ConverterUtil.getLong(dept[0]));
			departMent.setDepartmentName(ConverterUtil.getString(dept[1]));
			departmentList.add(departMent);
		}

		return departmentList;
	}

	/**
	 * to get List of Department objects from database based on companyId and
	 * processMonth and method also check departments are within ReportPayOut
	 * criteria OR not
	 */
	@Override
	public List<Department> findAllDepartmentForPayRoll(long companyId, String processMonth) {
		List<Object[]> departmentObj = payrollControlRepository.findAllDepartmentForPayRoll(companyId, processMonth);
		List<Department> departmentList = new ArrayList<Department>();

		for (Object[] dept : departmentObj) {
			Department departMent = new Department();
			departMent.setDepartmentId(ConverterUtil.getLong(dept[0]));
			departMent.setDepartmentName(ConverterUtil.getString(dept[1]));
			departmentList.add(departMent);
		}

		return departmentList;
	}

	/**
	 * to get List of rocessMonth from database based on companyId
	 */
	@Override
	public List<String> findPayrollProcessControl(long companyId) {
		return payrollControlRepository.findPayrollProcessControl(companyId);
	}

	/**
	 * to get List of processMonth from database based on companyId
	 */
	@Override
	public List<String> findPayrollProcessControl1(long companyId) {
		// TODO Auto-generated method stub
		return payrollControlRepository.findPayrollProcessControl1(companyId);
	}

	/**
	 * to get List of Open processMonth from database based companyId
	 */
	@Override
	public List<String> getPayrollOpenProMon(long companyId) {
		return payrollControlRepository.getPayrollOpenProMon(companyId);
	}

	@Override
	public List<String> findPayrollProcessControlById(long companyId, Long financialYearId) {
		// TODO Auto-generated method stub
		return payrollControlRepository.findPayrollProcessControlById(financialYearId);
	}

}
