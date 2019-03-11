package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.organisation.GroupDTO;
import com.csipl.hrms.model.common.Groupg;

public class GroupAdaptor implements Adaptor<GroupDTO, Groupg> {

	AddressAdaptor addressAdaptor = new AddressAdaptor();

	@Override
	public List<Groupg> uiDtoToDatabaseModelList(List<GroupDTO> groupDtoList) {
		List<Groupg> groupList = new ArrayList<Groupg>();
		for (GroupDTO groupDto : groupDtoList) {
			groupList.add(uiDtoToDatabaseModel(groupDto));
		}
		return groupList;
	}

	@Override
	public List<GroupDTO> databaseModelToUiDtoList(List<Groupg> groupList) {
		List<GroupDTO> groupDto = new ArrayList<GroupDTO>();
		for (Groupg group : groupList) {
			groupDto.add(databaseModelToUiDto(group));
		}
		return groupDto;
	}

	@Override
	public Groupg uiDtoToDatabaseModel(GroupDTO groupDto) {
		Groupg group = new Groupg();
		group.setDateOfBirth(groupDto.getDateOfBirth());
		group.setGroupAbbrebiation(groupDto.getGroupAbbrebiation());
		group.setGroupId(groupDto.getGroupId());
		group.setGroupName(groupDto.getGroupName());
		group.setGroupLogoPath(groupDto.getGroupLogoPath());
		group.setAddress(addressAdaptor.uiDtoToDatabaseModel(groupDto.getAddress()));

		return group;
	}

	@Override
	public GroupDTO databaseModelToUiDto(Groupg group) {
		GroupDTO groupDto = new GroupDTO();
		groupDto.setDateOfBirth(group.getDateOfBirth());
		groupDto.setGroupAbbrebiation(group.getGroupAbbrebiation());
		groupDto.setGroupId(group.getGroupId());
		groupDto.setGroupName(group.getGroupName());
		if (group.getUserId() != null) {
			groupDto.setUserId(group.getUserId());
		}
		if (group.getAddress() != null)
			groupDto.setAddress(addressAdaptor.databaseModelToUiDto(group.getAddress()));
		groupDto.setGroupLogoPath(group.getGroupLogoPath());
		return groupDto;
	}
}
