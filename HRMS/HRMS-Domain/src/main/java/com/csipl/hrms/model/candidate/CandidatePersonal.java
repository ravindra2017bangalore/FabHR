package com.csipl.hrms.model.candidate;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CandidatePersonal database table.
 * 
 */
@Entity
@NamedQuery(name="CandidatePersonal.findAll", query="SELECT c FROM CandidatePersonal c")
public class CandidatePersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidatePersonalId;

	private String alternateNumber;

	@Temporal(TemporalType.DATE)
	private Date anniversaryDate;

	private String bloodGroup;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String gender;

	private String maritalStatus;

	private String referenceName;

	//bi-directional many-to-one association to CandidateLanguage
	@OneToMany(mappedBy="candidatePersonal",cascade = CascadeType.ALL)
	private List<CandidateLanguage> candidateLanguages;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="candidateId")
	private Candidate candidate;

	//bi-directional many-to-one association to CandidateAddress
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="permanentAddressId")
	private CandidateAddress candidateAddress1;

	//bi-directional many-to-one association to CandidateAddress
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="presentAddressId")
	private CandidateAddress candidateAddress2;

	//bi-directional many-to-one association to CandidateAddress
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="referenceAddressId")
	private CandidateAddress candidateAddress3;

	public CandidatePersonal() {
	}

	public Long getCandidatePersonalId() {
		return this.candidatePersonalId;
	}

	public void setCandidatePersonalId(Long candidatePersonalId) {
		this.candidatePersonalId = candidatePersonalId;
	}

	public String getAlternateNumber() {
		return this.alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public Date getAnniversaryDate() {
		return this.anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getReferenceName() {
		return this.referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public List<CandidateLanguage> getCandidateLanguages() {
		return this.candidateLanguages;
	}

	public void setCandidateLanguages(List<CandidateLanguage> candidateLanguages) {
		this.candidateLanguages = candidateLanguages;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public CandidateAddress getCandidateAddress1() {
		return this.candidateAddress1;
	}

	public void setCandidateAddress1(CandidateAddress candidateAddress1) {
		this.candidateAddress1 = candidateAddress1;
	}

	public CandidateAddress getCandidateAddress2() {
		return this.candidateAddress2;
	}

	public void setCandidateAddress2(CandidateAddress candidateAddress2) {
		this.candidateAddress2 = candidateAddress2;
	}

	public CandidateAddress getCandidateAddress3() {
		return this.candidateAddress3;
	}

	public void setCandidateAddress3(CandidateAddress candidateAddress3) {
		this.candidateAddress3 = candidateAddress3;
	}

}