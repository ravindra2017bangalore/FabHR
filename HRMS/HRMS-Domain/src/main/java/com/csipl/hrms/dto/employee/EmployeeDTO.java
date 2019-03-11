package com.csipl.hrms.dto.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.AddressDTO;

public class EmployeeDTO implements Comparable<EmployeeDTO> {
	private List<EmployeeDTO> employessList;
	private boolean newSkillValues;
	private Integer index;
	private List<Long> employeeSkills = new ArrayList<Long>();
	private List<EmployeeSkillDTO> employeeSkillArray;
	private String gradeName;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private String employeeCode;
	private Long employeeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String maritalStatus;
	private AddressDTO address1;
	private AddressDTO address2;
	private Date anniversaryDate;
	private String bloodGroup;
	private Long probationDays;
	private String empType;
	private Long departmentId;
	private String departmentName;
	private Long designationId;
	private String designationName;
	private Long projectId;
	private String projectName;
	private Long clientId;
	private String clientName;
	private Long reportingToEmployee;
	private Date contractOverDate;
	private String referenceName;
	private AddressDTO address3;
	private Date dateOfJoining;
	private String activeStatus;
	private String employeeLogoPath;
	private Long noticePeriodDays;
	private Long userId;
	private Long payStructureHdId;
	private String voluntaryPfContribution;
	private String accountNumber;
	private String bankId;
	private String aadharNumber;
	private String uanNumber;
	private Long companyId;
	private Long groupId;
	private List<PayStructureHdDTO> payStructureHds;
	private List<BankDetailsDTO> employeeBanks;
	private List<EmployeeIdProofDTO> employeeIdProofs;
	private List<EmployeeStatuaryDTO> employeeStatuaries;
	private String totalExperience;
	private String noticeDate;
	private Date dateCreated;
	private Date contractStartDate;
	private String pan;
 	private String empPFNumber;
 	private String empESINumber;
 	
 	private String accountType  ;
 	private String ifscCode ;
 	
 	private String basicSalary;
 	private String dearnessAllowance;
 	private String houseRentAllowance;
 	private String conveyanceAllowance;
 	private String specialAllowance;
 	private String medicalAllowance;
 	private String advanceBonus;
 	private String performanceLinkedIncome;
 	private String companyBenefits;
 	private String leaveTravelAllowance;
 	private String uniformAllowance;
 	private Date endDate;
 	private Long userIdUpdate;
 	private String reportingEmployeeFirstName;
 	private String reportingEmployeeLastName;
 	private String charFirstName;
 	private String charLastName;
 	private String fullNameCodeVaues;

 	
 	
	public String getCharFirstName() {
		return charFirstName;
	}

	public void setCharFirstName(String charFirstName) {
		this.charFirstName = charFirstName;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}


	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getEmployeeCode() {

		return employeeCode;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public String getEmpType() {
		return empType;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public Long getClientId() {
		return clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public Long getReportingToEmployee() {
		return reportingToEmployee;
	}

	public Date getContractOverDate() {
		return contractOverDate;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public String getEmployeeLogoPath() {
		return employeeLogoPath;
	}

	public void setEmployeeLogoPath(String employeeLogoPath) {
		this.employeeLogoPath = employeeLogoPath;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setReportingToEmployee(Long reportingToEmployee) {
		this.reportingToEmployee = reportingToEmployee;
	}

	public void setContractOverDate(Date contractOverDate) {
		this.contractOverDate = contractOverDate;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public Long getProbationDays() {
		return probationDays;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public void setProbationDays(Long probationDays) {
		this.probationDays = probationDays;
	}

	public AddressDTO getAddress1() {
		return address1;
	}

	public AddressDTO getAddress2() {
		return address2;
	}

	public AddressDTO getAddress3() {
		return address3;
	}

	public void setAddress1(AddressDTO address1) {
		this.address1 = address1;
	}

	public void setAddress2(AddressDTO address2) {
		this.address2 = address2;
	}

	public void setAddress3(AddressDTO address3) {
		this.address3 = address3;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public Long getNoticePeriodDays() {
		return noticePeriodDays;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setNoticePeriodDays(Long noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}

	public List<EmployeeSkillDTO> getEmployeeSkillArray() {
		return employeeSkillArray;
	}

	public void setEmployeeSkillArray(List<EmployeeSkillDTO> employeeSkillArray) {
		this.employeeSkillArray = employeeSkillArray;
	}

	public boolean isNewSkillValues() {
		return newSkillValues;
	}

	public void setNewSkillValues(boolean newSkillValues) {
		this.newSkillValues = newSkillValues;
	}

	public List<Long> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(List<Long> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVoluntaryPfContribution() {
		return voluntaryPfContribution;
	}

	public void setVoluntaryPfContribution(String voluntaryPfContribution) {
		this.voluntaryPfContribution = voluntaryPfContribution;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getPayStructureHdId() {
		return payStructureHdId;
	}

	public void setPayStructureHdId(Long payStructureHdId) {
		this.payStructureHdId = payStructureHdId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}



	public String getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public List<PayStructureHdDTO> getPayStructureHds() {
		return payStructureHds;
	}

	public void setPayStructureHds(List<PayStructureHdDTO> payStructureHds) {
		this.payStructureHds = payStructureHds;
	}

	public List<BankDetailsDTO> getEmployeeBanks() {
		return employeeBanks;
	}

	public void setEmployeeBanks(List<BankDetailsDTO> employeeBanks) {
		this.employeeBanks = employeeBanks;
	}

	public List<EmployeeIdProofDTO> getEmployeeIdProofs() {
		return employeeIdProofs;
	}

	public void setEmployeeIdProofs(List<EmployeeIdProofDTO> employeeIdProofs) {
		this.employeeIdProofs = employeeIdProofs;
	}

	public List<EmployeeStatuaryDTO> getEmployeeStatuaries() {
		return employeeStatuaries;
	}

	public void setEmployeeStatuaries(List<EmployeeStatuaryDTO> employeeStatuaries) {
		this.employeeStatuaries = employeeStatuaries;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

 

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPan() {
		return pan;
	}

	 
	public void setPan(String pan) {
		this.pan = pan;
	}

 
	public String getEmpPFNumber() {
		return empPFNumber;
	}

	 
	public String getEmpESINumber() {
		return empESINumber;
	}

	public void setEmpPFNumber(String empPFNumber) {
		this.empPFNumber = empPFNumber;
	}

	 
	public void setEmpESINumber(String empESINumber) {
		this.empESINumber = empESINumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public String getDearnessAllowance() {
		return dearnessAllowance;
	}

	public String getHouseRentAllowance() {
		return houseRentAllowance;
	}

	public String getConveyanceAllowance() {
		return conveyanceAllowance;
	}

	public String getSpecialAllowance() {
		return specialAllowance;
	}

	public String getMedicalAllowance() {
		return medicalAllowance;
	}

	public String getAdvanceBonus() {
		return advanceBonus;
	}

	public String getPerformanceLinkedIncome() {
		return performanceLinkedIncome;
	}

	public String getCompanyBenefits() {
		return companyBenefits;
	}

	public String getLeaveTravelAllowance() {
		return leaveTravelAllowance;
	}

	public String getUniformAllowance() {
		return uniformAllowance;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setDearnessAllowance(String dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public void setHouseRentAllowance(String houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}

	public void setConveyanceAllowance(String conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}

	public void setSpecialAllowance(String specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public void setMedicalAllowance(String medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public void setAdvanceBonus(String advanceBonus) {
		this.advanceBonus = advanceBonus;
	}

	public void setPerformanceLinkedIncome(String performanceLinkedIncome) {
		this.performanceLinkedIncome = performanceLinkedIncome;
	}

	public void setCompanyBenefits(String companyBenefits) {
		this.companyBenefits = companyBenefits;
	}

	public void setLeaveTravelAllowance(String leaveTravelAllowance) {
		this.leaveTravelAllowance = leaveTravelAllowance;
	}

	public void setUniformAllowance(String uniformAllowance) {
		this.uniformAllowance = uniformAllowance;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public int compareTo(EmployeeDTO dto ) {
		if ( dto.getIndex() < this.getIndex() ) {
			return 1;
		} else {
			return -1;
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [newSkillValues=" + newSkillValues + ", index=" + index + ", employeeSkills="
				+ employeeSkills + ", employeeSkillArray=" + employeeSkillArray + ", gradeName=" + gradeName
				+ ", cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + ", stateName=" + stateName
				+ ", employeeCode=" + employeeCode + ", employeeId=" + employeeId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", maritalStatus=" + maritalStatus + ", address1=" + address1 + ", address2=" + address2
				+ ", anniversaryDate=" + anniversaryDate + ", bloodGroup=" + bloodGroup + ", probationDays="
				+ probationDays + ", empType=" + empType + ", departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", designationId=" + designationId + ", designationName=" + designationName
				+ ", projectId=" + projectId + ", projectName=" + projectName + ", clientId=" + clientId
				+ ", clientName=" + clientName + ", reportingToEmployee=" + reportingToEmployee + ", contractOverDate="
				+ contractOverDate + ", referenceName=" + referenceName + ", address3=" + address3 + ", dateOfJoining="
				+ dateOfJoining + ", activeStatus=" + activeStatus + ", employeeLogoPath=" + employeeLogoPath
				+ ", noticePeriodDays=" + noticePeriodDays + ", userId=" + userId + ", payStructureHdId="
				+ payStructureHdId + ", voluntaryPfContribution=" + voluntaryPfContribution + ", accountNumber="
				+ accountNumber + ", bankId=" + bankId + ", aadharNumber=" + aadharNumber + ", uanNumber=" + uanNumber
				+ ", companyId=" + companyId + ", groupId=" + groupId + ", payStructureHds=" + payStructureHds
				+ ", employeeBanks=" + employeeBanks + ", employeeIdProofs=" + employeeIdProofs
				+ ", employeeStatuaries=" + employeeStatuaries + ", totalExperience=" + totalExperience
				+ ", noticeDate=" + noticeDate + ", dateCreated=" + dateCreated + ", contractStartDate="
				+ contractStartDate + ", pan=" + pan + ", empPFNumber=" + empPFNumber + ", empESINumber=" + empESINumber
				+ ", accountType=" + accountType + ", ifscCode=" + ifscCode + ", basicSalary=" + basicSalary
				+ ", dearnessAllowance=" + dearnessAllowance + ", houseRentAllowance=" + houseRentAllowance
				+ ", conveyanceAllowance=" + conveyanceAllowance + ", specialAllowance=" + specialAllowance
				+ ", medicalAllowance=" + medicalAllowance + ", advanceBonus=" + advanceBonus
				+ ", performanceLinkedIncome=" + performanceLinkedIncome + ", companyBenefits=" + companyBenefits
				+ ", leaveTravelAllowance=" + leaveTravelAllowance + ", uniformAllowance=" + uniformAllowance
				+ ", endDate=" + endDate + ", userIdUpdate=" + userIdUpdate + "]";
	}

	public List<EmployeeDTO> getEmployessList() {
		return employessList;
	}

	public void setEmployessList(List<EmployeeDTO> employessList) {
		this.employessList = employessList;
	}

	public String getReportingEmployeeFirstName() {
		return reportingEmployeeFirstName;
	}

	public void setReportingEmployeeFirstName(String reportingEmployeeFirstName) {
		this.reportingEmployeeFirstName = reportingEmployeeFirstName;
	}

	public String getReportingEmployeeLastName() {
		return reportingEmployeeLastName;
	}

	public void setReportingEmployeeLastName(String reportingEmployeeLastName) {
		this.reportingEmployeeLastName = reportingEmployeeLastName;
	}

	public String getCharLastName() {
		return charLastName;
	}

	public void setCharLastName(String charLastName) {
		this.charLastName = charLastName;
	}

	public String getFullNameCodeVaues() {
		return fullNameCodeVaues;
	}

	public void setFullNameCodeVaues(String fullNameCodeVaues) {
		this.fullNameCodeVaues = fullNameCodeVaues;
	}

	

	 
}
