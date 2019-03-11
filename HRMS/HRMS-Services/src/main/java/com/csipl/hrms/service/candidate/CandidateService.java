package com.csipl.hrms.service.candidate;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.dto.candidate.CandidateDTO;
import com.csipl.hrms.model.candidate.Candidate;


public interface CandidateService {
	public Candidate save(Candidate candidate) throws Exception;

	public Candidate findCandidate(Long candidateId);

	public CandidateDTO findCandidatebyId(Long candidateId);

	public Candidate findCandidateByCode(String candidateId);

	public void saveCandidateImage(Long candidateId, MultipartFile file);

	public void changeCandidateStatus(String candidateStatus, Long candidateId,String reason);

	public List<Object[]> progressBar(Long progressBar);

	public List<Object[]> tabSubmitValidation(Long candidateId);

	public void resendMail(Candidate candidate,String comment);

	public String findShiftName(Long shiftId);

	public String findWeekOffPatternName(Long patternId);
	
	
}
