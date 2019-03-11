package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.common.enums.EmployeeStatusEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.organisation.GradesPayDefinitionDTO;
import com.csipl.hrms.dto.payroll.ProfessionalTaxDTO;
import com.csipl.hrms.dto.payroll.ProfessionalTaxInfoDTO;
import com.csipl.hrms.dto.payroll.TdsSectionDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.common.State;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.organisation.GradesPayDefinition;
import com.csipl.hrms.model.payroll.PayHead;
import com.csipl.hrms.model.payroll.ProfessionalTax;
import com.csipl.hrms.model.payroll.ProfessionalTaxInfo;
import com.csipl.hrms.model.payroll.TdsSection;







public class ProfessionalTaxAdaptor implements Adaptor<ProfessionalTaxDTO, ProfessionalTax> {
	DateUtils dateUtils = new DateUtils();
	@Override
	public List<ProfessionalTax> uiDtoToDatabaseModelList(List<ProfessionalTaxDTO> professionalTaxDtoList) {
		List<ProfessionalTax> professionalTaxList = new ArrayList<ProfessionalTax>();
		for (ProfessionalTaxDTO professionalTaxDto : professionalTaxDtoList) {
			professionalTaxList.add(uiDtoToDatabaseModel(professionalTaxDto));
		}
		return professionalTaxList;
	}

	@Override
	public List<ProfessionalTaxDTO> databaseModelToUiDtoList(List<ProfessionalTax> professionalTaxList) {

		List<ProfessionalTaxDTO> professionalTaxDtoList = new ArrayList<ProfessionalTaxDTO>();
		for (ProfessionalTax professionalTax : professionalTaxList) {
			professionalTaxDtoList.add(databaseModelToUiDto(professionalTax));
		}
		return professionalTaxDtoList;
	}

	@Override
	public ProfessionalTax uiDtoToDatabaseModel(ProfessionalTaxDTO professionalTaxDto) {
		ProfessionalTax professionalTax = new ProfessionalTax();
		State state = new State();
		professionalTax.setProfessionalHeadId(professionalTaxDto.getProfessionalHeadId());
		state.setStateId(professionalTaxDto.getStateId());
		state.setStateName(professionalTaxDto.getStateName());
		professionalTax.setState(state);
		Company company = new Company();
		
		System.out.println(professionalTaxDto.getEffectiveStartDate());
		if(professionalTaxDto.getEffectiveStartDate()!=null && !("").equals( professionalTaxDto.getEffectiveStartDate()))
			professionalTax.setEffectiveStartDate(dateUtils.getDateWirhYYYYMMDD(professionalTaxDto.getEffectiveStartDate()));
		
		professionalTax.setEffectiveEndDate(professionalTaxDto.getEffectiveEndDate());
		professionalTax.setUserId(professionalTaxDto.getUserId());
		if(professionalTaxDto.getDateCreated()==null)
		{
			professionalTax.setDateCreated(new Date());
		}
		else
		{
			professionalTax.setDateCreated(professionalTaxDto.getDateCreated());
		}
		professionalTax.setActiveStatus(EmployeeStatusEnum.ActiveStatus.getEmployeeStatus());
		professionalTax.setUserIdUpdate(professionalTaxDto.getUserIdUpdate());
		company.setCompanyId(professionalTaxDto.getCompanyId());
		professionalTax.setCompany(company);
	
		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		professionalTax.setGroupg(groupg);
		professionalTax.setProfessionalTaxInfos(uiDtoToProffessionalTaxInfoList(professionalTaxDto.getProfessionalTaxInfos(),professionalTax));
				//uiDtoToDatabaseModelGradesPayDefinitionList(gradeDto.getGradesPayDefinitions(), grade));
		return professionalTax;
	}

	@Override
	public ProfessionalTaxDTO databaseModelToUiDto(ProfessionalTax professionalTax) {

		ProfessionalTaxDTO professionalTaxDto = new ProfessionalTaxDTO();
		professionalTaxDto.setProfessionalHeadId(professionalTax.getProfessionalHeadId());
		professionalTaxDto.setStateId(professionalTax.getState().getStateId());
		
		professionalTaxDto.setStateName(professionalTax.getState().getStateName());
		if(professionalTax.getEffectiveStartDate()!=null) {
		
			professionalTaxDto.setEffectiveStartDate( dateUtils.getDateStringWirhYYYYMMDD(professionalTax.getEffectiveStartDate() ) );
			}
		
		professionalTaxDto.setEffectiveEndDate(professionalTax.getEffectiveEndDate());
		professionalTaxDto.setUserId(professionalTax.getUserId());
		professionalTaxDto.setDateCreated(professionalTax.getDateCreated());
		professionalTaxDto.setActiveStatus(professionalTax.getActiveStatus());
		professionalTaxDto.setProfessionalTaxInfos(proTaxInfoModelToUiDtoList(professionalTax.getProfessionalTaxInfos()));
		return professionalTaxDto;
	}
	private List<ProfessionalTaxInfoDTO> proTaxInfoModelToUiDtoList(List<ProfessionalTaxInfo> professionalTaxInfoList) {
		List<ProfessionalTaxInfoDTO> professionalTaxinfoDtoList = new ArrayList<ProfessionalTaxInfoDTO>();
		for (ProfessionalTaxInfo professionalTaxInfo : professionalTaxInfoList) {
			professionalTaxinfoDtoList.add(proTaxInfoModelToUiDto(professionalTaxInfo));
		}
		return professionalTaxinfoDtoList;
	}
	private ProfessionalTaxInfoDTO proTaxInfoModelToUiDto(ProfessionalTaxInfo professionalTaxInfo) {
		ProfessionalTaxInfoDTO professionalTaxInfoDTO = new ProfessionalTaxInfoDTO();
		professionalTaxInfoDTO.setCategory(professionalTaxInfo.getCategory());
		professionalTaxInfoDTO.setLimitFrom(professionalTaxInfo.getLimitFrom());
		professionalTaxInfoDTO.setLimitTo(professionalTaxInfo.getLimitTo());
		professionalTaxInfoDTO.setProfessionalTaxInfoId(professionalTaxInfo.getProfessionalTaxInfoId());
		professionalTaxInfoDTO.setTaxAmount(professionalTaxInfo.getTaxAmount());
		professionalTaxInfoDTO.setDateCreated(professionalTaxInfo.getDateCreated());
		
		professionalTaxInfoDTO.setUserId(professionalTaxInfo.getUserId());
		
		return professionalTaxInfoDTO;
	}
	public List<ProfessionalTaxInfo> uiDtoToProffessionalTaxInfoList(List<ProfessionalTaxInfoDTO> professionalTaxInfoListDtolist,ProfessionalTax professionalTax) {
		 List<ProfessionalTaxInfo> professionalTaxInfoList=new ArrayList<ProfessionalTaxInfo>();
		 System.out.println(professionalTaxInfoListDtolist);
         for (ProfessionalTaxInfoDTO professionalTaxInfoDto : professionalTaxInfoListDtolist) {
        	 professionalTaxInfoList.add(uiDtoToDatabaseproTaxInfoModel(professionalTaxInfoDto,professionalTax));
		}
		
		return professionalTaxInfoList;
	}
	
	private ProfessionalTaxInfo uiDtoToDatabaseproTaxInfoModel(ProfessionalTaxInfoDTO professionalTaxInfoDto,ProfessionalTax professionalTax) {
		System.out.println(professionalTaxInfoDto);
		ProfessionalTaxInfo professionalTaxInfo =new ProfessionalTaxInfo();
		professionalTaxInfo.setProfessionalTaxInfoId(professionalTaxInfoDto.getProfessionalTaxInfoId());
		professionalTaxInfo.setCategory(professionalTaxInfoDto.getCategory());
		professionalTaxInfo.setLimitFrom(professionalTaxInfoDto.getLimitFrom());
		professionalTaxInfo.setLimitTo(professionalTaxInfoDto.getLimitTo());
		professionalTaxInfo.setTaxAmount(professionalTaxInfoDto.getTaxAmount());
		professionalTaxInfo.setUserId(professionalTaxInfoDto.getUserId());
		if(professionalTaxInfoDto.getDateCreated()==null)
		{
			professionalTaxInfo.setDateCreated(new Date());
		}
		else
		{
			professionalTaxInfo.setDateCreated(professionalTaxInfoDto.getDateCreated());
		}
		professionalTaxInfo.setUserIdUpdate(professionalTaxInfoDto.getUserIdUpdate());
		
		
	   professionalTaxInfo.setProfessionalTax(professionalTax);
	
		return professionalTaxInfo;
	}

}
