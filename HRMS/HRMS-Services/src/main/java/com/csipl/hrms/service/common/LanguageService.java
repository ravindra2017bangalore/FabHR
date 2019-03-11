package com.csipl.hrms.service.common;

import java.util.List;

import com.csipl.hrms.model.common.Language;
public interface LanguageService {
 	public List<Language> getAllLanguages(Long companyId);
}
