package com.csipl.hrms.service.common;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.Language;
import com.csipl.hrms.service.common.repository.LanguageRepository;
 @Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	 @Autowired
	 LanguageRepository languageRepository;
	 
	@Override
	public List<Language> getAllLanguages(Long companyId) {
 		return languageRepository.getAllLanguages(companyId);
	}
   }
