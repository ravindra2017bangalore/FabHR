package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.model.DrowpdownList;
import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.organisation.DropDownListDTO;
import com.csipl.hrms.dto.organisation.MandatoryInfoDTO;
import com.csipl.hrms.model.common.MandatoryInfo;

public class MandatoryInfoAdaptor {

	public List<MandatoryInfo> uiDtoToDatabaseModelList(List<MandatoryInfoDTO> mandatoryInfoDdDtos,
			List<MandatoryInfoDTO> mandatoryInfoListDto) {
		List<MandatoryInfo> mandatoryInfoList = new ArrayList<MandatoryInfo>();

		for (MandatoryInfoDTO mandatoryInfoDdDto : mandatoryInfoDdDtos) {
			mandatoryInfoDdDto.setStatus(null);
			checkMandatoryInfoStatus(mandatoryInfoDdDto, mandatoryInfoListDto);
			mandatoryInfoList.add(uiDtoToDatabaseModel(mandatoryInfoDdDto));
		}

		return mandatoryInfoList;
	}

	private void checkMandatoryInfoStatus(MandatoryInfoDTO mandatoryInfoDdDto,
			List<MandatoryInfoDTO> mandatoryInfoListDto) {

		for (MandatoryInfoDTO dto : mandatoryInfoListDto) {

			if (dto.getDocCode().equals(mandatoryInfoDdDto.getDocCode())) {
				mandatoryInfoDdDto.setStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
				break;
			}
		}
	}

	public List<MandatoryInfoDTO> databaseModelToUiDtoList(List<MandatoryInfo> mandatoryInfoList) {
		List<MandatoryInfoDTO> mandatoryInfoDtos = new ArrayList<MandatoryInfoDTO>();
		for (MandatoryInfo mandatoryInfo : mandatoryInfoList) {
			mandatoryInfoDtos.add(databaseModelToUiDto(mandatoryInfo));
		}
		return mandatoryInfoDtos;
	}

	public MandatoryInfo uiDtoToDatabaseModel(MandatoryInfoDTO mandatoryInfoDdDto) {
		MandatoryInfo mandatoryInfo = new MandatoryInfo();
		mandatoryInfo.setUserId(mandatoryInfoDdDto.getUserId());
		mandatoryInfo.setDateCreated(mandatoryInfoDdDto.getDateCreated());
		mandatoryInfo.setDocCode(mandatoryInfoDdDto.getDocCode());
		mandatoryInfo.setDocName(mandatoryInfoDdDto.getDocName());
		mandatoryInfo.setMandatoryInfoId(mandatoryInfoDdDto.getMandatoryInfoId());
		if (mandatoryInfoDdDto.getStatus() == null) {
			mandatoryInfo.setStatus("AN");
		} else {
			mandatoryInfo.setStatus("AC");
		}

		return mandatoryInfo;
	}

	public List<MandatoryInfoDTO> dropDownToUiDto(DrowpdownHd drowpdownHd) {
		List<MandatoryInfoDTO> mandatoryInfoDto = new ArrayList<MandatoryInfoDTO>();
		for (DrowpdownList mandatoryInfo : drowpdownHd.getDrowpdownLists()) {
			mandatoryInfoDto.add(databaseModelDDListToUiDto(mandatoryInfo));
		}
		// mandatoryInfoDto.setDrowpdownDtoLists(databaseModelDDToUiDtoList(drowpdownHd.getDrowpdownLists()));
		return mandatoryInfoDto;

	}

	public List<MandatoryInfoDTO> dropDownToUiDto(DrowpdownHd drowpdownHd, List<MandatoryInfo> mandatoryInfos) {
		List<MandatoryInfoDTO> mandatoryInfoDtos = new ArrayList<MandatoryInfoDTO>();
		for (DrowpdownList mandatoryInfoDD : drowpdownHd.getDrowpdownLists()) {
			MandatoryInfoDTO mandatoryInfoDto = databaseModelDDListToUiDto(mandatoryInfoDD);
			if (mandatoryInfos != null && mandatoryInfos.size() > 0) {
				setDBValue(mandatoryInfoDto, mandatoryInfos);
			}
			mandatoryInfoDtos.add(mandatoryInfoDto);
		}
		// mandatoryInfoDto.setDrowpdownDtoLists(databaseModelDDToUiDtoList(drowpdownHd.getDrowpdownLists()));
		return mandatoryInfoDtos;

	}

	private void setDBValue(MandatoryInfoDTO mandatoryInfoDto, List<MandatoryInfo> mandatoryInfos) {

		for (MandatoryInfo mandatoryInfo : mandatoryInfos) {
			if (mandatoryInfoDto.getDocCode().equals(mandatoryInfo.getDocCode())) {
				mandatoryInfoDto.setMandatoryInfoId(mandatoryInfo.getMandatoryInfoId());
				mandatoryInfoDto.setDateCreated(mandatoryInfo.getDateCreated());
				mandatoryInfoDto.setStatus(mandatoryInfo.getStatus());
				mandatoryInfoDto.setUserId(mandatoryInfo.getUserId());
				break;
			}
		}
	}

	public MandatoryInfoDTO databaseModelDDListToUiDto(DrowpdownList dropDownList) {
		MandatoryInfoDTO mandatoryInfoDto = new MandatoryInfoDTO();
		mandatoryInfoDto.setDocCode(dropDownList.getListCode());
		mandatoryInfoDto.setDocName(dropDownList.getListValue());
		return mandatoryInfoDto;

	}

	public List<DropDownListDTO> databaseModelDDToUiDtoList(List<DrowpdownList> drowpdownList) {
		List<DropDownListDTO> dropDownListDtoList = new ArrayList<DropDownListDTO>();

		for (DrowpdownList drowpdownList2 : drowpdownList) {
			dropDownListDtoList.add(databaseModelToUiDto(drowpdownList2));
		}
		return dropDownListDtoList;
	}

	public DropDownListDTO databaseModelToUiDto(DrowpdownList dropDownList) {
		DropDownListDTO dropDownListDto = new DropDownListDTO();
		dropDownListDto.setListCode(dropDownList.getListCode());
		dropDownListDto.setListValue(dropDownList.getListValue());
		return dropDownListDto;

	}

	public MandatoryInfoDTO databaseModelToUiDto(MandatoryInfo mandatoryInfo) {
		MandatoryInfoDTO mandatoryInfoDTO = new MandatoryInfoDTO();
		mandatoryInfoDTO.setDocName(mandatoryInfo.getDocName());
		mandatoryInfoDTO.setDocCode(mandatoryInfo.getDocCode());
		mandatoryInfoDTO.setDateCreated(mandatoryInfo.getDateCreated());
		mandatoryInfoDTO.setMandatoryInfoId(mandatoryInfo.getMandatoryInfoId());
		mandatoryInfoDTO.setStatus(mandatoryInfo.getStatus());
		mandatoryInfoDTO.setUserId(mandatoryInfo.getUserId());

		return mandatoryInfoDTO;
	}

}
