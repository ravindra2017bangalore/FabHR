package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.organisation.Department;

import java.util.Date;


/**
 * The persistent class for the Skills database table.
 * 
 */
@Entity
@Table(name="Skills")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long skillId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
		
	private String skillName;

	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	public Skill() {
	}

	public Long getSkillId() {
		return this.skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}