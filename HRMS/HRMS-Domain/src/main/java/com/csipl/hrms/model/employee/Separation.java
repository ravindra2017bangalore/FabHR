package com.csipl.hrms.model.employee;
 
import java.io.Serializable;
import javax.persistence.*;

 import com.csipl.hrms.model.BaseModelWithoutGroup;

import java.util.Date;


/**
 * The persistent class for the Separation database table.
 * 
 */
@Entity
@Table(name="Separation")
@NamedQuery(name="Separation.findAll", query="SELECT s FROM Separation s")
public class Separation extends BaseModelWithoutGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long separationId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String resoan;

	private String status; 
	
	private String remark;
 	
	private Long userId;

	private Long userIdUpdate;
	
	private Long replacementEmployeeId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="approvalId")
	private Employee employee2;

	public Separation() {
	}

	public Long getSeparationId() {
		return this.separationId;
	}

	public void setSeparationId(Long separationId) {
		this.separationId = separationId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getResoan() {
		return this.resoan;
	}

	public void setResoan(String resoan) {
		this.resoan = resoan;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

	public Long getReplacementEmployeeId() {
		return replacementEmployeeId;
	}

	public void setReplacementEmployeeId(Long replacementEmployeeId) {
		this.replacementEmployeeId = replacementEmployeeId;
	}

	@Override
	public String toString() {
		return "Separation [separationId=" + separationId + ", dateCreated=" + dateCreated + ", dateUpdate="
				+ dateUpdate + ", description=" + description + ", endDate=" + endDate + ", resoan=" + resoan
				+ ", status=" + status + ", remark=" + remark + ", userId=" + userId + ", userIdUpdate=" + userIdUpdate
				+ ", replacementEmployeeId=" + replacementEmployeeId + ", employee1=" + employee1 + ", employee2="
				+ employee2 + "]";
	}

}