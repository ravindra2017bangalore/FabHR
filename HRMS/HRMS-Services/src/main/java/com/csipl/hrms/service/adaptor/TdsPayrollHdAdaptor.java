package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.payroll.TdsPayrollDTO;
import com.csipl.hrms.dto.payroll.TdsPayrollHdDTO;
import com.csipl.hrms.model.payroll.TdsPayroll;
import com.csipl.hrms.model.payroll.TdsPayrollHd;

public class TdsPayrollHdAdaptor implements Adaptor<TdsPayrollHdDTO, TdsPayrollHd> {
	
	@Override
	public List<TdsPayrollHd> uiDtoToDatabaseModelList(List<TdsPayrollHdDTO> uiobj) {
		
		return null;
	}

	@Override
	public List<TdsPayrollHdDTO> databaseModelToUiDtoList(List<TdsPayrollHd> dbobj) {
	
		return null;
	}

	@Override
	public TdsPayrollHd uiDtoToDatabaseModel(TdsPayrollHdDTO tdsPayrollHdDto) {
		
		return null;
	}

	@Override
	public TdsPayrollHdDTO databaseModelToUiDto(TdsPayrollHd tdsPayrollHd) {
		TdsPayrollHdDTO tdsPayrollHdDto=new TdsPayrollHdDTO();
		tdsPayrollHdDto.setFinancialYear(tdsPayrollHd.getFinancialYear());
		tdsPayrollHdDto.setGrossIncome(tdsPayrollHd.getGrossIncome());
		tdsPayrollHdDto.setTaxableAmount(tdsPayrollHd.getTaxableAmount());
		tdsPayrollHdDto.setTdsApproved(tdsPayrollHd.getTdsApproved());
		List<TdsPayrollDTO> tdsPayrollDtoList=new ArrayList<>();
		for(TdsPayroll tdsPayroll : tdsPayrollHd.getTdsPayrolls()) {
			TdsPayrollDTO tdsPayrollDto=new TdsPayrollDTO();
			tdsPayrollDto.setLimitFrom(tdsPayroll.getLimitFrom());
			tdsPayrollDto.setLimitTo(tdsPayroll.getLimitTo());
			tdsPayrollDto.setActualAmount(tdsPayroll.getActualAmount());
			tdsPayrollDto.setTdsPercentage(tdsPayroll.getTdsPercentage());
			tdsPayrollDto.setTaxAmouunt(tdsPayroll.getTaxAmouunt());
			tdsPayrollDtoList.add(tdsPayrollDto);
		}
		tdsPayrollHdDto.setTdsDtoPayDtorolls(tdsPayrollDtoList);
		return tdsPayrollHdDto;
	}

}
