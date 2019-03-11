package com.csipl.hrms.candidate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.candidate.CandidatePersonalDTO;
import com.csipl.hrms.model.candidate.CandidatePersonal;
import com.csipl.hrms.service.candidate.CandidatePersonalService;
import com.csipl.hrms.service.candidate.adaptor.CandidatePersonalAdaptor;

@RestController
@RequestMapping("/candidatePersonal")
public class CandidatePersonalController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CandidatePersonalController.class);
	@Autowired
	CandidatePersonalService candidatePersonalService;

	CandidatePersonalAdaptor candidatePersonalAdaptor = new CandidatePersonalAdaptor();

	@RequestMapping(method = RequestMethod.POST)
	public CandidatePersonalDTO saveCandidatePersonal(@RequestBody CandidatePersonalDTO candidatePersonalDto)
			throws Exception {
		logger.info("saveCandidatePersonal is calling : " + " : candidatePersonalDTO " + candidatePersonalDto);
		CandidatePersonal candidatePersonal = candidatePersonalAdaptor.uiDtoToDatabaseModel(candidatePersonalDto);
		return candidatePersonalAdaptor.databaseModelToUiDto(candidatePersonalService.savePersonal(candidatePersonal));
	}

	@RequestMapping(value = "/{candidateId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CandidatePersonalDTO get(@PathVariable("candidateId") Long candidateId) {
		System.out.println("Employee service is calling : " + candidateId);
		CandidatePersonal candidatePersonal = candidatePersonalService.findCandidatePersonal(candidateId);
		//System.out.println("id.."+candidatePersonal.getCandidatePersonalId());
		return candidatePersonalAdaptor.databaseModelToUiDto(candidatePersonal);

	}
}
