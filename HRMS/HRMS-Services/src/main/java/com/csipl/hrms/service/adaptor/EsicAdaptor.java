package com.csipl.hrms.service.adaptor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.payroll.EsiDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.Esi;


public class EsicAdaptor implements Adaptor<EsiDTO, Esi> {

	@Override
	public List<Esi> uiDtoToDatabaseModelList(List<EsiDTO> esicDtoList) {
		List<Esi> esicList=new ArrayList<Esi>();
		for(EsiDTO esicDto:esicDtoList) {
		
			esicList.add(uiDtoToDatabaseModel(esicDto));
		}
		return esicList;
	}

	@Override
	public List<EsiDTO> databaseModelToUiDtoList(List<Esi> esicList) {
		List<EsiDTO> esicDtoList=new ArrayList<EsiDTO>();
		for(Esi esic:esicList) {
		
			esicDtoList.add(databaseModelToUiDto(esic));
		}
		return esicDtoList;
	}

	@Override
	public Esi uiDtoToDatabaseModel(EsiDTO esicDto) {
		
		Esi esic=new Esi();
		esic.setEsiId(esicDto.getEsiId());
		esic.setEffectiveDate(esicDto.getEffectiveDate());
		esic.setEmployeePer(esicDto.getEmployeePer());
		esic.setEmployerPer(esicDto.getEmployerPer());
		esic.setMaxGrossLimit(esicDto.getMaxGrossLimit());
		esic.setActiveStatus(esicDto.getActiveStatus());
		esic.setUserId(esicDto.getUserId());
		Company company=new Company();
		company.setCompanyId(esicDto.getCompanyId());
		esic.setCompany(company);
		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		esic.setGroupg(groupg);
		esic.setDateUpdate(new Date());
		if(esicDto.getDateCreated()==null)
			esic.setDateCreated(new Date());
		else
			esic.setDateCreated(esicDto.getDateCreated());
		esic.setUserIdUpdate(esicDto.getUserIdUpdate());
		return esic;
	}

	@Override
	public EsiDTO databaseModelToUiDto(Esi esic) {
		EsiDTO esicDto=new EsiDTO();
		esicDto.setEsiId(esic.getEsiId());
		esicDto.setEffectiveDate(esic.getEffectiveDate());
		esicDto.setEmployeePer(esic.getEmployeePer());
		esicDto.setEmployerPer(esic.getEmployerPer());
		esicDto.setMaxGrossLimit(esic.getMaxGrossLimit());
		esicDto.setActiveStatus(esic.getActiveStatus());
		esicDto.setUserId(esic.getUserId());
		esicDto.setDateCreated(esic.getDateCreated());
		return esicDto;
	}
	public EsiDTO databaseModelToUiDtoObject(List<Esi> esicList)
	{
		

		for(Esi esic:esicList) {
		
			return databaseModelToUiDto(esic);
		}
		return null;
	}

}
