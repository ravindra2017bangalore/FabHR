package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;
  import java.util.Date;


/**
 * The persistent class for the EmployeeSkills database table.
 * 
 */
@Entity
@Table(name="EmployeeSkills")
@NamedQuery(name="EmployeeSkill.findAll", query="SELECT e FROM EmployeeSkill e")
public class EmployeeSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long employeeSkillsId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="skillId")
	private Skill skill;

	public EmployeeSkill() {
	}

	public Long getEmployeeSkillsId() {
		return this.employeeSkillsId;
	}

	public void setEmployeeSkillsId(Long employeeSkillsId) {
		this.employeeSkillsId = employeeSkillsId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "EmployeeSkill [employeeSkillsId=" + employeeSkillsId + ", activeStatus=" + activeStatus + ", allowModi="
				+ allowModi + ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate + ", userId=" + userId
				+ ", userIdUpdate=" + userIdUpdate + ", employee=" + employee + ", skill=" + skill + "]";
	}

}