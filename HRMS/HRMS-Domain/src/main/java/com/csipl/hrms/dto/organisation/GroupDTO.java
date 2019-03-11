package com.csipl.hrms.dto.organisation;

import java.util.Date;

public class GroupDTO {
	private Long groupId;
	private String groupName;
	private AddressDTO address;
	private String groupAbbrebiation;
	private Date dateOfBirth;
	private String groupLogoPath;
	private Long userId;
	private Date dateCreated;
	private Long userIdUpdate;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public String getGroupAbbrebiation() {
		return groupAbbrebiation;
	}
	public void setGroupAbbrebiation(String groupAbbrebiation) {
		this.groupAbbrebiation = groupAbbrebiation;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGroupLogoPath() {
		return groupLogoPath;
	}
	public void setGroupLogoPath(String groupLogoPath) {
		this.groupLogoPath = groupLogoPath;
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
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
}
