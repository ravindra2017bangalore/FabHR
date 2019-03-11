package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeStatuary;

public class MandatoryInfoCheckAdaptor implements Adaptor<EmployeeBank, MandatoryInfoCheck> {

	public MandatoryInfoCheck uiDtoToDatabaseModel(EmployeeBank employeeBank, MandatoryInfoCheck mandatoryInfoCheck) {
		if (employeeBank.getAccountNumber() != null) {
			mandatoryInfoCheck.setBa("YES");
		}
		if (mandatoryInfoCheck.getUserId() != null && mandatoryInfoCheck.getDateCreated() != null) {
			mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
			mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
		} else {
			mandatoryInfoCheck.setUserId(employeeBank.getUserId());
			mandatoryInfoCheck.setDateCreated(employeeBank.getDateCreated());
		}
		return mandatoryInfoCheck;
	}

	public MandatoryInfoCheck empStatuaryToDateBase(MandatoryInfoCheck mandatoryInfoCheck,
			List<EmployeeStatuary> employeeStatuaryListResult) {
		if (mandatoryInfoCheck.getUserId() != null && mandatoryInfoCheck.getDateCreated() != null) {
			mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
			mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
		}
		employeeStatuaryListResult.forEach(employeeStatuary -> {
			if (mandatoryInfoCheck.getUserId() == null && mandatoryInfoCheck.getDateCreated() == null) {
				mandatoryInfoCheck.setUserId(employeeStatuary.getUserId());
				mandatoryInfoCheck.setDateCreated(employeeStatuary.getDateCreated());
			}
			if (employeeStatuary.getStatuaryType().equals("UA")) {
				mandatoryInfoCheck.setUa("YES");

			} else {
				if (employeeStatuary.getStatuaryType().equals("ES")) {
					mandatoryInfoCheck.setEs("YES");
				} else {
					if (employeeStatuary.getStatuaryType().equals("ME")) {
						mandatoryInfoCheck.setMi("YES");
					} else {
						if (employeeStatuary.getStatuaryType().equals("AC")) {
							mandatoryInfoCheck.setAi("YES");
						}

					}
				}
			}
		});

		return mandatoryInfoCheck;

	}

	@Override
	public List<MandatoryInfoCheck> uiDtoToDatabaseModelList(List<EmployeeBank> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeBank> databaseModelToUiDtoList(List<MandatoryInfoCheck> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MandatoryInfoCheck uiDtoToDatabaseModel(EmployeeBank uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeBank databaseModelToUiDto(MandatoryInfoCheck dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MandatoryInfoCheck> uiDtoToDatabaseModelListExcel(List<BankDetailsDTO> bankDetailsDtoList,
			Employee employee) {
		List<MandatoryInfoCheck> mandatoryInfoCheckList = new ArrayList<MandatoryInfoCheck>();
		for (BankDetailsDTO bankDetailsDto : bankDetailsDtoList) {
			mandatoryInfoCheckList.add(uiDtoToDatabaseModelExcel(bankDetailsDto, employee));
		}
		return mandatoryInfoCheckList;
	}

	public MandatoryInfoCheck uiDtoToDatabaseModelExcel(BankDetailsDTO bankDetailsDto, Employee employee) {
		MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
		if (employee != null) {
			mandatoryInfoCheck.setEmployee(employee);
			mandatoryInfoCheck.setUserId(employee.getUserId());
			mandatoryInfoCheck.setDateCreated(employee.getDateCreated());
			if (bankDetailsDto.getAccountNumber() != null)
				mandatoryInfoCheck.setBa("YES");
			if (employee.getAdharNumber() != null)
				mandatoryInfoCheck.setUi("YES");
		}
		return mandatoryInfoCheck;
	}
}
