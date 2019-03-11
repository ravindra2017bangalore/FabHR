package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.payroll.OvertimeDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.Overtime;

public class OvertimeAdaptor implements Adaptor<OvertimeDTO, Overtime> {

	@Override
	public List<Overtime> uiDtoToDatabaseModelList(List<OvertimeDTO> overtimeDtoList) {
		List<Overtime> overtime = new ArrayList<Overtime>();
		for (OvertimeDTO overtimeDto : overtimeDtoList) {

			overtime.add(uiDtoToDatabaseModel(overtimeDto));
		}
		return overtime;
	}

	@Override
	public List<OvertimeDTO> databaseModelToUiDtoList(List<Overtime> overtimeList) {
		List<OvertimeDTO> overtimeDtoList = new ArrayList<OvertimeDTO>();
		for (Overtime overtime : overtimeList) {

			overtimeDtoList.add(databaseModelToUiDto(overtime));
		}
		return overtimeDtoList;
	}

	@Override
	public Overtime uiDtoToDatabaseModel(OvertimeDTO overtimeDto) {

		Company company = new Company();
		Groupg groupg = new Groupg();
		Overtime overtime = new Overtime();
		company.setCompanyId(overtimeDto.getCompanyId());
		overtime.setCompany(company);
		groupg.setGroupId(1L);
		overtime.setGroupg(groupg);
		if (overtimeDto.getOvertimeId() != null) {
			overtime.setOvertimeId(overtimeDto.getOvertimeId());
			overtime.setDateCreated(overtimeDto.getDateCreated());
		} else {
			overtime.setDateCreated(new Date());
		}
		overtime.setDateUpdate(new Date());
		overtime.setUserId(overtimeDto.getUserId());
		overtime.setUserIdUpdate(overtimeDto.getUserIdUpdate());
		overtime.setNoOfDays(overtimeDto.getNoOfDays());
		overtime.setFixAmount(overtimeDto.getFixAmount());
		overtime.setRatio(overtimeDto.getRatio());
		overtime.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		return overtime;
	}

	@Override
	public OvertimeDTO databaseModelToUiDto(Overtime overtime) {
		OvertimeDTO overtimeDto = new OvertimeDTO();
		overtimeDto.setOvertimeId(overtime.getOvertimeId());
		overtimeDto.setFixAmount(overtime.getFixAmount());
		overtimeDto.setNoOfDays(overtime.getNoOfDays());
		overtimeDto.setRatio(overtime.getRatio());
		overtimeDto.setActiveStatus(overtime.getActiveStatus());
		overtimeDto.setUserId(overtime.getUserId());
		overtimeDto.setDateCreated(overtime.getDateCreated());

		return overtimeDto;
	}

}
