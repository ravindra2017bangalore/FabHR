package com.csipl.hrms.dto.employee;

import java.util.Date;

public class EmployeeIdProofDTO {

	private Long employeeIdProofsId;
	private Long userId;
	private Date dateCreated;
	private Long CompanyId;
	private Long userIdUpdate;
	
	public Long getCompanyId() {
		return CompanyId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public void setCompanyId(Long companyId) {
		CompanyId = companyId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getEmployeeIdProofsId() {
		return employeeIdProofsId;
	}

	public void setEmployeeIdProofsId(Long employeeIdProofsId) {
		this.employeeIdProofsId = employeeIdProofsId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdTypeId() {
		return idTypeId;
	}

	public void setIdTypeId(String idTypeId) {
		this.idTypeId = idTypeId;
	}

	private String activeStatus;

	private String dateFrom;
	
	private String dateTo;
	
	private String idNumber;

	private String idTypeId;

}



