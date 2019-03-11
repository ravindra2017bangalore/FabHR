package com.csipl.hrms.service.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.candidate.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

	@Query(" SELECT count(*) from Candidate  where companyId=?1 AND candidateStatus =?2  ")
	int candidateCount(long longCompanyId, String candidateStatus);

	@Query(" from Candidate where candidateCode=?1 ")
	public Candidate findCandidateByCode(String candidatecode);

	@Modifying
	@Query("UPDATE Candidate SET candidateLogoPath=?1 WHERE candidateId=?2")
	void saveCandidateImage(String dbPath, Long candidateId);

	@Modifying
	@Query("UPDATE Candidate SET candidateStatus=?1 ,declineReason=?3 WHERE candidateId=?2")
	void changeCandidateStatus(String candidateStatus, Long candidateId,String reason);

	String processBar = "SELECT  cp.candidateId AS cPersonal, cip.candidateId AS cIdProofs,  cpi.candidateId AS cProfessionalInformation,  ce.candidateId AS cEducation, cf.candidateId AS cFamily, cs.candidateId AS cStatutory,  c.candidateId AS candidateId FROM  Candidate c LEFT JOIN CandidateStatuary cs ON   cs.candidateId = c.candidateId LEFT JOIN CandidateIdProofs cip ON  cip.candidateId = c.candidateId LEFT JOIN CandidatePersonal cp ON cp.candidateId = c.candidateId LEFT JOIN CandidateProfessionalInformation cpi ON  cpi.candidateId = c.candidateId LEFT JOIN CandidateEducation ce ON ce.candidateId = c.candidateId LEFT JOIN CandidateFamily cf ON  cf.candidateId = c.candidateId WHERE  c.candidateId =?1";

	@Query(value = processBar, nativeQuery = true)
	List<Object[]> getProcessBar(Long candidateId);

	String tabValidation = "SELECT cp.candidateId as personal, cid.candidateId as idproof, cf.candidateId as family, cs.candidateId as statuary  FROM Candidate c JOIN CandidatePersonal cp ON cp.candidateId = c.candidateId JOIN CandidateIdProofs cid ON cid.candidateId = c.candidateId JOIN CandidateFamily cf ON cf.candidateId = c.candidateId JOIN CandidateStatuary cs ON cs.candidateId = c.candidateId WHERE c.candidateId = ?1";

	@Query(value = tabValidation, nativeQuery = true)
	List<Object[]> tabSubmitValidation(Long candidateId);
	
	
	String findShiftName = "SELECT  shift.shiftFName , shift.shiftId FROM TMSShift shift WHERE  shift.shiftId=?1";
 	@Query(value = findShiftName, nativeQuery = true)
	List<Object[]> findShiftName(Long shiftId);

	String findWPatternName = "SELECT  pattern.patternName,pattern.patternId FROM TMSWeekOffPattern pattern WHERE pattern.patternId=?1";

	@Query(value = findWPatternName, nativeQuery = true)
	List<Object[]> findPatternName(Long patternId);
	
}
