package com.csipl.hrms.model.candidate;
import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.organisation.Grade;

import java.util.Date;


/**
 * The persistent class for the CandidateOfficialInformation database table.
 * 
 */
@Entity
@NamedQuery(name="CandidateOfficialInformation.findAll", query="SELECT c FROM CandidateOfficialInformation c")
public class CandidateOfficialInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateOfficialId;

	private String accidentalInsurance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date aiFromDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date aiToDate;

	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date esiEnrollDate;

	private String esiNumber;

	private String isAiApplicable;

	private String isEsicApplicable;

	private String isMiApplicable;

	private String isPfApplicable;

	private String medicalInsurance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date miFromDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date miToDate;

	private Long noticePeriod;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pfEnrollDate;

	private String pfNumber;

	private Long probationDays;

	private String uanNumber;

	private Long userId;

	private Long userIdUpdate;

	@Transient
	private Long employeeId;
	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="candidateId")
	private Candidate candidate;

	//bi-directional many-to-one association to Grade
	@ManyToOne
	@JoinColumn(name="gradeId")
	private Grade grade;

	public CandidateOfficialInformation() {
	}

	public Long getCandidateOfficialId() {
		return this.candidateOfficialId;
	}

	public void setCandidateOfficialId(Long candidateOfficialId) {
		this.candidateOfficialId = candidateOfficialId;
	}

	public String getAccidentalInsurance() {
		return this.accidentalInsurance;
	}

	public void setAccidentalInsurance(String accidentalInsurance) {
		this.accidentalInsurance = accidentalInsurance;
	}

	public Date getAiFromDate() {
		return this.aiFromDate;
	}

	public void setAiFromDate(Date aiFromDate) {
		this.aiFromDate = aiFromDate;
	}

	public Date getAiToDate() {
		return this.aiToDate;
	}

	public void setAiToDate(Date aiToDate) {
		this.aiToDate = aiToDate;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getEsiEnrollDate() {
		return this.esiEnrollDate;
	}

	public void setEsiEnrollDate(Date esiEnrollDate) {
		this.esiEnrollDate = esiEnrollDate;
	}

	public String getEsiNumber() {
		return this.esiNumber;
	}

	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
	}

	public String getIsAiApplicable() {
		return this.isAiApplicable;
	}

	public void setIsAiApplicable(String isAiApplicable) {
		this.isAiApplicable = isAiApplicable;
	}

	public String getIsEsicApplicable() {
		return this.isEsicApplicable;
	}

	public void setIsEsicApplicable(String isEsicApplicable) {
		this.isEsicApplicable = isEsicApplicable;
	}

	public String getIsMiApplicable() {
		return this.isMiApplicable;
	}

	public void setIsMiApplicable(String isMiApplicable) {
		this.isMiApplicable = isMiApplicable;
	}

	public String getIsPfApplicable() {
		return this.isPfApplicable;
	}

	public void setIsPfApplicable(String isPfApplicable) {
		this.isPfApplicable = isPfApplicable;
	}

	public String getMedicalInsurance() {
		return this.medicalInsurance;
	}

	public void setMedicalInsurance(String medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	public Date getMiFromDate() {
		return this.miFromDate;
	}

	public void setMiFromDate(Date miFromDate) {
		this.miFromDate = miFromDate;
	}

	public Date getMiToDate() {
		return this.miToDate;
	}

	public void setMiToDate(Date miToDate) {
		this.miToDate = miToDate;
	}

	public Long getNoticePeriod() {
		return this.noticePeriod;
	}

	public void setNoticePeriod(Long noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public Date getPfEnrollDate() {
		return this.pfEnrollDate;
	}

	public void setPfEnrollDate(Date pfEnrollDate) {
		this.pfEnrollDate = pfEnrollDate;
	}

	public String getPfNumber() {
		return this.pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public Long getProbationDays() {
		return this.probationDays;
	}

	public void setProbationDays(Long probationDays) {
		this.probationDays = probationDays;
	}

	public String getUanNumber() {
		return this.uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}