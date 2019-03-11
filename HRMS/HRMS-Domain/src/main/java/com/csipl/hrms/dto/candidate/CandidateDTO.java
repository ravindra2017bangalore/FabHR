package com.csipl.hrms.dto.candidate;

import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.AddressDTO;

public class CandidateDTO {
	private Long candidateId;

	private String firstName;

	private String middleName;

	private String lastName;
	private Long departmentId;
	private Long designationId;
	private String activeStatus;
	private String adharNumber;
	private String candidateCode;

 	private Date anniversaryDate;

	private String bloodGroup;

	private String candidateStatus;

	private Long cityId;

	private Long companyId;

 	private Date contractOverDate;

 	private Date contractStartDate;

 	private Date dateCreated;

 	private Date dateOfBirth;

 	private Date dateOfJoining;

	private String emailId;

	private String candidateLogoPath;

	private String empType;

	private String gender;
	private String genderValue;

	private Long languageId;

	private String maritalStatus;
	private String maritalStatusValue;

	private String mobile;

	private Long noticePeriodDays;

	private Long patternId;

	private Long permanentAddressId;

	private Long presentAddressId;

	private Long referenceAddressId;

	private AddressDTO permanentAddressDto;
	private  AddressDTO referenceAddressDto;
	private AddressDTO presentAddressDto;
	private String charFirstName;
	private String charLastName;
	private String departmentName;
	private String designationName;
	private String timeContractValue;
	private String shiftName;
	private String patternName;

	private String permanentAddressValue;
	private String presentAddressValue;
	private String referenceAddressValue;
	private String reportingToemployeeName;
	private String reportingToemployeeDesignation;
	
	private String alternateNumber;
	private String bloodGroupValue;
	private List<CandidateLanguageDTO> candidateLanguageDto;
	
	public List<CandidateLanguageDTO> getCandidateLanguageDto() {
		return candidateLanguageDto;
	}

	public void setCandidateLanguageDto(List<CandidateLanguageDTO> candidateLanguageDto) {
		this.candidateLanguageDto = candidateLanguageDto;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	
	private String timeContract;

	private String referenceName;

	private String candidateReson;

 	private String reportingToEmployee;

	private Long shiftId;

	private Long userId;

	private Long userIdUpdate;

	private byte checkApproach;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getCandidateStatus() {
		return candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getTimeContract() {
		return timeContract;
	}

	public String getCandidateReson() {
		return candidateReson;
	}

	public void setCandidateReson(String candidateReson) {
		this.candidateReson = candidateReson;
	}

	public String getBloodGroupValue() {
		return bloodGroupValue;
	}

	public void setBloodGroupValue(String bloodGroupValue) {
		this.bloodGroupValue = bloodGroupValue;
	}

	public void setTimeContract(String timeContract) {
		this.timeContract = timeContract;
	}

	public Date getContractOverDate() {
		return contractOverDate;
	}

	public void setContractOverDate(Date contractOverDate) {
		this.contractOverDate = contractOverDate;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCandidateLogoPath() {
		return candidateLogoPath;
	}

	public void setCandidateLogoPath(String candidateLogoPath) {
		this.candidateLogoPath = candidateLogoPath;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTimeContractValue() {
		return timeContractValue;
	}

	public void setTimeContractValue(String timeContractValue) {
		this.timeContractValue = timeContractValue;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getNoticePeriodDays() {
		return noticePeriodDays;
	}

	public void setNoticePeriodDays(Long noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}

	public Long getPatternId() {
		return patternId;
	}

	public void setPatternId(Long patternId) {
		this.patternId = patternId;
	}

	public Long getPermanentAddressId() {
		return permanentAddressId;
	}

	public void setPermanentAddressId(Long permanentAddressId) {
		this.permanentAddressId = permanentAddressId;
	}

	public Long getPresentAddressId() {
		return presentAddressId;
	}

	public void setPresentAddressId(Long presentAddressId) {
		this.presentAddressId = presentAddressId;
	}

	public Long getReferenceAddressId() {
		return referenceAddressId;
	}

	public void setReferenceAddressId(Long referenceAddressId) {
		this.referenceAddressId = referenceAddressId;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getReportingToEmployee() {
		return reportingToEmployee;
	}

	public void setReportingToEmployee(String reportingToEmployee) {
		this.reportingToEmployee = reportingToEmployee;
	}

	public Long getShiftId() {
		return shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public byte getCheckApproach() {
		return checkApproach;
	}

	public void setCheckApproach(byte checkApproach) {
		this.checkApproach = checkApproach;
	}

	public String getCharFirstName() {
		return charFirstName;
	}

	public void setCharFirstName(String charFirstName) {
		this.charFirstName = charFirstName;
	}

	public String getCharLastName() {
		return charLastName;
	}

	public void setCharLastName(String charLastName) {
		this.charLastName = charLastName;
	}

	public String getGenderValue() {
		return genderValue;
	}

	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}

	public String getMaritalStatusValue() {
		return maritalStatusValue;
	}

	public void setMaritalStatusValue(String maritalStatusValue) {
		this.maritalStatusValue = maritalStatusValue;
	}

	public String getReportingToemployeeName() {
		return reportingToemployeeName;
	}

	public void setReportingToemployeeName(String reportingToemployeeName) {
		this.reportingToemployeeName = reportingToemployeeName;
	}

	public String getCandidateCode() {
		return candidateCode;
	}

	public void setCandidateCode(String candidateCode) {
		this.candidateCode = candidateCode;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getPermanentAddressValue() {
		return permanentAddressValue;
	}

	public void setPermanentAddressValue(String permanentAddressValue) {
		this.permanentAddressValue = permanentAddressValue;
	}

	public String getPresentAddressValue() {
		return presentAddressValue;
	}

	public void setPresentAddressValue(String presentAddressValue) {
		this.presentAddressValue = presentAddressValue;
	}

	public String getReferenceAddressValue() {
		return referenceAddressValue;
	}

	public void setReferenceAddressValue(String referenceAddressValue) {
		this.referenceAddressValue = referenceAddressValue;
	}

	public String getReportingToemployeeDesignation() {
		return reportingToemployeeDesignation;
	}

	public void setReportingToemployeeDesignation(String reportingToemployeeDesignation) {
		this.reportingToemployeeDesignation = reportingToemployeeDesignation;
	}

	public AddressDTO getPermanentAddressDto() {
		return permanentAddressDto;
	}

	public void setPermanentAddressDto(AddressDTO permanentAddressDto) {
		this.permanentAddressDto = permanentAddressDto;
	}

	public AddressDTO getReferenceAddressDto() {
		return referenceAddressDto;
	}

	public void setReferenceAddressDto(AddressDTO referenceAddressDto) {
		this.referenceAddressDto = referenceAddressDto;
	}

	public AddressDTO getPresentAddressDto() {
		return presentAddressDto;
	}

	public void setPresentAddressDto(AddressDTO presentAddressDto) {
		this.presentAddressDto = presentAddressDto;
	}

	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}

}