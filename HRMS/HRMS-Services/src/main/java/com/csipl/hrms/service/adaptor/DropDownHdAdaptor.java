package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.hrms.dto.organisation.DropDownHdDTO;
import com.csipl.hrms.dto.organisation.DropDownListDTO;

public class DropDownHdAdaptor implements Adaptor<DropDownHdDTO, DrowpdownHd> {

	DropDownListAdaptor dropDownListAdaptor=new DropDownListAdaptor();
	@Override
	public List<DrowpdownHd> uiDtoToDatabaseModelList(List<DropDownHdDTO> dropDownHdDtoList) {
		
		return null;
	}

	@Override
	public List<DropDownHdDTO> databaseModelToUiDtoList(List<DrowpdownHd> drowpdownHdList) {
		List<DropDownHdDTO> dropDownHdDtoList=new ArrayList<DropDownHdDTO>();
		for (DrowpdownHd drowpdownHd : drowpdownHdList) {
			dropDownHdDtoList.add(databaseModelToUiDto(drowpdownHd));
		}
		
		

		return dropDownHdDtoList;
	}

	@Override
	public DrowpdownHd uiDtoToDatabaseModel(DropDownHdDTO dropDownHdDto) {
		return null;
	}

	@Override
	public DropDownHdDTO databaseModelToUiDto(DrowpdownHd drowpdownHd) {
		DropDownHdDTO dropDownHdDto=new DropDownHdDTO();
		dropDownHdDto.setDrowpdownId(drowpdownHd.getDrowpdownId());
		dropDownHdDto.setDrowpdownName(drowpdownHd.getDrowpdownName());
		dropDownHdDto.setDrowpdownLists(dropDownListAdaptor.databaseModelToUiDtoList(drowpdownHd.getDrowpdownLists()));
		
		Collections.sort(dropDownHdDto.getDrowpdownLists(), new Comparator<DropDownListDTO>() {
			@Override
			public int compare(DropDownListDTO dropDownHdDtoA, DropDownListDTO dropDownHdDtoB) {
				String name1 = dropDownHdDtoA.getListValue();
				String name2 = dropDownHdDtoB.getListValue();
				int diff = name1.compareTo(name2);
				return diff;
			}

		});
		
		
		
		
		return dropDownHdDto;
	}

}
