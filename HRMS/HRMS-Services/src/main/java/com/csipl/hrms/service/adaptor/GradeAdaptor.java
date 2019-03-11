package com.csipl.hrms.service.adaptor;

//package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.GradeDTO;
import com.csipl.hrms.dto.organisation.GradesPayDefinitionDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.organisation.GradesPayDefinition;
import com.csipl.hrms.model.payroll.PayHead;

public class GradeAdaptor implements Adaptor<GradeDTO, Grade> {

	GradesPayDefinitionAdaptor gradesPayDefinitionAdaptor = new GradesPayDefinitionAdaptor();

	@Override
	public Grade uiDtoToDatabaseModel(GradeDTO gradeDto) {
		Grade grade = new Grade();
		Groupg groupg = new Groupg();
		Company company = new Company();
		company.setCompanyId(gradeDto.getCompanyId());
		grade.setCompany(company);
		grade.setGradesName(gradeDto.getGradesName());
		grade.setSalaryFrom(gradeDto.getSalaryFrom());
		grade.setSalaryTo(gradeDto.getSalaryTo());
		grade.setIncrementPer(gradeDto.getIncrementPer());
		grade.setGradesId(gradeDto.getGradesId());

		grade.setUserId(gradeDto.getUserId());
		grade.setDateCreated(gradeDto.getDateCreated());

		if (grade.getGradesId() == null)
			grade.setDateCreated(new Date());
		else
			grade.setDateCreated(gradeDto.getDateCreated());

		grade.setDateUpdate(new Date());
		grade.setUserIdUpdate(gradeDto.getUserIdUpdate());
		groupg.setGroupId(1l);
		grade.setGroupg(groupg);
		grade.setGradesPayDefinitions(
				uiDtoToDatabaseModelGradesPayDefinitionList(gradeDto.getGradesPayDefinitions(), grade));
		return grade;
	}

	private List<GradesPayDefinition> uiDtoToDatabaseModelGradesPayDefinitionList(
			List<GradesPayDefinitionDTO> gradesPayDefinitionDtoList, Grade grade) {
		List<GradesPayDefinition> gradesPayDefList = new ArrayList<GradesPayDefinition>();
		for (GradesPayDefinitionDTO gradesPayDefinitionDTO : gradesPayDefinitionDtoList) {
			gradesPayDefList.add(uiDtoToDatabaseGradePayDefModel(gradesPayDefinitionDTO, grade));
		}
		return gradesPayDefList;
	}

	private GradesPayDefinition uiDtoToDatabaseGradePayDefModel(GradesPayDefinitionDTO gradesPayDefinitionDto,
			Grade grade) {
		GradesPayDefinition gradesPayDefinition = new GradesPayDefinition();
		gradesPayDefinition.setUserId(grade.getUserId());
		System.out.println("gradesPayDefinition.getUserId()======="+grade.getUserId());
		gradesPayDefinition.setDateCreated(gradesPayDefinitionDto.getDateCreated());
		gradesPayDefinition.setGradesPayId(gradesPayDefinitionDto.getGradesPayId());
		
		if (gradesPayDefinition.getGradesPayId() == null)
			gradesPayDefinition.setDateCreated(new Date());
		else
			gradesPayDefinition.setDateCreated(grade.getDateCreated());

		gradesPayDefinition.setDateUpdate(new Date());
		gradesPayDefinition.setUserIdUpdate(grade.getUserIdUpdate());
		
		PayHead payHead = new PayHead();
		payHead.setPayHeadId(gradesPayDefinitionDto.getPayHeadId());
		payHead.setPayHeadName(gradesPayDefinitionDto.getPayHeadName());
		gradesPayDefinition.setPayHead(payHead);
		gradesPayDefinition.setPercenatage(gradesPayDefinitionDto.getPercenatage());
		gradesPayDefinition.setGrade(grade);

		return gradesPayDefinition;
	}

	@Override
	public List<GradeDTO> databaseModelToUiDtoList(List<Grade> gradeList) {
		List<GradeDTO> gradeDtoList = new ArrayList<GradeDTO>();
		for (Grade garde : gradeList) {
			gradeDtoList.add(databaseModelToUiDto(garde));
		}
		return gradeDtoList;
	}

	@Override
	public GradeDTO databaseModelToUiDto(Grade grade) {

		GradeDTO gradeDTO = new GradeDTO();
		List<GradesPayDefinitionDTO> gradesPayDefinitionDtoList = new ArrayList<GradesPayDefinitionDTO>();
		gradeDTO.setGradesName(grade.getGradesName());
		gradeDTO.setSalaryFrom(grade.getSalaryFrom());
		gradeDTO.setSalaryTo(grade.getSalaryTo());
		gradeDTO.setIncrementPer(grade.getIncrementPer());
		gradeDTO.setGradesId(grade.getGradesId());
		gradeDTO.setUserId(grade.getUserId());
		gradeDTO.setDateCreated(grade.getDateCreated());
		if (grade.getGradesPayDefinitions() != null)
			gradeDTO.setGradesPayDefinitions(
					gradesPayDefinitionAdaptor.databaseModelToUiDtoList(grade.getGradesPayDefinitions()));
		return gradeDTO;
	}

	@Override
	public List<Grade> uiDtoToDatabaseModelList(List<GradeDTO> gradeDtoList) {
		return null;
	}
}
