package com.csipl.hrms.service.adaptor;

import java.util.List;

import com.csipl.hrms.dto.payroll.TdsSummaryChangeDTO;
import com.csipl.hrms.model.payroll.TdsSummaryChange;

public class TdsSummaryChangeAdaptor implements Adaptor<TdsSummaryChangeDTO, TdsSummaryChange> {

	@Override
	public List<TdsSummaryChange> uiDtoToDatabaseModelList(List<TdsSummaryChangeDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TdsSummaryChangeDTO> databaseModelToUiDtoList(List<TdsSummaryChange> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TdsSummaryChange uiDtoToDatabaseModel(TdsSummaryChangeDTO tdsSummaryChangeDto) {
		TdsSummaryChange tdsSummaryChange = new TdsSummaryChange();
		tdsSummaryChange.setYearlyGross(tdsSummaryChangeDto.getYearlyGross());
		tdsSummaryChange.setYearlyGrossFy(tdsSummaryChangeDto.getYearlyGrossFy());
		tdsSummaryChange.setOtherIncome(tdsSummaryChangeDto.getOtherIncome());
		tdsSummaryChange.setPreEmpIncome(tdsSummaryChangeDto.getPreEmpIncome());
		tdsSummaryChange.setNetYearlyIncome(tdsSummaryChangeDto.getNetYearlyIncome());
		tdsSummaryChange.setExempStandard(tdsSummaryChangeDto.getExempStandard());
		tdsSummaryChange.setExempPfAmount(tdsSummaryChangeDto.getExempPfAmount());
		tdsSummaryChange.setExempPtAmount(tdsSummaryChangeDto.getExempPtAmount());
		tdsSummaryChange.setExemptedTotalIncome(tdsSummaryChangeDto.getExemptedTotalIncome());
		tdsSummaryChange.setTotalIncomeProfessionalTax(tdsSummaryChangeDto.getTotalIncomeProfessionalTax());
		tdsSummaryChange.setChapter6a(tdsSummaryChangeDto.getChapter6a());
		tdsSummaryChange.setSection10(tdsSummaryChangeDto.getSection10());
		tdsSummaryChange.setSection24(tdsSummaryChangeDto.getSection24());
		tdsSummaryChange.setTotalDeductionIncome(tdsSummaryChangeDto.getTotalDeductionIncome());
		tdsSummaryChange.setTaxableIncome(tdsSummaryChangeDto.getTaxableIncome());
		tdsSummaryChange.setTax(tdsSummaryChangeDto.getTax());
		tdsSummaryChange.setSurcharge(tdsSummaryChangeDto.getSurcharge());
		tdsSummaryChange.setEducationCess(tdsSummaryChangeDto.getEducationCess());
		tdsSummaryChange.setTotalTax(tdsSummaryChangeDto.getTotalTax());
		tdsSummaryChange.setNetTaxYearly(tdsSummaryChangeDto.getNetTaxYearly());
		tdsSummaryChange.setNetTaxMonthly(tdsSummaryChangeDto.getNetTaxMonthly());
		tdsSummaryChange.setIncomeAfterExemptions(tdsSummaryChangeDto.getIncomeAfterExemptions());
		tdsSummaryChange.setProfessionalTax(tdsSummaryChangeDto.getProfessionalTax());
		tdsSummaryChange.setProvidentFund(tdsSummaryChangeDto.getProvidentFund());
		tdsSummaryChange.setPotalTax(tdsSummaryChangeDto.getPotalTax());
		tdsSummaryChange.setTaxOnIncome(tdsSummaryChangeDto.getTaxOnIncome());
		tdsSummaryChange.setPreviousSurcharge(tdsSummaryChangeDto.getPreviousSurcharge());
		tdsSummaryChange.setPreviousEducationCess(tdsSummaryChangeDto.getPreviousEducationCess());
		tdsSummaryChange.setEducationCessPer(tdsSummaryChangeDto.getEducationCessPer());
		tdsSummaryChange.setSurchargePer(tdsSummaryChangeDto.getSurchargePer());
		tdsSummaryChange.setSection84ARebateTax(tdsSummaryChangeDto.getSection84ARebateTax());
		tdsSummaryChange.setTotal80cAmount(tdsSummaryChangeDto.getTotal80cAmount());
		tdsSummaryChange.setSection84ARebateAmount(tdsSummaryChangeDto.getSection84ARebateAmount());
		return tdsSummaryChange;
	}

	@Override
	public TdsSummaryChangeDTO databaseModelToUiDto(TdsSummaryChange tdsSummaryChange) {
		TdsSummaryChangeDTO tdsSummaryChangeDto = new TdsSummaryChangeDTO();
		tdsSummaryChangeDto.setYearlyGross(tdsSummaryChange.getYearlyGross());
		tdsSummaryChangeDto.setYearlyGrossFy(tdsSummaryChange.getYearlyGrossFy());
		tdsSummaryChangeDto.setOtherIncome(tdsSummaryChange.getOtherIncome());
		tdsSummaryChangeDto.setPreEmpIncome(tdsSummaryChange.getPreEmpIncome());
		tdsSummaryChangeDto.setNetYearlyIncome(tdsSummaryChange.getNetYearlyIncome());
		tdsSummaryChangeDto.setExempStandard(tdsSummaryChange.getExempStandard());
		tdsSummaryChangeDto.setExempPfAmount(tdsSummaryChange.getExempPfAmount());
		tdsSummaryChangeDto.setExempPtAmount(tdsSummaryChange.getExempPtAmount());
		tdsSummaryChangeDto.setExemptedTotalIncome(tdsSummaryChange.getExemptedTotalIncome());
		tdsSummaryChangeDto.setTotalIncomeProfessionalTax(tdsSummaryChange.getTotalIncomeProfessionalTax());
		tdsSummaryChangeDto.setChapter6a(tdsSummaryChange.getChapter6a());
		tdsSummaryChangeDto.setSection10(tdsSummaryChange.getSection10());
		tdsSummaryChangeDto.setSection24(tdsSummaryChange.getSection24());
		tdsSummaryChangeDto.setTotalDeductionIncome(tdsSummaryChange.getTotalDeductionIncome());
		tdsSummaryChangeDto.setTaxableIncome(tdsSummaryChange.getTaxableIncome());
		tdsSummaryChangeDto.setTax(tdsSummaryChange.getTax());
		tdsSummaryChangeDto.setSurcharge(tdsSummaryChange.getSurcharge());
		tdsSummaryChangeDto.setEducationCess(tdsSummaryChange.getEducationCess());
		tdsSummaryChangeDto.setTotalTax(tdsSummaryChange.getTotalTax());
		tdsSummaryChangeDto.setNetTaxYearly(tdsSummaryChange.getNetTaxYearly());
		tdsSummaryChangeDto.setNetTaxMonthly(tdsSummaryChange.getNetTaxMonthly());
		tdsSummaryChangeDto.setIncomeAfterExemptions(tdsSummaryChange.getIncomeAfterExemptions());
		tdsSummaryChangeDto.setProfessionalTax(tdsSummaryChange.getProfessionalTax());
		tdsSummaryChangeDto.setProvidentFund(tdsSummaryChange.getProvidentFund());
		tdsSummaryChangeDto.setPotalTax(tdsSummaryChange.getPotalTax());
		tdsSummaryChangeDto.setTaxOnIncome(tdsSummaryChange.getTaxOnIncome());
		tdsSummaryChangeDto.setPreviousSurcharge(tdsSummaryChange.getPreviousSurcharge());
		tdsSummaryChangeDto.setPreviousEducationCess(tdsSummaryChange.getPreviousEducationCess());
		tdsSummaryChangeDto.setFinancialYear(tdsSummaryChange.getFinancialYear());
		tdsSummaryChangeDto.setEducationCessPer(tdsSummaryChange.getEducationCessPer());
		tdsSummaryChangeDto.setSurchargePer(tdsSummaryChange.getSurchargePer());
		tdsSummaryChangeDto.setSection84ARebateTax(tdsSummaryChange.getSection84ARebateTax());
		tdsSummaryChangeDto.setTotal80cAmount(tdsSummaryChange.getTotal80cAmount());
		tdsSummaryChangeDto.setSection84ARebateAmount(tdsSummaryChange.getSection84ARebateAmount());
		return tdsSummaryChangeDto;
	}

}
