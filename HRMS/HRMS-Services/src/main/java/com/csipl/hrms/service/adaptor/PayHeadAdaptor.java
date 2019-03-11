package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.payroll.PayHeadDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.PayHead;

public class PayHeadAdaptor implements Adaptor<PayHeadDTO, PayHead> {


	@Override
	public List<PayHead> uiDtoToDatabaseModelList(List<PayHeadDTO> payheadDtoList) {
		List<PayHead> payhead = new ArrayList<PayHead>();
		for (PayHeadDTO payheadDto : payheadDtoList) {

			payhead.add(uiDtoToDatabaseModel(payheadDto));
		}
		return payhead;
	}

	@Override
	public List<PayHeadDTO> databaseModelToUiDtoList(List<PayHead> payheadList) {
		List<PayHeadDTO> payHeadDtoList = new ArrayList<PayHeadDTO>();
		for (PayHead payhead : payheadList) {

			payHeadDtoList.add(databaseModelToUiDto(payhead));
		}
		return payHeadDtoList;
	}

	@Override
	public PayHead uiDtoToDatabaseModel(PayHeadDTO payheadDto) {
		PayHead payhead = new PayHead();
		Company company=new Company();
		Groupg group=new Groupg();
		company.setCompanyId(payheadDto.getCompanyId());
		payhead.setCompany(company);
		payhead.setPayHeadId(payheadDto.getPayHeadId());
		payhead.setPayHeadName(payheadDto.getPayHeadName());
		payhead.setEarningDeduction(payheadDto.getEarningDeduction());
		payhead.setExpenseType(payheadDto.getExpenseType());
		payhead.setIncomeType(payheadDto.getIncomeType());
		payhead.setIsApplicableOnGratuaty(payheadDto.getIsApplicableOnGratuaty());
		payhead.setIsApplicableOnEsi(payheadDto.getIsApplicableOnEsi());
		payhead.setIsApplicableOnPf(payheadDto.getIsApplicableOnPf());
		payhead.setIsApplicableOnPt(payheadDto.getIsApplicableOnPt());
		payhead.setUserId(payheadDto.getUserId());
		payhead.setUserIdUpdate(payheadDto.getUserIdUpdate());
		payhead.setDateUpdate(new Date());
		group.setGroupId(1L);
		payhead.setGroupg(group);
		if(payheadDto.getPayHeadId()==null) 
			payhead.setDateCreated(new Date());
		else
			payhead.setDateCreated(payheadDto.getDateCreated());
		return payhead;
	}

	@Override
	public PayHeadDTO databaseModelToUiDto(PayHead payhead) {
		PayHeadDTO payheadDto = new PayHeadDTO();
		payheadDto.setPayHeadId(payhead.getPayHeadId());
		payheadDto.setPayHeadName(payhead.getPayHeadName());
		payheadDto.setExpenseType(  payhead.getExpenseType() );
		payheadDto.setIncomeType( payhead.getIncomeType() );
		payheadDto.setEarningDeduction( payhead.getEarningDeduction() );
		
		payheadDto.setExpenseTypeValue( DropDownCache.getInstance().getDropDownValue( DropDownEnum.expense.getDropDownName() , payhead.getExpenseType() ) );
		payheadDto.setIncomeTypeValue(  DropDownCache.getInstance().getDropDownValue(DropDownEnum.incomeType.getDropDownName(), payhead.getIncomeType()) );
		payheadDto.setEarningDeductionValue( DropDownCache.getInstance().getDropDownValue(DropDownEnum.earningDeduction.getDropDownName(), payhead.getEarningDeduction())  );
		
		payheadDto.setIsApplicableOnGratuaty(payhead.getIsApplicableOnGratuaty());
		payheadDto.setIsApplicableOnEsi(payhead.getIsApplicableOnEsi());
		payheadDto.setIsApplicableOnPf(payhead.getIsApplicableOnPf());
		payheadDto.setIsApplicableOnPt(payhead.getIsApplicableOnPt());
		payheadDto.setUserId(payhead.getUserId());
		payheadDto.setDateCreated(payhead.getDateCreated());
		return payheadDto;
	}

}
