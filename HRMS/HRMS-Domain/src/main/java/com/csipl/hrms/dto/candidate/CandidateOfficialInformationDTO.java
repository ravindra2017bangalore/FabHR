package com.csipl.hrms.dto.candidate;

import java.util.Date;



public class CandidateOfficialInformationDTO {
	
	private Long candidateOfficialId;

	private String accidentalInsurance;

	private Date aiFromDate;

	private Date aiToDate;

	private Long companyId;
	
	private Date dateCreated;

	private Date dateUpdate;
	
	private Date esiEnrollDate;

	private String esiNumber;

	private Long grade;

	private String isAiApplicable;

	private String isEsicApplicable;

	private String isMiApplicable;

	private String isPfApplicable;

	private String medicalInsurance;
	
	private Date miFromDate;

	private Date miToDate;

	private Long noticePeriod;

	private Date pfEnrollDate;

	private String pfNumber;

	private Long probationDays;

	private String uanNumber;

	private Long userId;

	private Long userIdUpdate;
	
	private Long candidateId;
	
	private String gradeName;
	
	private Long UanId;
	
	private Long EsicId;
	
	private Long MiId;

	private Long AiId;
	
	private Long pfId;
	private Long employeeId;

	public Long getCandidateId() {
		return candidateId;
	}

	public Long getUanId() {
		return UanId;
	}

	public void setUanId(Long uanId) {
		UanId = uanId;
	}

	public Long getEsicId() {
		return EsicId;
	}

	public void setEsicId(Long esicId) {
		EsicId = esicId;
	}

	public Long getMiId() {
		return MiId;
	}

	public void setMiId(Long miId) {
		MiId = miId;
	}

	public Long getAiId() {
		return AiId;
	}

	public void setAiId(Long aiId) {
		AiId = aiId;
	}

	public Long getPfId() {
		return pfId;
	}

	public void setPfId(Long pfId) {
		this.pfId = pfId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Date getMiFromDate() {
		return miFromDate;
	}

	public void setMiFromDate(Date miFromDate) {
		this.miFromDate = miFromDate;
	}

	public Date getMiToDate() {
		return miToDate;
	}

	public void setMiToDate(Date miToDate) {
		this.miToDate = miToDate;
	}

	public Long getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(Long noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public Date getPfEnrollDate() {
		return pfEnrollDate;
	}

	public void setPfEnrollDate(Date pfEnrollDate) {
		this.pfEnrollDate = pfEnrollDate;
	}

	public String getPfNumber() {
		return pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public Long getProbationDays() {
		return probationDays;
	}

	public void setProbationDays(Long probationDays) {
		this.probationDays = probationDays;
	}

	public String getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	

	public Long getCandidateOfficialId() {
		return candidateOfficialId;
	}

	public void setCandidateOfficialId(Long candidateOfficialId) {
		this.candidateOfficialId = candidateOfficialId;
	}

	public String getAccidentalInsurance() {
		return accidentalInsurance;
	}

	public void setAccidentalInsurance(String accidentalInsurance) {
		this.accidentalInsurance = accidentalInsurance;
	}

	public Date getAiFromDate() {
		return aiFromDate;
	}

	public void setAiFromDate(Date aiFromDate) {
		this.aiFromDate = aiFromDate;
	}

	public Date getAiToDate() {
		return aiToDate;
	}

	public void setAiToDate(Date aiToDate) {
		this.aiToDate = aiToDate;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getEsiEnrollDate() {
		return esiEnrollDate;
	}

	public void setEsiEnrollDate(Date esiEnrollDate) {
		this.esiEnrollDate = esiEnrollDate;
	}

	public String getEsiNumber() {
		return esiNumber;
	}

	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public String getIsAiApplicable() {
		return isAiApplicable;
	}

	public void setIsAiApplicable(String isAiApplicable) {
		this.isAiApplicable = isAiApplicable;
	}

	public String getIsEsicApplicable() {
		return isEsicApplicable;
	}

	public void setIsEsicApplicable(String isEsicApplicable) {
		this.isEsicApplicable = isEsicApplicable;
	}

	public String getIsMiApplicable() {
		return isMiApplicable;
	}

	public void setIsMiApplicable(String isMiApplicable) {
		this.isMiApplicable = isMiApplicable;
	}

	public String getIsPfApplicable() {
		return isPfApplicable;
	}

	public void setIsPfApplicable(String isPfApplicable) {
		this.isPfApplicable = isPfApplicable;
	}

	public String getMedicalInsurance() {
		return medicalInsurance;
	}

	public void setMedicalInsurance(String medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	

}
