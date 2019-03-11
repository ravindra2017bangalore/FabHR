package com.csipl.hrms.dto.candidate;

import com.csipl.hrms.dto.organisation.AddressDTO;

import java.util.Date;
import java.util.List;

public class CandidatePersonalDTO {

	private Long candidatePersonalId;

	private String alternateNumber;

	private Date anniversaryDate;

	private String bloodGroup;

	private Date dateOfBirth;

	private String gender;

	private String maritalStatus;

	private Long candidateId;

	private String referenceName;

	private AddressDTO permanentAddressDto;

	private AddressDTO presentAddressDto;

	private AddressDTO referenceAddressDto;

	private List<CandidateLanguageDTO> candidateLanguageDto;

	private String permanentAddressValue;
	private String presentAddressValue;
	private String referenceAddressValue;
	private String genderValue;
	private String maritalStatusValue;
	private String bloodGroupValue;

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

	public Long getCandidatePersonalId() {
		return this.candidatePersonalId;
	}

	public void setCandidatePersonalId(Long candidatePersonalId) {
		this.candidatePersonalId = candidatePersonalId;
	}

	public String getAlternateNumber() {
		return this.alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public Date getAnniversaryDate() {
		return this.anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public AddressDTO getPermanentAddressDto() {
		return permanentAddressDto;
	}

	public void setPermanentAddressDto(AddressDTO permanentAddressDto) {
		this.permanentAddressDto = permanentAddressDto;
	}

	public AddressDTO getPresentAddressDto() {
		return presentAddressDto;
	}

	public void setPresentAddressDto(AddressDTO presentAddressDto) {
		this.presentAddressDto = presentAddressDto;
	}

	public AddressDTO getReferenceAddressDto() {
		return referenceAddressDto;
	}

	public void setReferenceAddressDto(AddressDTO referenceAddressDto) {
		this.referenceAddressDto = referenceAddressDto;
	}

	public List<CandidateLanguageDTO> getCandidateLanguageDto() {
		return candidateLanguageDto;
	}

	public void setCandidateLanguageDto(List<CandidateLanguageDTO> candidateLanguageDto) {
		this.candidateLanguageDto = candidateLanguageDto;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public String getBloodGroupValue() {
		return bloodGroupValue;
	}

	public void setBloodGroupValue(String bloodGroupValue) {
		this.bloodGroupValue = bloodGroupValue;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
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

}