package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.organisation.ProjectDTO;
import com.csipl.hrms.dto.payroll.FinancialYearDTO;
import com.csipl.hrms.dto.payroll.PayrollControlDTO;
import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Project;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.service.util.PayrollDateCalculation;

public class PayrollPeriodAdaptor implements Adaptor<FinancialYearDTO, FinancialYear> {
	PayrollDateCalculation payrollDateCal = new PayrollDateCalculation();
	PayrollControlAdaptor payrollControlAdaptor = new PayrollControlAdaptor();

	@Override
	public FinancialYear uiDtoToDatabaseModel(FinancialYearDTO financialYearDto) {
		List<PayrollControl> payrollControlList = new ArrayList<PayrollControl>();
		FinancialYear financialYear = new FinancialYear();
		financialYear.setDateFrom(financialYearDto.getDateFrom());
		financialYear.setIsPayrollDaysManuals(financialYearDto.getIsPayrollDaysManuals());

		financialYear.setDateTo(payrollDateCal.getLastDate(financialYear.getDateFrom()));

		financialYear.setFinancialYear(payrollDateCal.getFinancialYear(financialYear.getDateFrom()));

		financialYear.setPayrollControls(payrollDateCal.getPayrollControl(financialYear));

		financialYear.setUserId(financialYearDto.getUserId());

		financialYear.setDateCreated(financialYearDto.getDateCreated());

		return financialYear;
	}

	@Override
	public List<FinancialYear> uiDtoToDatabaseModelList(List<FinancialYearDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PayrollControlDTO> databaseModelToPayControlDto(FinancialYear financialYear) {

		return payrollControlAdaptor.databaseModelToUiDtoList(financialYear.getPayrollControls());
	}

	@Override
	public FinancialYearDTO databaseModelToUiDto(FinancialYear dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinancialYearDTO> databaseModelToUiDtoList(List<FinancialYear> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
