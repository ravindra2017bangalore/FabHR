package com.csipl.hrms.service.adaptor;

import java.util.List;

import com.csipl.hrms.dto.payroll.TdsSummaryDTO;
import com.csipl.hrms.model.payroll.TdsSummary;

public class TdsSummaryAdaptor implements Adaptor<TdsSummaryDTO, TdsSummary> {

	@Override
	public List<TdsSummary> uiDtoToDatabaseModelList(List<TdsSummaryDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TdsSummaryDTO> databaseModelToUiDtoList(List<TdsSummary> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TdsSummary uiDtoToDatabaseModel(TdsSummaryDTO tdsSummaryDto) {
		TdsSummary tdsSummary=new TdsSummary();
		tdsSummary.setYearlyGross(tdsSummaryDto.getYearlyGross());
		tdsSummary.setOtherIncome(tdsSummaryDto.getOtherIncome());
		tdsSummary.setNetYearlyIncome(tdsSummaryDto.getNetYearlyIncome());
		tdsSummary.setExempStandard(tdsSummaryDto.getExempStandard());
		tdsSummary.setExempPfAmount(tdsSummaryDto.getExempPfAmount());
		tdsSummary.setExempPtAmount(tdsSummaryDto.getExempPtAmount());
		tdsSummary.setExempEsicAmount(tdsSummaryDto.getExempEsicAmount());
		tdsSummary.setExempAmountAsPerSlab(tdsSummaryDto.getExempAmountAsPerSlab());
		tdsSummary.setExemptedTotalIncome(tdsSummaryDto.getExemptedTotalIncome());
		tdsSummary.setYearlyTaxableIncome(tdsSummaryDto.getYearlyTaxableIncome());
		tdsSummary.setTaxableIncomeFy(tdsSummaryDto.getTaxableIncomeFy());
		tdsSummary.setTdsYearlyBeforeDeclaration(tdsSummaryDto.getTdsYearlyBeforeDeclaration());
		tdsSummary.setTdsMonthlyBeforeDeclaration(tdsSummaryDto.getTdsMonthlyBeforeDeclaration());
		tdsSummary.setIncomeDeclared(tdsSummaryDto.getIncomeDeclared());
		tdsSummary.setDeclaredIncomeApproved(tdsSummaryDto.getDeclaredIncomeApproved());
		tdsSummary.setNetTaxableIncome(tdsSummaryDto.getNetTaxableIncome());
		tdsSummary.setTdsYearlyAfterDeclaration(tdsSummaryDto.getTdsYearlyAfterDeclaration());
		tdsSummary.setTdsMonthlyAfterDeclaration(tdsSummaryDto.getTdsMonthlyAfterDeclaration());
		return tdsSummary;
	}

	@Override
	public TdsSummaryDTO databaseModelToUiDto(TdsSummary tdsSummary) {
		TdsSummaryDTO tdsSummaryDto=new TdsSummaryDTO();
		tdsSummaryDto.setYearlyGross(tdsSummary.getYearlyGross());
		tdsSummaryDto.setOtherIncome(tdsSummary.getOtherIncome());
		tdsSummaryDto.setNetYearlyIncome(tdsSummary.getNetYearlyIncome());
		tdsSummaryDto.setExempStandard(tdsSummary.getExempStandard());
		tdsSummaryDto.setExempPfAmount(tdsSummary.getExempPfAmount());
		tdsSummaryDto.setExempPtAmount(tdsSummary.getExempPtAmount());
		tdsSummaryDto.setExempEsicAmount(tdsSummary.getExempEsicAmount());
		tdsSummaryDto.setExempAmountAsPerSlab(tdsSummary.getExempAmountAsPerSlab());
		tdsSummaryDto.setExemptedTotalIncome(tdsSummary.getExemptedTotalIncome());
		tdsSummaryDto.setYearlyTaxableIncome(tdsSummary.getYearlyTaxableIncome());
		tdsSummaryDto.setTaxableIncomeFy(tdsSummary.getTaxableIncomeFy());
		tdsSummaryDto.setTdsYearlyBeforeDeclaration(tdsSummary.getTdsYearlyBeforeDeclaration());
		tdsSummaryDto.setTdsMonthlyBeforeDeclaration(tdsSummary.getTdsMonthlyBeforeDeclaration());
		tdsSummaryDto.setIncomeDeclared(tdsSummary.getIncomeDeclared());
		tdsSummaryDto.setDeclaredIncomeApproved(tdsSummary.getDeclaredIncomeApproved());
		tdsSummaryDto.setNetTaxableIncome(tdsSummary.getNetTaxableIncome());
		tdsSummaryDto.setTdsYearlyAfterDeclaration(tdsSummary.getTdsYearlyAfterDeclaration());
		tdsSummaryDto.setTdsMonthlyAfterDeclaration(tdsSummary.getTdsMonthlyAfterDeclaration());
		tdsSummaryDto.setFinancialYear(tdsSummary.getFinancialYear());
		return tdsSummaryDto;
	}
}
