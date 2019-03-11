package com.csipl.hrms.service.adaptor;

 import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.organisation.GradesPayDefinitionDTO;
import com.csipl.hrms.model.organisation.GradesPayDefinition;
import com.csipl.hrms.model.payroll.PayHead;

public class GradesPayDefinitionAdaptor implements Adaptor<GradesPayDefinitionDTO, GradesPayDefinition>{

	@Override
	public List<GradesPayDefinition> uiDtoToDatabaseModelList(List<GradesPayDefinitionDTO> gradesPayDefinitionDtoList) {
 		return null;
	}
 	@Override
	public List<GradesPayDefinitionDTO> databaseModelToUiDtoList(List<GradesPayDefinition> gradesPayDefinitionList) {
		List<GradesPayDefinitionDTO>  gradesPayDefinitionDtoList=new ArrayList<GradesPayDefinitionDTO>();
		for (GradesPayDefinition gradesPayDefinition : gradesPayDefinitionList) {
			gradesPayDefinitionDtoList.add(databaseModelToUiDto(gradesPayDefinition));
		}
		return gradesPayDefinitionDtoList;
	}

	@Override
	public GradesPayDefinition uiDtoToDatabaseModel(GradesPayDefinitionDTO uiobj) {
 		return null;
	}
 	@Override
	public GradesPayDefinitionDTO databaseModelToUiDto(GradesPayDefinition gradesPayDefinition) {
		GradesPayDefinitionDTO gradesPayDefinitionDto=new GradesPayDefinitionDTO();
 		/*PayHead payHead=new PayHead();
 		payHead.setPayHeadId(payHeadId);*/
		gradesPayDefinitionDto.setUserId(gradesPayDefinition.getUserId());
		gradesPayDefinitionDto.setDateCreated(gradesPayDefinition.getDateCreated());
		gradesPayDefinitionDto.setGradesPayId(gradesPayDefinition.getGradesPayId());
		gradesPayDefinitionDto.setPayHeadId(gradesPayDefinition.getPayHead().getPayHeadId());
		gradesPayDefinitionDto.setPayHeadName(gradesPayDefinition.getPayHead().getPayHeadName());
		gradesPayDefinitionDto.setPercenatage(gradesPayDefinition.getPercenatage());
		gradesPayDefinitionDto.setGradesId(gradesPayDefinition.getGrade().getGradesId());
		System.out.println(gradesPayDefinitionDto.getGradesId());
		return gradesPayDefinitionDto;
	}

}
