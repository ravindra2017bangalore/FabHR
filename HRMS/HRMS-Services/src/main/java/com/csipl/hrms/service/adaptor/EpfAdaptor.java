package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.payroll.EpfDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.Epf;

public class EpfAdaptor implements Adaptor<EpfDTO, Epf> {

	@Override
	public List<Epf> uiDtoToDatabaseModelList(List<EpfDTO> epfDtoList) {
		List<Epf> epfList=new ArrayList<Epf>();
		for(EpfDTO epfDto:epfDtoList) {
		
			epfList.add(uiDtoToDatabaseModel(epfDto));
		}
		return epfList;
	}

	@Override
	public List<EpfDTO> databaseModelToUiDtoList(List<Epf> epfList) {
		List<EpfDTO> epfDtoList=new ArrayList<EpfDTO>();
		for(Epf epf:epfList) {
		
			epfDtoList.add(databaseModelToUiDto(epf));
		}
		return epfDtoList;
	}

	public EpfDTO databaseModelListToUiDtoObject(List<Epf> epfList) {
		
		for(Epf epf:epfList) {
		
			return databaseModelToUiDto(epf);
		}
		return null;
	}

	
	
	@Override
	public Epf uiDtoToDatabaseModel(EpfDTO epfDto) {
		Epf epf=new Epf();
		epf.setEpfId(epfDto.getEpfId());
		epf.setEmployeePer(epfDto.getEmployeePer());
		epf.setEmployerPer(epfDto.getEmployerPer());
		epf.setEmployerPensionPer(epfDto.getEmployerPensionPer());
		epf.setAdminPer(epfDto.getAdminPer());
		epf.setEdliPer(epfDto.getEdliPer());
		epf.setEdliExpPer(epfDto.getEdliExpPer());
		epf.setMaxBasicLimit(epfDto.getMaxBasicLimit());
		epf.setMaxPensionLimit(epfDto.getMaxPensionLimit());
		epf.setIsActual(epfDto.getIsActual());
        epf.setEffectiveDate(epfDto.getEffectiveDate());
		epf.setActiveStatus(epfDto.getActiveStatus());
		epf.setUserId(epfDto.getUserId());
		Company company=new Company();
		company.setCompanyId(epfDto.getCompanyId());
		epf.setCompany(company);
		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		epf.setGroupg(groupg);
		if(epfDto.getDateCreated()==null)
			epf.setDateCreated(new Date());
		else
			epf.setDateCreated(epfDto.getDateCreated());
		epf.setDateUpdate(new Date());
		epf.setUserIdUpdate(epfDto.getUserIdUpdate());
		return epf;
	}

	@Override
	public EpfDTO databaseModelToUiDto(Epf epf) {
		EpfDTO epfDto=new EpfDTO();
		epfDto.setEpfId(epf.getEpfId());
		epfDto.setEmployeePer(epf.getEmployeePer());
		epfDto.setEmployerPer(epf.getEmployerPer());
		epfDto.setEmployerPensionPer(epf.getEmployerPensionPer());
		epfDto.setAdminPer(epf.getAdminPer());
		epfDto.setEdliPer(epf.getEdliPer());
		epfDto.setEdliExpPer(epf.getEdliExpPer());
		epfDto.setMaxBasicLimit(epf.getMaxBasicLimit());
		epfDto.setMaxPensionLimit(epf.getMaxPensionLimit());
		epfDto.setIsActual(epf.getIsActual());
		epfDto.setEffectiveDate(epf.getEffectiveDate());
		epfDto.setActiveStatus(epf.getActiveStatus());
		epfDto.setUserId(epf.getUserId());
		epfDto.setDateCreated(epf.getDateCreated());
		return epfDto;
	}

}
