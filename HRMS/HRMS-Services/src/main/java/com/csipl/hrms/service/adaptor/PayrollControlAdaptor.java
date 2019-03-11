package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.dto.payroll.PayrollControlDTO;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayrollControl;

public class PayrollControlAdaptor implements Adaptor<PayrollControlDTO, PayrollControl> {

	@Override
	public List<PayrollControl> uiDtoToDatabaseModelList(List<PayrollControlDTO> PayrollControlDtoList) {
		List<PayrollControl> payrollControlList = new ArrayList<PayrollControl>();
		for (PayrollControlDTO payrollControlDto : PayrollControlDtoList) {
			payrollControlList.add(uiDtoToDatabaseModel(payrollControlDto));
		}
		return payrollControlList;

	}

	@Override
	public List<PayrollControlDTO> databaseModelToUiDtoList(List<PayrollControl> payrollControlList) {
		List<PayrollControlDTO> payrollControlDtoList = new ArrayList<PayrollControlDTO>();
		for (PayrollControl payrollControl : payrollControlList) {
			payrollControlDtoList.add(databaseModelToUiDto(payrollControl));
		}
		return payrollControlDtoList;
	}

	@Override
	public PayrollControl uiDtoToDatabaseModel(PayrollControlDTO payrollControlDto) {
		PayrollControl payrollControl = new PayrollControl();
		payrollControl.setControlId(payrollControlDto.getControlId());
		payrollControl.setPayrollDays(payrollControlDto.getPayrollDays());
		payrollControl.setActiveStatus(payrollControlDto.getActiveStatus());
		FinancialYear financialYear = new FinancialYear();
		financialYear.setFinancialYearId(payrollControlDto.getFinancialYearId());
		payrollControl.setFinancialYear(financialYear);
		payrollControl.setProcessMonth(payrollControlDto.getProcessMonth());
		payrollControl.setUserId(payrollControlDto.getUserId());
		payrollControl.setUserIdUpdate(payrollControlDto.getUserIdUpdate());
		if (payrollControl.getControlId() != null) {
			payrollControl.setDateCreated(payrollControlDto.getDateCreated());
		} else {
			payrollControl.setDateCreated(new Date());
		}
		payrollControl.setDateUpdate(new Date());
		return payrollControl;
	}

	@Override
	public PayrollControlDTO databaseModelToUiDto(PayrollControl payrollControl) {
		PayrollControlDTO payrollControlDto = new PayrollControlDTO();
		payrollControlDto.setProcessMonth(payrollControl.getProcessMonth());
		payrollControlDto.setControlId(payrollControl.getControlId());
		payrollControlDto.setPayrollDays(payrollControl.getPayrollDays());
		payrollControlDto.setActiveStatus(payrollControl.getActiveStatus());
		payrollControlDto.setFinancialYearId(payrollControl.getFinancialYear().getFinancialYearId());
		payrollControlDto.setUserId(payrollControl.getUserId());
		payrollControlDto.setDateCreated(payrollControl.getDateCreated());
		return payrollControlDto;
	}

}
