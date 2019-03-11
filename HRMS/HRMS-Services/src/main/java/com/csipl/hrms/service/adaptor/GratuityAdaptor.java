package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.payroll.GratuityDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.Gratuaty;

public class GratuityAdaptor  implements Adaptor<GratuityDTO, Gratuaty>{
	@Override
	public Gratuaty uiDtoToDatabaseModel(GratuityDTO gratuityDto) {
		
		Company company=new Company();
		Gratuaty gratuity=new Gratuaty();
		Groupg group=new Groupg();
		company.setCompanyId(gratuityDto.getCompanyId());
		gratuity.setCompany(company);
		gratuity.setGraduityId(gratuityDto.getGratuityId());
		gratuity.setEffectiveDate(gratuityDto.getEffectiveDate());
		gratuity.setNoOfDays(gratuityDto.getNoOfDays());
		gratuity.setNoOfDaysDevide(gratuityDto.getNoOfDaysDevide());
		gratuity.setNoOfMonths(gratuityDto.getNoOfMonths());
		gratuity.setActiveStatus(gratuityDto.getActiveStatus());
		gratuity.setUserId(gratuityDto.getUserId());
		gratuity.setUserIdUpdate(gratuityDto.getUserIdUpdate());
		gratuity.setDateUpdate(new Date());
		group.setGroupId(1L);
		gratuity.setGroupg(group);
		if(gratuityDto.getGratuityId()==null) 
			gratuity.setDateCreated(new Date());
		else
			gratuity.setDateCreated(gratuityDto.getDateCreated());
		return gratuity;
	}
	
	@Override
	public List<GratuityDTO> databaseModelToUiDtoList(List<Gratuaty> gratuityList) {
		List<GratuityDTO> gratuityDtoList=new ArrayList<GratuityDTO>();
		for(Gratuaty gratuity:gratuityList) {
		
			gratuityDtoList.add(databaseModelToUiDto(gratuity));
		}
		return gratuityDtoList;
	}
	@Override
	public GratuityDTO databaseModelToUiDto(Gratuaty gratuity) {
		GratuityDTO gratuityDto=new GratuityDTO();
		gratuityDto.setGratuityId(gratuity.getGraduityId());
		gratuityDto.setEffectiveDate(gratuity.getEffectiveDate());
		gratuityDto.setNoOfDays(gratuity.getNoOfDays());
		gratuityDto.setNoOfDaysDevide(gratuity.getNoOfDaysDevide());
		gratuityDto.setNoOfMonths(gratuity.getNoOfMonths());
		gratuityDto.setActiveStatus(gratuity.getActiveStatus());
		gratuityDto.setUserId(gratuity.getUserId());
		gratuityDto.setDateCreated(gratuity.getDateCreated());
		return gratuityDto;
	}

	@Override
	public List<Gratuaty> uiDtoToDatabaseModelList(List<GratuityDTO> gratuityDtoList) {
		List<Gratuaty> gratuity=new ArrayList<Gratuaty>();
		for(GratuityDTO gratuityDto:gratuityDtoList) {
		
			gratuity.add(uiDtoToDatabaseModel(gratuityDto));
		}
		return gratuity;
	}

}
