package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CandidateIdProofs database table.
 * 
 */
@Entity
@Table(name="CandidateIdProofs")
@NamedQuery(name="CandidateIdProof.findAll", query="SELECT c FROM CandidateIdProof c")
public class CandidateIdProof implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateIdProofsId;

	private String activeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	private Date dateIssue;

	@Temporal(TemporalType.DATE)
	private Date dateTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String idNumber;

	private String idTypeId;

	private Long userId;

	private Long userIdUpdate;

	private String idProofDoc;
	
	private String documentName;
	
	@Transient
	private int docIndex;
	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="candidateId")
	private Candidate candidate;

	public CandidateIdProof() {
	}

	public Long getCandidateIdProofsId() {
		return this.candidateIdProofsId;
	}

	public void setCandidateIdProofsId(Long candidateIdProofsId) {
		this.candidateIdProofsId = candidateIdProofsId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateIssue() {
		return this.dateIssue;
	}

	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdTypeId() {
		return this.idTypeId;
	}

	public void setIdTypeId(String idTypeId) {
		this.idTypeId = idTypeId;
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

	public String getIdProofDoc() {
		return idProofDoc;
	}

	public void setIdProofDoc(String idProofDoc) {
		this.idProofDoc = idProofDoc;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public int getDocIndex() {
		return docIndex;
	}

	public void setDocIndex(int docIndex) {
		this.docIndex = docIndex;
	}

	

}
