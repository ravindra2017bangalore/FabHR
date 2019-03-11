package com.csipl.hrms.dto.organisation;

import java.util.Date;

public class ClientDTO {
	private Long clientId;
	private String clientName;
	private AddressDTO address;
	private String concernPerson;
	private String gstNo;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public String getConcernPerson() {
		return concernPerson;
	}
	public void setConcernPerson(String concernPerson) {
		this.concernPerson = concernPerson;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", clientName=" + clientName + ", address=" + address
				+ ", concernPerson=" + concernPerson + ", gstNo=" + gstNo + "]";
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
