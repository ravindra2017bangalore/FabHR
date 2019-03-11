package com.csipl.hrms.candidate.controller;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.candidate.CandidateOfficialInformationDTO;
import com.csipl.hrms.model.candidate.CandidateOfficialInformation;
import com.csipl.hrms.service.candidate.CandidateOfficialInfoService;
import com.csipl.hrms.service.candidate.adaptor.CandidateOfficialInformationAdaptor;


@RestController
@RequestMapping("/candidate")
public class CandidateOfficialInfoController {
	
	@Autowired
	CandidateOfficialInfoService candidateOfficialInfoService;
	
	CandidateOfficialInformationAdaptor candidateOfficialInformationAdaptor=new CandidateOfficialInformationAdaptor();
	private static final Logger logger = LoggerFactory.getLogger(CandidateOfficialInformation.class);
	
	/**
	 * to save the candidateOfficialInformation based on candidateId
	 * @throws ErrorHandling 
	 */

	@RequestMapping(value = "/official", method = RequestMethod.POST)
	public CandidateOfficialInformationDTO savecandidateOfficialInformation(@RequestBody CandidateOfficialInformationDTO candidateOfficialInformationDTO, HttpServletRequest req) throws ErrorHandling {
		logger.info("saveCandidateOfficialInformation is calling : candidateOfficialInformationDTO " + candidateOfficialInformationDTO);
		CandidateOfficialInformation candidateOfficialInformation = candidateOfficialInformationAdaptor.uiDtoToDatabaseModel(candidateOfficialInformationDTO);
		CandidateOfficialInformation CandidateOfficialInformationObj=candidateOfficialInfoService.save(candidateOfficialInformation,req);
		logger.info("saveCandidateOfficialInformation is end  :" + candidateOfficialInformation);
		return candidateOfficialInformationAdaptor.databaseModelToUiDto(CandidateOfficialInformationObj);
	}

	/**
	 * to get List of candidateOfficialInformation based on candidateId
	 */
	@RequestMapping(value = "/official/{candidateId}", method = RequestMethod.GET)
	public CandidateOfficialInformationDTO getOfficialInformation(@PathVariable("candidateId") Long candidateId,
			HttpServletRequest req) {
		CandidateOfficialInformationDTO candidateOfficialInformationDTO = null;
		logger.info("getCandidateStatuary is calling : candidateStatuaryDTO " + candidateId);
		CandidateOfficialInformation candidateOfficialInformation = candidateOfficialInfoService.findCandidateOfficialInformation(candidateId);
		if (candidateOfficialInformation != null) {
			candidateOfficialInformationDTO = candidateOfficialInformationAdaptor.databaseModelToUiDto(candidateOfficialInformation);
		}
		logger.info("getCandidateStatuary is end  :" + candidateOfficialInformationDTO);
		return candidateOfficialInformationDTO;
	}
	
}
