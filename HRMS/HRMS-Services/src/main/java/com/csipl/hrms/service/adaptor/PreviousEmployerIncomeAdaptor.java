package com.csipl.hrms.service.adaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.payroll.PreviousEmployerIncomeTdsDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.PreviousEmployerIncome;
import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;

public class PreviousEmployerIncomeAdaptor {

	public List<PreviousEmployerIncomeTds> uiDtoToDatabaseModelList(
			List<PreviousEmployerIncomeTdsDTO> previousEmployerIncomeTdsDtoList, Long employeeId) {
		List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList = new ArrayList<>();

		for (PreviousEmployerIncomeTdsDTO previousEmployerIncomeTdsDto : previousEmployerIncomeTdsDtoList) {
			previousEmployerIncomeTdsList.add(uiDtoToDatabaseModel(previousEmployerIncomeTdsDto, employeeId));
		}
		return previousEmployerIncomeTdsList;
	}

	public PreviousEmployerIncomeTds uiDtoToDatabaseModel(PreviousEmployerIncomeTdsDTO previousEmployerIncomeTdsDto,
			Long employeeId) {
		DateUtils dateUtils = new DateUtils();
		PreviousEmployerIncomeTds previousEmployerIncomeTds = new PreviousEmployerIncomeTds();
		Employee employee = new Employee();
		previousEmployerIncomeTds.setPreviousEmployerIncomeTdsId(previousEmployerIncomeTdsDto.getPreviousEmployerIncomeTdsId());
		previousEmployerIncomeTds.setAmount(previousEmployerIncomeTdsDto.getAmount());
		PreviousEmployerIncome previousEmployerIncome = new PreviousEmployerIncome();
		previousEmployerIncome.setPreviousEmployerIncomeId(previousEmployerIncomeTdsDto.getPreviousEmployerIncomeId());
		previousEmployerIncomeTds.setPreviousEmployerIncome(previousEmployerIncome);
		previousEmployerIncomeTds.setUserId(previousEmployerIncomeTdsDto.getUserId());
		employee.setEmployeeId(employeeId);
		previousEmployerIncomeTds.setEmployee(employee);
		previousEmployerIncomeTds.setDateUpdate(new Date());
		previousEmployerIncomeTds.setUserIdUpdate(previousEmployerIncomeTdsDto.getUserIdUpdate());
		if (previousEmployerIncomeTdsDto.getDateCreated() != null)
			previousEmployerIncomeTds
					.setDateCreated(dateUtils.getDateWirhYYYYMMDD(previousEmployerIncomeTdsDto.getDateCreated()));
		else
			previousEmployerIncomeTds.setDateCreated(new Date());
		return previousEmployerIncomeTds;
	}

	public List<PreviousEmployerIncomeTdsDTO> databaseModelToObjectArray(
			List<Object[]> objectPreviousEmployerincomeList) {
		List<PreviousEmployerIncomeTdsDTO> previousEmployerIncomeTdsDtoList = new ArrayList<>();
		for (Object[] tdsPreviousEmployerIncomeObj : objectPreviousEmployerincomeList) {
			PreviousEmployerIncomeTdsDTO previousEmployerIncomeTdsDto = new PreviousEmployerIncomeTdsDTO();
			DateUtils dateUtils = new DateUtils();
			Long previousEmployerIncomeId = tdsPreviousEmployerIncomeObj[0] != null
					? Long.parseLong(tdsPreviousEmployerIncomeObj[0].toString())
					: null;
			String particular = tdsPreviousEmployerIncomeObj[1] != null ? (String) (tdsPreviousEmployerIncomeObj[1])
					: null;
			Long previousEmployerIncomeTdsId = tdsPreviousEmployerIncomeObj[2] != null
					? Long.parseLong(tdsPreviousEmployerIncomeObj[2].toString())
					: null;
			BigDecimal amount = tdsPreviousEmployerIncomeObj[3] != null
					? (new BigDecimal(tdsPreviousEmployerIncomeObj[3].toString()))
					: null;
			String financialYear = tdsPreviousEmployerIncomeObj[4] != null ? (String) tdsPreviousEmployerIncomeObj[4]
					: null;
			Long employeeId = tdsPreviousEmployerIncomeObj[5] != null
					? Long.parseLong(tdsPreviousEmployerIncomeObj[5].toString())
					: null;
			Long userId = tdsPreviousEmployerIncomeObj[6] != null
					? Long.parseLong(tdsPreviousEmployerIncomeObj[6].toString())
					: null;
			Date dateCreated = tdsPreviousEmployerIncomeObj[7] != null ? (Date) tdsPreviousEmployerIncomeObj[7] : null;

			previousEmployerIncomeTdsDto.setPreviousEmployerIncomeId(previousEmployerIncomeId);
			previousEmployerIncomeTdsDto.setParticular(particular);
			previousEmployerIncomeTdsDto.setPreviousEmployerIncomeTdsId(previousEmployerIncomeTdsId);
			previousEmployerIncomeTdsDto.setAmount(amount);
			previousEmployerIncomeTdsDto.setFinancialYear(financialYear);
			previousEmployerIncomeTdsDto.setEmployeeId(employeeId);
			previousEmployerIncomeTdsDto.setUserId(userId);
			if (dateCreated != null)
				previousEmployerIncomeTdsDto.setDateCreated(dateUtils.getDateStringWirhYYYYMMDD(dateCreated));
			previousEmployerIncomeTdsDtoList.add(previousEmployerIncomeTdsDto);
		}

		return previousEmployerIncomeTdsDtoList;
	}

}
