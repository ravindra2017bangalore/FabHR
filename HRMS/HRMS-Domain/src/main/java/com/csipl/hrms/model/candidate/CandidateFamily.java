package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CandidateFamily database table.
 * 
 */
@Entity
@NamedQuery(name="CandidateFamily.findAll", query="SELECT c FROM CandidateFamily c")
public class CandidateFamily implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familyId;

	private Long candidateId;

	private String captions;

	private Long companyId;

	private String contactMobile;

	private String contactPhone;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String name;

	private String occupations;

	private String qualificationId;

	private String relation;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to CandidateNominee
	@OneToMany(mappedBy="candidateFamily", cascade = CascadeType.ALL)
	private List<CandidateNominee> candidateNominees;

	public CandidateFamily() {
	}

	public Long getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getCaptions() {
		return this.captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupations() {
		return this.occupations;
	}

	public void setOccupations(String occupations) {
		this.occupations = occupations;
	}

	public String getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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

	public List<CandidateNominee> getCandidateNominees() {
		return this.candidateNominees;
	}

	public void setCandidateNominees(List<CandidateNominee> candidateNominees) {
		this.candidateNominees = candidateNominees;
	}

	public CandidateNominee addCandidateNominee(CandidateNominee candidateNominee) {
		getCandidateNominees().add(candidateNominee);
		candidateNominee.setCandidateFamily(this);

		return candidateNominee;
	}

	public CandidateNominee removeCandidateNominee(CandidateNominee candidateNominee) {
		getCandidateNominees().remove(candidateNominee);
		candidateNominee.setCandidateFamily(null);

		return candidateNominee;
	}

}