package com.csipl.hrms.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.common.LanguageDTO;

import com.csipl.hrms.model.common.Language;
import com.csipl.hrms.service.common.LanguageService;
import com.csipl.hrms.service.common.adaptor.LanguageAdaptor;

@RestController
@RequestMapping("/language")
public class LanguageController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(LanguageController.class);
	@Autowired
	LanguageService languageService;

	LanguageAdaptor languageAdaptor = new LanguageAdaptor();;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<LanguageDTO> getAllLanguages(@RequestParam("companyId") Long companyId)
			throws ErrorHandling {
		logger.info("getAllLanguages is calling :  ");
		List<Language> languageList = languageService.getAllLanguages(companyId);

		if (languageList != null)
			return languageAdaptor.databaseModelToUiDtoList(languageList);
		else
			throw new ErrorHandling(" Languages are not available in company");

	}

}