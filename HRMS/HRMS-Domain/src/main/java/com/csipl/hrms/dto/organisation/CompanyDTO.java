package com.csipl.hrms.dto.organisation;

import java.util.Date;


public class CompanyDTO {
	private String companyName;
	private Long companyId;
	private GroupDTO groupg;
	private Long groupId;
	private String groupName;
	private AddressDTO address1;
	private AddressDTO address2;
	private Long retirementAge;
	private String panNo;
	private String registrationNo;
	private String epfNo;
	private String esicNo;
	private String gstNo;
	private Long userId;
	private Date dateCreated;
	private Long userIdUpdate;
	private String domainName;
	//private String typeOfIndustry;
	private Date dateOfBirth;
	//private byte[] companyLogo;
	private String companyLogoPath;

	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public GroupDTO getGroupg() {
		return groupg;
	}
	public void setGroupg(GroupDTO groupg) {
		this.groupg = groupg;
	}
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
	public AddressDTO getAddress1() {
		return address1;
	}
	public void setAddress1(AddressDTO address1) {
		this.address1 = address1;
	}
	public AddressDTO getAddress2() {
		return address2;
	}
	public void setAddress2(AddressDTO address2) {
		this.address2 = address2;
	}
	public Long getRetirementAge() {
		return retirementAge;
	}
	public void setRetirementAge(Long retirementAge) {
		this.retirementAge = retirementAge;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getEpfNo() {
		return epfNo;
	}
	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}
	public String getEsicNo() {
		return esicNo;
	}
	public void setEsicNo(String esicNo) {
		this.esicNo = esicNo;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	/*public String getTypeOfIndustry() {
		return typeOfIndustry;
	}
	public void setTypeOfIndustry(String typeOfIndustry) {
		this.typeOfIndustry = typeOfIndustry;
	}*/
	public Date getDateOfBirth() {
		return dateOfBirth;
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
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCompanyLogoPath() {
		return companyLogoPath;
	}
	public void setCompanyLogoPath(String companyLogoPath) {
		this.companyLogoPath = companyLogoPath;
	}
	/*public byte[] getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}*/
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
}
