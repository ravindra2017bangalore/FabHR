package com.csipl.hrms.dto.organisation;

import java.util.Date;

public class BranchDTO {
	private Long branchId;
	private String branchName;
	private AddressDTO address;
	private Long userId;
	private Date dateCreated; 
	private Long companyId;
	private Long userIdUpdate;
	
	
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Long getUserId() {
		return userId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	 
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	 

}
