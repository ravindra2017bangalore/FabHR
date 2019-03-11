package com.csipl.tms.model.attendanceregularizationrequest;

import java.io.Serializable;
import javax.persistence.*;

/*import com.csipl.hrms.common.model.Company;
import com.csipl.hrms.common.model.Employee;*/

import java.util.Date;

/**
 * The persistent class for the AttendanceRegularizationRequest database table.
 * 
 */
@Entity
@Table(name = "TMSARRequest")
@NamedQuery(name = "AttendanceRegularizationRequest.findAll", query = "SELECT a FROM AttendanceRegularizationRequest a")
public class AttendanceRegularizationRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long arID;

	private String approvalRemark;

	private String arCategory;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private Long days;

	private String employeeRemark;

	@Transient
	private String employeeCode;

	@Temporal(TemporalType.DATE)
	private Date fromDate;

	private String status;

	@Temporal(TemporalType.DATE)
	private Date toDate;

	@Temporal(TemporalType.DATE)
	private Date actionableDate;

	private Long userId;

	private Long userIdUpdate;

	// bi-directional many-to-one association to Employee
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "employeeId") private Employee requestByemployee;
	 */

	private Long employeeId;

	// bi-directional many-to-one association to Employee
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "approvalId") private Employee approvalByemployee;
	 */

	private Long approvalId;

	// bi-directional many-to-one association to Company
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "companyId") private Company company;
	 */

	private Long companyId;
	
	private String cancelRemark;

	public AttendanceRegularizationRequest() {
	}

	public Long getArID() {
		return this.arID;
	}

	public void setArID(Long arID) {
		this.arID = arID;
	}

	public String getApprovalRemark() {
		return this.approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	public String getArCategory() {
		return this.arCategory;
	}

	public void setArCategory(String arCategory) {
		this.arCategory = arCategory;
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

	public Long getDays() {
		return this.days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public String getEmployeeRemark() {
		return this.employeeRemark;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setEmployeeRemark(String employeeRemark) {
		this.employeeRemark = employeeRemark;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
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

	public Date getActionableDate() {
		return actionableDate;
	}

	public void setActionableDate(Date actionableDate) {
		this.actionableDate = actionableDate;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "AttendanceRegularizationRequest [arID=" + arID + ", approvalRemark=" + approvalRemark + ", arCategory="
				+ arCategory + ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate + ", days=" + days
				+ ", employeeRemark=" + employeeRemark + ", fromDate=" + fromDate + ", status=" + status + ", toDate="
				+ toDate + ", actionableDate=" + actionableDate + ", userId=" + userId + ", userIdUpdate="
				+ userIdUpdate + ", employeeId=" + employeeId + ", approvalId=" + approvalId + ", companyId="
				+ companyId + "]";
	}

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}

	/*
	 * public Company getCompany() { return this.company; }
	 * 
	 * public Employee getApprovalByemployee() { return approvalByemployee; }
	 * 
	 * public void setApprovalByemployee(Employee approvalByemployee) {
	 * this.approvalByemployee = approvalByemployee; }
	 * 
	 * public void setCompany(Company company) { this.company = company; }
	 * 
	 * public Employee getRequestByemployee() { return requestByemployee; }
	 * 
	 * public void setRequestByemployee(Employee requestByemployee) {
	 * this.requestByemployee = requestByemployee; }
	 */

}