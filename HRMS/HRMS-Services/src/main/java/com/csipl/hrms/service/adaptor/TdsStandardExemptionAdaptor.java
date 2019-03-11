package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.payroll.TdsStandardExemptionDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.payroll.TdsStandardExemption;

public class TdsStandardExemptionAdaptor implements Adaptor<TdsStandardExemptionDTO, TdsStandardExemption> {

	@Override
	public List<TdsStandardExemption> uiDtoToDatabaseModelList(List<TdsStandardExemptionDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TdsStandardExemptionDTO> databaseModelToUiDtoList(List<TdsStandardExemption> tdsStandardExemptionList) {
		List<TdsStandardExemptionDTO> tdsStandardExemptionDtoList=new ArrayList<TdsStandardExemptionDTO>();
		for(TdsStandardExemption tdsStandardExemption:tdsStandardExemptionList) {
			tdsStandardExemptionDtoList.add(databaseModelToUiDto(tdsStandardExemption));
		}
		return tdsStandardExemptionDtoList;
	}

	@Override
	public TdsStandardExemption uiDtoToDatabaseModel(TdsStandardExemptionDTO tdsStandardExemptionDto) {
		TdsStandardExemption tdsStandardExemption = new TdsStandardExemption();
		tdsStandardExemption.setTdsStandardExemptionId(tdsStandardExemptionDto.getTdsStandardExemptionId());
		tdsStandardExemption.setFinancialYear(tdsStandardExemptionDto.getFinancialYear());
		tdsStandardExemption.setAmount(tdsStandardExemptionDto.getAmount());
		tdsStandardExemption.setUserId(tdsStandardExemptionDto.getUserId());
		tdsStandardExemption.setDateCreated(tdsStandardExemptionDto.getDateCreated());
		Company company=new Company();
		company.setCompanyId(tdsStandardExemptionDto.getCompanyId());
		tdsStandardExemption.setCompany(company);
		if(tdsStandardExemptionDto.getDateCreated()==null)
			tdsStandardExemption.setDateCreated(new Date());
		else
			tdsStandardExemption.setDateCreated(tdsStandardExemptionDto.getDateCreated());
		tdsStandardExemption.setDateUpdate(new Date());
		tdsStandardExemption.setUserIdUpdate(tdsStandardExemptionDto.getUserIdUpdate());
		return tdsStandardExemption;
	}

	@Override
	public TdsStandardExemptionDTO databaseModelToUiDto(TdsStandardExemption tdsStandardExemption) {
		TdsStandardExemptionDTO tdsStandardExemptionDto = new TdsStandardExemptionDTO();
		tdsStandardExemptionDto.setTdsStandardExemptionId(tdsStandardExemption.getTdsStandardExemptionId());
		tdsStandardExemptionDto.setFinancialYear(tdsStandardExemption.getFinancialYear());
		tdsStandardExemptionDto.setAmount(tdsStandardExemption.getAmount());
		tdsStandardExemptionDto.setUserId(tdsStandardExemption.getUserId());
		tdsStandardExemptionDto.setDateCreated(tdsStandardExemption.getDateCreated());
		return tdsStandardExemptionDto;
	}

}
