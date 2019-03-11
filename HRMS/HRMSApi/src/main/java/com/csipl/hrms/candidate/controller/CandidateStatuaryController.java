package com.csipl.hrms.candidate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.dto.candidate.CandidateStatuaryDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateStatuary;
import com.csipl.hrms.service.adaptor.CandidateStatuaryAdaptor;
import com.csipl.hrms.service.candidate.CandidateService;
import com.csipl.hrms.service.candidate.CandidateStatuaryService;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateStatuaryController {

	@Autowired
	CandidateStatuaryService candidateStatuaryService;

	@Autowired
	CandidateService candidateService;
	private static final Logger logger = LoggerFactory.getLogger(CandidateStatuaryController.class);

	CandidateStatuaryAdaptor candidateStatuaryAdaptor = new CandidateStatuaryAdaptor();

	/**
	 * to save List of CandidateStatuaryBanking based on candidateId
	 * @throws Exception 
	 */

	@RequestMapping(value = "/statuary", method = RequestMethod.POST)
	public CandidateStatuaryDTO saveCandidateStatuary(@RequestBody CandidateStatuaryDTO candidateStatuaryDTO, HttpServletRequest req) throws Exception {
		logger.info("saveCandidateStatuary is calling : candidateStatuaryDTO " + candidateStatuaryDTO);
		CandidateStatuary candidateStatuary = candidateStatuaryAdaptor.uiDtoToDatabaseModel(candidateStatuaryDTO);
		CandidateStatuary candidateStatuaryObj=candidateStatuaryService.save(candidateStatuary);
		logger.info("saveCandidateStatuary is end  :" + candidateStatuary);
		Candidate newJoinee = candidateService.findCandidate(candidateStatuaryObj.getCandidateId());
		if(candidateStatuaryObj!=null && newJoinee.getCandidateStatus().equals("IN") ) {
			newJoinee.setCandidateStatus("PN");
			candidateService.save(newJoinee);
		}
		return candidateStatuaryAdaptor.databaseModelToUiDto(candidateStatuaryObj);
	}

	/**
	 * to get List of CandidateStatuaryBanking based on candidateId
	 */
	@RequestMapping(value = "/statuary/{candidateId}", method = RequestMethod.GET)
	public CandidateStatuaryDTO getCandidateStatuary(@PathVariable("candidateId") Long candidateId,
			HttpServletRequest req) {
		CandidateStatuaryDTO candidateStatuaryDTO = null;
		logger.info("getCandidateStatuary is calling : candidateStatuaryDTO " + candidateId);
		CandidateStatuary candidateStatuary = candidateStatuaryService.findCandidateStatuary(candidateId);
		if (candidateStatuary != null) {
			candidateStatuaryDTO = candidateStatuaryAdaptor.databaseModelToUiDto(candidateStatuary);
			// return candidateStatuaryDTO;
		}
		logger.info("getCandidateStatuary is end  :" + candidateStatuary);
		return candidateStatuaryDTO;

	}

}
