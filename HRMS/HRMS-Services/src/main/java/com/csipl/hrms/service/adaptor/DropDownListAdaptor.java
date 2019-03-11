package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.common.model.DrowpdownList;
import com.csipl.hrms.dto.organisation.DropDownListDTO;

public class DropDownListAdaptor implements Adaptor<DropDownListDTO, DrowpdownList> {

	@Override
	public List<DrowpdownList> uiDtoToDatabaseModelList(List<DropDownListDTO> dropDownListDtoList) {
		return null;
	}

	@Override
	public List<DropDownListDTO> databaseModelToUiDtoList(List<DrowpdownList> drowpdownListList) {
		List<DropDownListDTO> dropDownListDtoList=new ArrayList<DropDownListDTO>();
		for (DrowpdownList dropDownList : drowpdownListList) {
			if ( dropDownList.getActiveStatus().equals("A") ) {
				dropDownListDtoList.add(databaseModelToUiDto(dropDownList));
			}
		}
		return dropDownListDtoList;
	}

	@Override
	public DrowpdownList uiDtoToDatabaseModel(DropDownListDTO dropDownListDto) {
		return null;
	}

	@Override
	public DropDownListDTO databaseModelToUiDto(DrowpdownList drowpdownList) {
		DropDownListDTO dropDownListDto=new DropDownListDTO();
		dropDownListDto.setDrowpdownListId(drowpdownList.getDrowpdownListId());
		dropDownListDto.setListValue(drowpdownList.getListValue());
		dropDownListDto.setListCode(drowpdownList.getListCode());
		dropDownListDto.setActiveStatus(drowpdownList.getActiveStatus());
		return dropDownListDto;
	}

}
