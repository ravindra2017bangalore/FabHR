package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.payroll.InvestmentDTO;
import com.csipl.hrms.dto.payroll.TdsGroupDTO;
import com.csipl.hrms.dto.payroll.TdsSectionDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsSection;

public class InvestmentAdaptor implements Adaptor<TdsGroupDTO, TdsGroup> {

	@Override
	public List<TdsGroup> uiDtoToDatabaseModelList(List<TdsGroupDTO> tdsGroupDtoList) {
		List<TdsGroup> tdsGroupList = new ArrayList<TdsGroup>();
		for (TdsGroupDTO tdsGroupDto : tdsGroupDtoList) {
			tdsGroupList.add(uiDtoToDatabaseModel(tdsGroupDto));
		}
		return tdsGroupList;
	}

	@Override
	public List<TdsGroupDTO> databaseModelToUiDtoList(List<TdsGroup> tdsGroupList) {
		List<TdsGroupDTO> tdsGroupDtoList = new ArrayList<TdsGroupDTO>();
		for (TdsGroup tdsGroup : tdsGroupList) {
			tdsGroupDtoList.add(databaseModelToUiDto(tdsGroup));
		}
		return tdsGroupDtoList;
	}

	@Override
	public TdsGroup uiDtoToDatabaseModel(TdsGroupDTO tdsGroupDto) {
		TdsGroup tdsGroup = new TdsGroup();
		Company company = new Company();
		Groupg group = new Groupg();
		DateUtils dateUtils = new DateUtils();

		company.setCompanyId(tdsGroupDto.getCompanyId());
		tdsGroup.setCompany(company);
		group.setGroupId(1L);
		tdsGroup.setGroupg(group);
		tdsGroup.setTdsGroupId(tdsGroupDto.getTdsGroupId());
		tdsGroup.setTdsGroupName(tdsGroupDto.getTdsGroupName());
		tdsGroup.setTdsDescription(tdsGroupDto.getTdsDescription());
		tdsGroup.setMaxLimit(tdsGroupDto.getMaxLimit());
		tdsGroup.setAgeForExtra(tdsGroupDto.getAgeForExtra());
		tdsGroup.setAddLimitOnAge(tdsGroupDto.getAddLimitOnAge());
		tdsGroup.setFinancialYear(tdsGroupDto.getFinancialYear());
		tdsGroup.setIsSubGroupReq(tdsGroupDto.getIsSubGroupReq());
		tdsGroup.setIsSubGroupLimit(tdsGroupDto.getIsSubGroupLimit());

		tdsGroup.setEffectiveStartDate(dateUtils.getDateWirhYYYYMMDD(tdsGroupDto.getEffectiveStartDate()));

		// tdsGroup.setEffectiveStartDate(tdsGroupDto.getEffectiveStartDate());
		tdsGroup.setEffectiveEndDate(tdsGroupDto.getEffectiveEndDate());
		tdsGroup.setUserId(tdsGroupDto.getUserId());
		if (tdsGroupDto.getTdsGroupId() == null)
			tdsGroup.setDateCreated(new Date());
		else
			tdsGroup.setDateCreated(tdsGroupDto.getDateCreated());
		tdsGroup.setUserIdUpdate(tdsGroupDto.getUserIdUpdate());
		tdsGroup.setDateUpdate(new Date());
		tdsGroup.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		tdsGroup.setTdsSections(uiDtoToDatabaseModelListSection(tdsGroupDto.getTdsSections(), tdsGroup));

		return tdsGroup;
	}

	@Override
	public TdsGroupDTO databaseModelToUiDto(TdsGroup tdsGroup) {
		DateUtils dateUtils = new DateUtils();
		TdsGroupDTO tdsGroupDto = new TdsGroupDTO();
		tdsGroupDto.setTdsGroupId(tdsGroup.getTdsGroupId());
		tdsGroupDto.setTdsGroupName(tdsGroup.getTdsGroupName());
		tdsGroupDto.setTdsDescription(tdsGroup.getTdsDescription());
		tdsGroupDto.setFinancialYear(tdsGroup.getFinancialYear());
		tdsGroupDto.setMaxLimit(tdsGroup.getMaxLimit());
		tdsGroupDto.setAgeForExtra(tdsGroup.getAgeForExtra());
		tdsGroupDto.setAddLimitOnAge(tdsGroup.getAddLimitOnAge());
		tdsGroupDto.setIsSubGroupReq(tdsGroup.getIsSubGroupReq());
		tdsGroupDto.setIsSubGroupLimit(tdsGroup.getIsSubGroupLimit());
		tdsGroupDto.setEffectiveStartDate(dateUtils.getDateStringWirhYYYYMMDD(tdsGroup.getEffectiveStartDate()));
		tdsGroupDto.setEffectiveEndDate(tdsGroup.getEffectiveEndDate());
		tdsGroupDto.setUserId(tdsGroup.getUserId());
		tdsGroupDto.setDateCreated(tdsGroup.getDateCreated());
		tdsGroupDto.setActiveStatus(tdsGroup.getActiveStatus());
		tdsGroupDto.setTdsSections(databaseModelToUiDtoListSection(tdsGroup.getTdsSections()));
		return tdsGroupDto;
	}

	private TdsSection uiDtoToDatabaseSectionModel(TdsSectionDTO tdsSectionDto, TdsGroup tdsGroup) {
		TdsSection tdsSection = new TdsSection();
		tdsSection.setTdsSectionId(tdsSectionDto.getTdsSectionId());
		tdsSection.setTdsSectionName(tdsSectionDto.getTdsSectionName());
		tdsSection.setTdsDescription(tdsSectionDto.getTdsDescription());
		tdsSection.setMaxLimit(tdsSectionDto.getMaxLimit());
		tdsSection.setAgeForExtra(tdsSectionDto.getAgeForExtra());
		tdsSection.setAddLimitOnAge(tdsSectionDto.getAddLimitOnAge());
		tdsSection.setIsParrentRecord(tdsSectionDto.getIsParrentRecord());
		tdsSection.setUserId(tdsSectionDto.getUserId());
		if (tdsSectionDto.getDateCreated() == null)
			tdsSection.setDateCreated(new Date());
		else
			tdsSection.setDateCreated(tdsSectionDto.getDateCreated());
		tdsSection.setUserIdUpdate(tdsSectionDto.getUserIdUpdate());
		tdsSection.setDateUpdate(new Date());
		tdsSection.setTdsGroup(tdsGroup);
		return tdsSection;
	}

	/*
	 * public TdsSection uiDtoToDatabaseModelSectionModel(TdsGroupDTO tdsGroupDto) {
	 * TdsSection tdsSection = new TdsSection();
	 * tdsSection.setTdsSectionName(tdsGroupDto.getTdsGroupName());
	 * tdsSection.setTdsDescription(tdsGroupDto.getTdsDescription());
	 * tdsSection.setMaxLimit(tdsGroupDto.getMaxLimit());
	 * tdsSection.setAgeForExtra(tdsGroupDto.getAgeForExtra());
	 * tdsSection.setAddLimitOnAge(tdsGroupDto.getAddLimitOnAge()); return
	 * tdsSection; }
	 */

	private List<TdsSection> uiDtoToDatabaseModelListSection(List<TdsSectionDTO> tdsSectionDtoList, TdsGroup tdsGroup) {
		List<TdsSection> tdsSectionList = new ArrayList<TdsSection>();
		/*
		 * TdsSection tdsSection=new TdsSection();
		 * 
		 * tdsSection.setTdsSectionName(tdsGroup.getTdsGroupName());
		 * tdsSection.setTdsDescription(tdsGroup.getTdsDescription());
		 * tdsSection.setMaxLimit(tdsGroup.getMaxLimit());
		 * tdsSection.setAgeForExtra(tdsGroup.getAgeForExtra());
		 * tdsSection.setAddLimitOnAge(tdsGroup.getAddLimitOnAge());
		 * tdsSection.setIsParrentRecord("Y");
		 */

		for (TdsSectionDTO tdsSectionDto : tdsSectionDtoList) {
			tdsSectionList.add(uiDtoToDatabaseSectionModel(tdsSectionDto, tdsGroup));
		}
		return tdsSectionList;
	}

	private List<TdsSectionDTO> databaseModelToUiDtoListSection(List<TdsSection> tdsSectionList) {
		List<TdsSectionDTO> tdsSectionDtoList = new ArrayList<TdsSectionDTO>();
		for (TdsSection tdsSection : tdsSectionList) {
			tdsSectionDtoList.add(databaseModelToUiDtoSection(tdsSection));
		}
		return tdsSectionDtoList;
	}

	private TdsSectionDTO databaseModelToUiDtoSection(TdsSection tdsSection) {
		TdsSectionDTO tdsSectionDto = new TdsSectionDTO();
		tdsSectionDto.setTdsSectionId(tdsSection.getTdsSectionId());
		tdsSectionDto.setTdsSectionName(tdsSection.getTdsSectionName());
		tdsSectionDto.setTdsDescription(tdsSection.getTdsDescription());
		tdsSectionDto.setMaxLimit(tdsSection.getMaxLimit());
		tdsSectionDto.setAgeForExtra(tdsSection.getAgeForExtra());
		tdsSectionDto.setAddLimitOnAge(tdsSection.getAddLimitOnAge());
		tdsSectionDto.setIsParrentRecord(tdsSection.getIsParrentRecord());
		tdsSectionDto.setUserId(tdsSection.getUserId());
		tdsSectionDto.setDateCreated(tdsSection.getDateCreated());
		return tdsSectionDto;
	}

	public List<InvestmentDTO> databseModelToInvestmentDtoList(List<TdsGroup> tdsGroupList) {
		List<InvestmentDTO> investmentDtoList = new ArrayList<InvestmentDTO>();
		for (TdsGroup tdsGroup : tdsGroupList) {
			databaseModelToInvestmentDto(tdsGroup, investmentDtoList);
		}
		return investmentDtoList;
	}

	private InvestmentDTO databaseModelToInvestmentDto(TdsGroup tdsGroup, List<InvestmentDTO> investmentDtoList) {
		InvestmentDTO investmentDto = new InvestmentDTO();
		DateUtils dateUtils = new DateUtils();

		investmentDto.setTdsGroupId(tdsGroup.getTdsGroupId());
		investmentDto.setTdsGroupName(tdsGroup.getTdsGroupName());
		investmentDto.setMaxLimit(tdsGroup.getMaxLimit());
		investmentDto.setTdsDescription(tdsGroup.getTdsDescription());
		investmentDto.setAgeForExtra(tdsGroup.getAgeForExtra());
		investmentDto.setAddLimitOnAge(tdsGroup.getAddLimitOnAge());
		investmentDto.setFinancialYear(tdsGroup.getFinancialYear());
		/*
		 * investmentDto.setEffectiveStartDate(tdsGroup.getEffectiveStartDate());
		 * investmentDto.setEffectiveEndDate(tdsGroup.getEffectiveEndDate());
		 */
		String effectiveStartDate = dateUtils.getDateStringWirhYYYYMMDD(tdsGroup.getEffectiveStartDate());
		investmentDto.setEffectiveStartDate(effectiveStartDate);

		/*
		 * String effectiveEndDate=dateUtils.getDateStringWirhYYYYMMDD(tdsGroup.
		 * getEffectiveEndDate()); investmentDto.setEffectiveEndDate(effectiveEndDate);
		 */

		investmentDtoList.add(investmentDto);
		if (tdsGroup.getTdsSections() != null) {
			for (TdsSection tdsSection : tdsGroup.getTdsSections()) {
				InvestmentDTO investmentDtoObj = new InvestmentDTO();
				investmentDtoObj.setTdsGroupId(tdsGroup.getTdsGroupId());
				investmentDtoObj.setFinancialYear(tdsGroup.getFinancialYear());
				investmentDtoObj.setTdsGroupName(tdsGroup.getTdsGroupName());
				investmentDtoObj.setMaxLimit(tdsSection.getMaxLimit());
				investmentDtoObj.setTdsDescription(tdsSection.getTdsDescription());
				investmentDtoObj.setAgeForExtra(tdsSection.getAgeForExtra());
				investmentDtoObj.setAddLimitOnAge(tdsSection.getAddLimitOnAge());
				investmentDtoObj.setTdsSectionId(tdsSection.getTdsSectionId());
				investmentDtoObj.setTdsSectionName(tdsSection.getTdsSectionName());
				investmentDtoList.add(investmentDtoObj);
			}
		}
		return investmentDto;
	}
}
