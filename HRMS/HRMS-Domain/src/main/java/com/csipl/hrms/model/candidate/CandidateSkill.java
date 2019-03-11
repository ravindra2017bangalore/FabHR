package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Skill;

import java.util.Date;


/**
 * The persistent class for the CandidateSkills database table.
 * 
 */
@Entity
@Table(name="CandidateSkills")
@NamedQuery(name="CandidateSkill.findAll", query="SELECT c FROM CandidateSkill c")
public class CandidateSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateSkillsId;

	private String activeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="skillId")
	private Skill skill;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="candidateId")
	private Candidate candidate;

	public CandidateSkill() {
	}

	public Long getCandidateSkillsId() {
		return this.candidateSkillsId;
	}

	public void setCandidateSkillsId(Long candidateSkillsId) {
		this.candidateSkillsId = candidateSkillsId;
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

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}