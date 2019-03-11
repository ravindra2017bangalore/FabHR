package com.csipl.tms.leave.adaptor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.tms.dto.leave.TMSLeaveTypeDTO;
import com.csipl.tms.model.leave.TMSLeavePeriod;
import com.csipl.tms.model.leave.TMSLeaveType;
import com.csipl.tms.model.leave.TMSLeaveTypeMaster;
import com.csipl.tms.service.Adaptor;

public class LeaveTypeAdaptor implements Adaptor<TMSLeaveTypeDTO, TMSLeaveType> {
  
private static final Logger log = LoggerFactory.getLogger(LeaveTypeAdaptor.class);

	@Override
	public List<TMSLeaveType> uiDtoToDatabaseModelList(List<TMSLeaveTypeDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TMSLeaveTypeDTO> databaseModelToUiDtoList(List<TMSLeaveType> tMSLeaveTypeList) {
log.info("LeaveTypeAdaptor.databaseModelToUiDtoList()");
		List<TMSLeaveTypeDTO> tMSLeaveTypeDtoList = new ArrayList<TMSLeaveTypeDTO>();
		for (TMSLeaveType tMSLeaveType : tMSLeaveTypeList) {
			tMSLeaveTypeDtoList.add(databaseModelToUiDto(tMSLeaveType));
		}
		return tMSLeaveTypeDtoList;
	}

	public TMSLeaveType leaveuiDtoToDatabaseModel(TMSLeaveTypeDTO tMSLeaveTypeDTO, Long leavePeriodId) {
		log.info("LeaveTypeAdaptor.leaveuiDtoToDatabaseModel()");
		TMSLeaveType tMSLeaveType = new TMSLeaveType();
		tMSLeaveType.setLeaveTypeId(tMSLeaveTypeDTO.getLeaveTypeId());
		tMSLeaveType.setActiveStatus(tMSLeaveTypeDTO.getActiveStatus());
		tMSLeaveType.setCarryForwardLimit(tMSLeaveTypeDTO.getCarryForwardLimit());
		tMSLeaveType.setCompanyId(tMSLeaveTypeDTO.getCompanyId());
		tMSLeaveType.setDateCreated(tMSLeaveTypeDTO.getDateCreated());
		tMSLeaveType.setDateUpdate(tMSLeaveTypeDTO.getDateUpdate());
		tMSLeaveType.setIndexDays(tMSLeaveTypeDTO.getIndexDays());
		tMSLeaveType.setIsLeaveInProbation(tMSLeaveTypeDTO.getIsLeaveInProbation());
		tMSLeaveType.setIsWeekOffAsPL(tMSLeaveTypeDTO.getIsWeekOffAsPL());
		tMSLeaveType.setLeaveFrequencyInMonth(tMSLeaveTypeDTO.getLeaveFrequencyInMonth());
		tMSLeaveType.setLeaveMode(tMSLeaveTypeDTO.getLeaveMode());
		tMSLeaveType.setMaxLeaveInMonth(tMSLeaveTypeDTO.getMaxLeaveInMonth());
		tMSLeaveType.setNature(tMSLeaveTypeDTO.getNature());
		tMSLeaveType.setNotice(tMSLeaveTypeDTO.getNotice());
		tMSLeaveType.setYearlyLimit(tMSLeaveTypeDTO.getYearlyLimit());
		tMSLeaveType.setWeekOffAsPLCount(tMSLeaveTypeDTO.getWeekOffAsPLCount());
		tMSLeaveType.setUserId(tMSLeaveTypeDTO.getUserId());
		tMSLeaveType.setUserIdUpdate(tMSLeaveTypeDTO.getUserIdUpdate());
		TMSLeavePeriod tMSLeavePeriod = new TMSLeavePeriod();
		tMSLeavePeriod.setLeavePeriodId(leavePeriodId);
		tMSLeaveType.setTmsleavePeriod(tMSLeavePeriod);
		TMSLeaveTypeMaster tMSLeaveTypeMaster = new TMSLeaveTypeMaster();
		tMSLeaveTypeMaster.setLeaveId(tMSLeaveTypeDTO.getLeaveTypeMasterId());
		tMSLeaveType.setTmsleaveTypeMaster(tMSLeaveTypeMaster);
		return tMSLeaveType;
	}

	@Override
	public TMSLeaveTypeDTO databaseModelToUiDto(TMSLeaveType tMSLeaveType) {
		log.info("LeaveTypeAdaptor.databaseModelToUiDto()");
		TMSLeaveTypeDTO tMSLeaveTypeDTO = new TMSLeaveTypeDTO();
		tMSLeaveTypeDTO.setLeaveTypeId(tMSLeaveType.getLeaveTypeId());
		tMSLeaveTypeDTO.setActiveStatus(tMSLeaveType.getActiveStatus());
		tMSLeaveTypeDTO.setCarryForwardLimit(tMSLeaveType.getCarryForwardLimit());
		tMSLeaveTypeDTO.setCompanyId(tMSLeaveType.getCompanyId());
		tMSLeaveTypeDTO.setDateCreated(tMSLeaveType.getDateCreated());
		tMSLeaveTypeDTO.setDateUpdate(tMSLeaveType.getDateUpdate());
		tMSLeaveTypeDTO.setIndexDays(tMSLeaveType.getIndexDays());
		tMSLeaveTypeDTO.setIsLeaveInProbation(tMSLeaveType.getIsLeaveInProbation());
		tMSLeaveTypeDTO.setIsWeekOffAsPL(tMSLeaveType.getIsWeekOffAsPL());
		tMSLeaveTypeDTO.setLeaveFrequencyInMonth(tMSLeaveType.getLeaveFrequencyInMonth());
		tMSLeaveTypeDTO.setLeaveMode(tMSLeaveType.getLeaveMode());
		tMSLeaveTypeDTO.setMaxLeaveInMonth(tMSLeaveType.getMaxLeaveInMonth());
		tMSLeaveTypeDTO.setNature(tMSLeaveType.getNature());
		tMSLeaveTypeDTO.setNotice(tMSLeaveType.getNotice());
		tMSLeaveTypeDTO.setYearlyLimit(tMSLeaveType.getYearlyLimit());
		tMSLeaveTypeDTO.setWeekOffAsPLCount(tMSLeaveType.getWeekOffAsPLCount());
		tMSLeaveTypeDTO.setUserId(tMSLeaveType.getUserId());
		tMSLeaveTypeDTO.setUserIdUpdate(tMSLeaveType.getUserIdUpdate());
		tMSLeaveTypeDTO.setLeavePeriodId(tMSLeaveType.getTmsleavePeriod().getLeavePeriodId());
		tMSLeaveTypeDTO.setLeaveTypeMasterId(tMSLeaveType.getTmsleaveTypeMaster().getLeaveId());
		return tMSLeaveTypeDTO;
	}

	@Override
	public TMSLeaveType uiDtoToDatabaseModel(TMSLeaveTypeDTO tMSLeaveTypeDTO) {
		log.info("LeaveTypeAdaptor.uiDtoToDatabaseModel()");
		return null;
	}

}
