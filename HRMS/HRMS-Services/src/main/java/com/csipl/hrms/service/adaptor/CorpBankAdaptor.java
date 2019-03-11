package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.payroll.CorpBankDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.Bank;


public class CorpBankAdaptor implements Adaptor<CorpBankDTO, Bank> {

	@Override
	public List<Bank> uiDtoToDatabaseModelList(List<CorpBankDTO> corpBankDtoList) {
		List<Bank> bankList=new ArrayList<Bank>();
		for(CorpBankDTO corpBankDto:corpBankDtoList) {
		
			bankList.add(uiDtoToDatabaseModel(corpBankDto));
		}
		return bankList;
	}

	@Override
	public List<CorpBankDTO> databaseModelToUiDtoList(List<Bank> bankList) {
		List<CorpBankDTO> corpBankDtoList=new ArrayList<CorpBankDTO>();
		for(Bank bank:bankList) {
		
			corpBankDtoList.add(databaseModelToUiDto(bank));
		}
		return corpBankDtoList;
	}

	@Override
	public Bank uiDtoToDatabaseModel(CorpBankDTO corpBankDto) {
		Bank bank=new Bank();
		Company company=new Company();
		company.setCompanyId(corpBankDto.getCompanyId());
		Groupg group=new Groupg();
		group.setGroupId(1L);
		bank.setCompany(company);
		bank.setGroupg(group);
		bank.setBankId(corpBankDto.getBankId());
		bank.setBankName(corpBankDto.getBankName());
		bank.setAccountNo(corpBankDto.getAccountNo());
		bank.setIFSCCode(corpBankDto.getIfscCode());
		bank.setBankBranch(corpBankDto.getBankBranch());
		bank.setAccountHolder(corpBankDto.getAccountHolder());
		bank.setUserId(corpBankDto.getUserId());
		bank.setUserIdUpdate(corpBankDto.getUserIdUpdate());
		bank.setDateUpdate(new Date());
		if(corpBankDto.getBankId()!=null)
		bank.setDateCreated(corpBankDto.getDateCreated());
		else
			bank.setDateCreated(new Date());
		return bank;
	}

	@Override
	public CorpBankDTO databaseModelToUiDto(Bank bank) {
		CorpBankDTO corpBankDto=new CorpBankDTO();
		corpBankDto.setBankId(bank.getBankId());
		corpBankDto.setBankName(bank.getBankName());
		corpBankDto.setAccountNo(bank.getAccountNo());
		corpBankDto.setIfscCode(bank.getIFSCCode());
		corpBankDto.setBankBranch(bank.getBankBranch());
		corpBankDto.setAccountHolder(bank.getAccountHolder());
		corpBankDto.setUserId(bank.getUserId());
		corpBankDto.setDateCreated(bank.getDateCreated());
		corpBankDto.setBankNameValue(DropDownCache.getInstance().getDropDownValue( DropDownEnum.BankName.getDropDownName() , bank.getBankName()));
		return corpBankDto;
	}

}
