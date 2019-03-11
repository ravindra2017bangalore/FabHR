package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.BindingResultUtils;

import com.csipl.hrms.common.enums.EmployeeStatusEnum;
import com.csipl.hrms.dto.payroll.BonusDTO;
import com.csipl.hrms.dto.payroll.FinancialYearDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Grade;
import com.csipl.hrms.model.payroll.Bonus;
import com.csipl.hrms.model.payrollprocess.FinancialYear;

public class BonusAdaptor implements Adaptor<BonusDTO, Bonus> {

	GradeAdaptor gradeAdapter = new GradeAdaptor();

	@Override
	public List<Bonus> uiDtoToDatabaseModelList(List<BonusDTO> bonusDtoList) {
		List<Bonus> bonus = new ArrayList<Bonus>();
		for (BonusDTO bonusDto : bonusDtoList) {

			bonus.add(uiDtoToDatabaseModel(bonusDto));
		}
		return bonus;
	}

	@Override
	public List<BonusDTO> databaseModelToUiDtoList(List<Bonus> bonusList) {
		List<BonusDTO> bonusDtoList = new ArrayList<BonusDTO>();
		for (Bonus bonus : bonusList) {

			bonusDtoList.add(databaseModelToUiDto(bonus));
		}
		return bonusDtoList;
	}

	@Override
	public Bonus uiDtoToDatabaseModel(BonusDTO bonusDto) {

		Bonus bonus = new Bonus();
		Company company = new Company();
		Groupg groupg = new Groupg();
		company.setCompanyId(bonusDto.getCompanyId());
		bonus.setCompany(company);
		if (bonusDto.getBonusId() != null) {
			bonus.setUserId(bonusDto.getUserId());
			bonus.setDateCreated(bonusDto.getDateCreated());
		} else {
			bonus.setDateCreated(new Date());
		}
		bonus.setUserIdUpdate(bonusDto.getUserIdUpdate());
		bonus.setDateUpdate(new Date());
		if (bonusDto != null) {
			bonus.setBonusId(bonusDto.getBonusId());
			bonus.setBonusPer(bonusDto.getBonusPer());
			bonus.setFinancialYear(bonusDto.getEffectiveDate());
			bonus.setActiveStatus(EmployeeStatusEnum.ActiveStatus.getEmployeeStatus());
			groupg.setGroupId(1l);
			bonus.setGroupg(groupg);
		}
		return bonus;
	}

	@Override
	public BonusDTO databaseModelToUiDto(Bonus bonus) {
		BonusDTO bonusDto = new BonusDTO();
		bonusDto.setBonusId(bonus.getBonusId());
		bonusDto.setBonusPer(bonus.getBonusPer());
		bonusDto.setEffectiveDate(bonus.getFinancialYear());
		bonusDto.setGradesId(bonus.getGrade().getGradesId());
		bonusDto.setGradesName(bonus.getGrade().getGradesName());
		bonusDto.setDateCreated(bonus.getDateCreated());
		bonusDto.setUserId(bonus.getUserId());
		bonusDto.setActiveStatus(bonus.getActiveStatus());
		return bonusDto;
	}

	public List<FinancialYearDTO> financialYearToFinancialYearDtoList(List<FinancialYear> financialYearList) {
		List<FinancialYearDTO> financialYearDtoList = new ArrayList<FinancialYearDTO>();
		for (FinancialYear financialYear : financialYearList) {
			financialYearDtoList.add(financialYearToFinancialYearDto(financialYear));
		}
		return financialYearDtoList;
	}

	private FinancialYearDTO financialYearToFinancialYearDto(FinancialYear financialYear) {
		FinancialYearDTO financialYearDto = new FinancialYearDTO();
		financialYearDto.setFinancialYear(financialYear.getFinancialYear());
		financialYearDto.setFinancialYearId(financialYear.getFinancialYearId());
		return financialYearDto;
	}

}
