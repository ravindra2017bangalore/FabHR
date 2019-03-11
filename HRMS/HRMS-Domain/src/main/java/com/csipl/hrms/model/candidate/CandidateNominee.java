package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CandidateNominee database table.
 * 
 */
@Entity
@NamedQuery(name="CandidateNominee.findAll", query="SELECT c FROM CandidateNominee c")
public class CandidateNominee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateNomineeid;

	private String activeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String staturyHeadId;

	private String staturyHeadName;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to CandidateFamily
	@ManyToOne
	@JoinColumn(name="familyId")
	private CandidateFamily candidateFamily;

	public CandidateNominee() {
	}

	public Long getCandidateNomineeid() {
		return this.candidateNomineeid;
	}

	public void setCandidateNomineeid(Long candidateNomineeid) {
		this.candidateNomineeid = candidateNomineeid;
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

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getStaturyHeadId() {
		return this.staturyHeadId;
	}

	public void setStaturyHeadId(String staturyHeadId) {
		this.staturyHeadId = staturyHeadId;
	}

	public String getStaturyHeadName() {
		return this.staturyHeadName;
	}

	public void setStaturyHeadName(String staturyHeadName) {
		this.staturyHeadName = staturyHeadName;
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

	public CandidateFamily getCandidateFamily() {
		return this.candidateFamily;
	}

	public void setCandidateFamily(CandidateFamily candidateFamily) {
		this.candidateFamily = candidateFamily;
	}

}