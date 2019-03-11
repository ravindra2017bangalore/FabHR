package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;


@Entity
@NamedQuery(name="CandidateEducation.findAll", query="SELECT c FROM CandidateEducation c")
public class CandidateEducation implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long educationId;

	private String activeStatus;

	private Long candidateId;

	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String degreeName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveStartDate;

	private BigDecimal marksPer;

	private String nameOfBoard;

	private String nameOfInstitution;

	private Long passingYear;

	private String qualificationId;

	private String regularCorrespondance;

	private Long userId;

	private Long userIdUpdate;
	
	@Transient
	private Long docIndex;
	
	private String documentName;
	
	private String candidateEducationDoc;

	public CandidateEducation() {
	}

	public Long getEducationId() {
		return this.educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
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

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public BigDecimal getMarksPer() {
		return this.marksPer;
	}

	public void setMarksPer(BigDecimal marksPer) {
		this.marksPer = marksPer;
	}

	public String getNameOfBoard() {
		return this.nameOfBoard;
	}

	public void setNameOfBoard(String nameOfBoard) {
		this.nameOfBoard = nameOfBoard;
	}

	public String getNameOfInstitution() {
		return this.nameOfInstitution;
	}

	public void setNameOfInstitution(String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
	}

	public Long getPassingYear() {
		return this.passingYear;
	}

	public void setPassingYear(Long passingYear) {
		this.passingYear = passingYear;
	}

	public String getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getRegularCorrespondance() {
		return this.regularCorrespondance;
	}

	public void setRegularCorrespondance(String regularCorrespondance) {
		this.regularCorrespondance = regularCorrespondance;
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

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getCandidateEducationDoc() {
		return candidateEducationDoc;
	}

	public void setCandidateEducationDoc(String candidateEducationDoc) {
		this.candidateEducationDoc = candidateEducationDoc;
	}

	public Long getDocIndex() {
		return docIndex;
	}

	public void setDocIndex(Long docIndex) {
		this.docIndex = docIndex;
	}

}
