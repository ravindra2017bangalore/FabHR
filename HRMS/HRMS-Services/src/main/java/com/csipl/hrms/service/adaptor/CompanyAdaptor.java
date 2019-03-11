package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.CompanyDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;

public class CompanyAdaptor implements Adaptor<CompanyDTO, Company> {

	AddressAdaptor addressAdaptor = new AddressAdaptor();

	@Override
	public List<Company> uiDtoToDatabaseModelList(List<CompanyDTO> companyDtoList) {
		List<Company> companyList = new ArrayList<Company>();
		for (CompanyDTO companyDto : companyDtoList) {
			companyList.add(uiDtoToDatabaseModel(companyDto));
		}
		return companyList;
	}

	@Override
	public List<CompanyDTO> databaseModelToUiDtoList(List<Company> companyList) {
		List<CompanyDTO> companyDtoList = new ArrayList<CompanyDTO>();
		for (Company company : companyList) {
			companyDtoList.add(databaseModelToUiDto(company));
		}
		return companyDtoList;
	}

	@Override
	public Company uiDtoToDatabaseModel(CompanyDTO companyDto) {

		Company company = new Company();

		if (companyDto != null) {
			company.setUserId(companyDto.getUserId());
			if (companyDto.getCompanyId() != null) {
				company.setCompanyId(companyDto.getCompanyId());
			}
			company.setCompanyName(companyDto.getCompanyName());
			Groupg groupg = new Groupg();
			if (companyDto.getGroupId() != null) {
				groupg.setGroupId(companyDto.getGroupId());
			} else {
				groupg.setGroupId(1l);
				company.setGroupg(groupg);

			}

			groupg.setGroupName(companyDto.getGroupName());
			company.setGroupg(groupg);
			company.setAddress1(addressAdaptor.uiDtoToDatabaseModel(companyDto.getAddress1()));
			company.setAddress2(addressAdaptor.uiDtoToDatabaseModel(companyDto.getAddress2()));
			company.setRetirementAge(companyDto.getRetirementAge());
			company.setPanNo(companyDto.getPanNo());
			company.setRegistrationNo(companyDto.getRegistrationNo());
			company.setEpfNo(companyDto.getEpfNo());
			company.setEsicNo(companyDto.getEsicNo());
			company.setGstNo(companyDto.getGstNo());
			company.setDateOfBirth(companyDto.getDateOfBirth());
			company.setCompanyLogoPath(companyDto.getCompanyLogoPath());
			company.setDateUpdate(new Date());
			company.setUserIdUpdate(companyDto.getUserIdUpdate());
			company.setDomainName(companyDto.getDomainName());

		}

		if (company.getCompanyId() == null)
			company.setDateCreated(new Date());
		else
			company.setDateCreated(companyDto.getDateCreated());

		return company;
	}

	@Override
	public CompanyDTO databaseModelToUiDto(Company company) {

		CompanyDTO companyDto = new CompanyDTO();
		companyDto.setCompanyId(company.getCompanyId());
		companyDto.setCompanyName(company.getCompanyName());

		if (company.getGroupg() != null) {
			companyDto.setGroupId(company.getGroupg().getGroupId());
			companyDto.setGroupName(company.getGroupg().getGroupName());
		}

		if (company.getAddress1() != null)
			companyDto.setAddress1(addressAdaptor.databaseModelToUiDto(company.getAddress1()));

		if (company.getAddress2() != null)
			companyDto.setAddress2(addressAdaptor.databaseModelToUiDto(company.getAddress2()));

		companyDto.setRetirementAge(company.getRetirementAge());
		companyDto.setPanNo(company.getPanNo());
		companyDto.setRegistrationNo(company.getRegistrationNo());
		companyDto.setEpfNo(company.getEpfNo());
		companyDto.setEsicNo(company.getEsicNo());
		companyDto.setGstNo(company.getGstNo());
		companyDto.setUserId(company.getUserId());
		companyDto.setDateCreated(company.getDateCreated());
		companyDto.setDateOfBirth(company.getDateOfBirth());
		companyDto.setCompanyLogoPath(company.getCompanyLogoPath());
		companyDto.setDomainName(company.getDomainName());
		return companyDto;
	}
}
