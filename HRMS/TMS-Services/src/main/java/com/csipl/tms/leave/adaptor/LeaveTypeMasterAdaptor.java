package com.csipl.tms.leave.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.tms.service.Adaptor;
import com.csipl.tms.dto.leave.TMSLeaveTypeMasterDTO;

import com.csipl.tms.model.leave.TMSLeaveTypeMaster;

public class LeaveTypeMasterAdaptor implements  Adaptor<TMSLeaveTypeMasterDTO,TMSLeaveTypeMaster>{

	@Override
	public List<TMSLeaveTypeMaster> uiDtoToDatabaseModelList(List<TMSLeaveTypeMasterDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TMSLeaveTypeMasterDTO> databaseModelToUiDtoList(List<TMSLeaveTypeMaster> leaveTypeMasterList) {
		List<TMSLeaveTypeMasterDTO> leaveTypeMasterDtoList = new ArrayList<TMSLeaveTypeMasterDTO>();
		for (TMSLeaveTypeMaster leaveTypeMaster : leaveTypeMasterList) {
			leaveTypeMasterDtoList.add(databaseModelToUiDto(leaveTypeMaster));
		}
		return leaveTypeMasterDtoList;
	}

	@Override
	public TMSLeaveTypeMaster uiDtoToDatabaseModel(TMSLeaveTypeMasterDTO leaveTypeMasterDTO) {
		TMSLeaveTypeMaster leaveTypeMaster=new TMSLeaveTypeMaster();
		leaveTypeMaster.setLeaveId(leaveTypeMasterDTO.getLeaveId());
		leaveTypeMaster.setLeaveName(leaveTypeMasterDTO.getLeaveName());

		leaveTypeMaster.setActiveStatus(leaveTypeMasterDTO.getActiveStatus());

		leaveTypeMaster.setCompanyId(leaveTypeMasterDTO.getCompanyId());

		leaveTypeMaster.setUserId(leaveTypeMasterDTO.getUserId());
		leaveTypeMaster.setUserIdUpdate(leaveTypeMasterDTO.getUserIdUpdate());

		leaveTypeMaster.setDateCreated(leaveTypeMasterDTO.getDateCreated());

		leaveTypeMaster.setDateUpdate(leaveTypeMasterDTO.getDateUpdate());

		return leaveTypeMaster;
	}

	@Override
	public TMSLeaveTypeMasterDTO databaseModelToUiDto(TMSLeaveTypeMaster leaveTypeMaster) {
		TMSLeaveTypeMasterDTO leaveTypeMasterDTO=new TMSLeaveTypeMasterDTO();
		leaveTypeMasterDTO.setLeaveId(leaveTypeMaster.getLeaveId());
		leaveTypeMasterDTO.setLeaveName(leaveTypeMaster.getLeaveName());
		leaveTypeMasterDTO.setActiveStatus(leaveTypeMaster.getActiveStatus());
		leaveTypeMasterDTO.setCompanyId(leaveTypeMaster.getCompanyId());
		leaveTypeMasterDTO.setUserId(leaveTypeMaster.getUserId());
		leaveTypeMasterDTO.setUserIdUpdate(leaveTypeMaster.getUserIdUpdate());
		leaveTypeMasterDTO.setDateCreated(leaveTypeMaster.getDateCreated());
		leaveTypeMasterDTO.setDateUpdate(leaveTypeMaster.getDateUpdate());
		
		return leaveTypeMasterDTO;
	}

}
