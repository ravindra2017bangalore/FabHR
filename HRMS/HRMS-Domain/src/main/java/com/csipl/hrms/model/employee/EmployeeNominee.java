package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EmployeeNominee database table.
 * 
 */
@Entity
@NamedQuery(name="EmployeeNominee.findAll", query="SELECT e FROM EmployeeNominee e")
public class EmployeeNominee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeNomineeid;

	private String activeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String staturyHeadId;

	private String staturyHeadName;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to EmployeeFamily
	@ManyToOne
	@JoinColumn(name="familyId")
	private EmployeeFamily employeeFamily;

	public EmployeeNominee() {
	}

	public Long getEmployeeNomineeid() {
		return this.employeeNomineeid;
	}

	public void setEmployeeNomineeid(Long employeeNomineeid) {
		this.employeeNomineeid = employeeNomineeid;
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

	public EmployeeFamily getEmployeeFamily() {
		return this.employeeFamily;
	}

	public void setEmployeeFamily(EmployeeFamily employeeFamily) {
		this.employeeFamily = employeeFamily;
	}

}