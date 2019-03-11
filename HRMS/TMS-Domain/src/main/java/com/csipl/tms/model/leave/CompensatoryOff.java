package com.csipl.tms.model.leave;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "TMSCompensantoryOff")
@NamedQuery(name="CompensatoryOff.findAll", query="SELECT t FROM CompensatoryOff t")
public class CompensatoryOff implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tmsCompensantoryOffId;

	private Long approvalId;

	private String approvalRemark;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long employeeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;

	private Long leaveTypeId;

	private String remark;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;

	private Long userId;

	private Long userIdUpdate;
	private Long companyId;
    private String cancelRemark;
//	public TMSCompensantoryOff() {
//	}

	public Long getTmsCompensantoryOffId() {
		return this.tmsCompensantoryOffId;
	}

	public void setTmsCompensantoryOffId(Long tmsCompensantoryOffId) {
		this.tmsCompensantoryOffId = tmsCompensantoryOffId;
	}

	public Long getApprovalId() {
		return this.approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalRemark() {
		return this.approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
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

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Long getLeaveTypeId() {
		return this.leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}
}
