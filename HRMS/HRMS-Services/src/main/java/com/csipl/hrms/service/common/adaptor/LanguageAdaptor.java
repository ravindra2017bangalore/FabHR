package com.csipl.hrms.service.common.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.common.LanguageDTO;
import com.csipl.hrms.model.common.Language;
import com.csipl.hrms.service.adaptor.Adaptor;

public class LanguageAdaptor implements Adaptor<LanguageDTO, Language> {

	@Override
	public List<Language> uiDtoToDatabaseModelList(List<LanguageDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LanguageDTO> databaseModelToUiDtoList(List<Language> languageList) {
		List<LanguageDTO> languageDtoList = new ArrayList<LanguageDTO>();
		for (Language language : languageList) {
			languageDtoList.add(databaseModelToUiDto(language));
		}

		return languageDtoList;
	}

	@Override
	public Language uiDtoToDatabaseModel(LanguageDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LanguageDTO databaseModelToUiDto(Language language) {
		LanguageDTO languageDto = new LanguageDTO();
		languageDto.setLanguageId(language.getLanguageId());
		languageDto.setCode(language.getCode());
		languageDto.setCompanyId(language.getCompanyId());
		languageDto.setName(language.getName());
		return languageDto;
	}

}
