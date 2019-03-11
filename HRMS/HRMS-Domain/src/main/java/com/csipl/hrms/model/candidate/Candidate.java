package com.csipl.hrms.model.candidate;


import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.Address;
import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.model.organisation.Project;

import java.util.Date;


/**
 * The persistent class for the Candidate database table.
 * 
 */
@Entity
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateId;

	private String activeStatus;
	private String candidateCode;


	private String adharNumber;

	private String allowModi;

	@Temporal(TemporalType.DATE)
	private Date anniversaryDate;

	private String bloodGroup;

	private String candidateStatus;

	private Long cityId;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date contractOverDate;

	@Temporal(TemporalType.DATE)
	private Date contractStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String declineReason;

	//private Long designationId;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveStartDate;

	private String emailId;

	private String candidateLogoPath;

	private String empType;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String firstName;

	private String gender;

	private Long groupId;

	private Long languageId;

	private String lastName;

	private String maritalStatus;

	private String middleName;

	private String mobile;

	private Long noticePeriodDays;

	private Long patternId;

	private Long probationDays;

	private String referenceName;

	@Column(name="ReportingToEmployee")
	private String reportingToEmployee;

	private Long shiftId;

	private Long stateId;

	private String timeContract;

	private Long userId;

	private Long userIdUpdate;

	private String voluntaryPfContribution;

	//bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="permanentAddressId")
	private Address address1;

	//bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="presentAddressId")
	private Address address2;

	//bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="referenceAddressId")
	private Address address3;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="designationId")
	private Designation designation;

	@Transient
	private byte checkApproach;
	public byte getCheckApproach() {
		return checkApproach;
	}

	public void setCheckApproach(byte checkApproach) {
		this.checkApproach = checkApproach;
	}

	/*//bi-directional many-to-one association to CandidateIdProof
	@OneToMany(mappedBy="candidate")
	private List<CandidateIdProof> candidateIdProofs;
*/
	public Candidate() {
	}

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAdharNumber() {
		return this.adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
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

	public String getCandidateStatus() {
		return this.candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getContractOverDate() {
		return this.contractOverDate;
	}

	public void setContractOverDate(Date contractOverDate) {
		this.contractOverDate = contractOverDate;
	}

	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDeclineReason() {
		return this.declineReason;
	}

	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}

//	public Long getDesignationId() {
//		return this.designationId;
//	}
//
//	public void setDesignationId(Long designationId) {
//		this.designationId = designationId;
//	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCandidateLogoPath() {
		return this.candidateLogoPath;
	}

	public void setCandidateLogoPath(String candidateLogoPath) {
		this.candidateLogoPath = candidateLogoPath;
	}

	public String getEmpType() {
		return this.empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getNoticePeriodDays() {
		return this.noticePeriodDays;
	}

	public void setNoticePeriodDays(Long noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}

	public Long getPatternId() {
		return this.patternId;
	}

	public void setPatternId(Long patternId) {
		this.patternId = patternId;
	}

	public Long getProbationDays() {
		return this.probationDays;
	}

	public void setProbationDays(Long probationDays) {
		this.probationDays = probationDays;
	}

	public String getReferenceName() {
		return this.referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getReportingToEmployee() {
		return this.reportingToEmployee;
	}

	public void setReportingToEmployee(String reportingToEmployee) {
		this.reportingToEmployee = reportingToEmployee;
	}

	public Long getShiftId() {
		return this.shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getTimeContract() {
		return this.timeContract;
	}

	public void setTimeContract(String timeContract) {
		this.timeContract = timeContract;
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

	public String getVoluntaryPfContribution() {
		return this.voluntaryPfContribution;
	}

	public void setVoluntaryPfContribution(String voluntaryPfContribution) {
		this.voluntaryPfContribution = voluntaryPfContribution;
	}

	public Address getAddress1() {
		return this.address1;
	}

	public void setAddress1(Address address1) {
		this.address1 = address1;
	}

	public Address getAddress2() {
		return this.address2;
	}

	public void setAddress2(Address address2) {
		this.address2 = address2;
	}

	public Address getAddress3() {
		return this.address3;
	}

	public void setAddress3(Address address3) {
		this.address3 = address3;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getCandidateCode() {
		return candidateCode;
	}

	public void setCandidateCode(String candidateCode) {
		this.candidateCode = candidateCode;
	}

//	public List<CandidateIdProof> getCandidateIdProofs() {
//		return this.candidateIdProofs;
//	}
//
//	public void setCandidateIdProofs(List<CandidateIdProof> candidateIdProofs) {
//		this.candidateIdProofs = candidateIdProofs;
//	}
//
//	public CandidateIdProof addCandidateIdProof(CandidateIdProof candidateIdProof) {
//		getCandidateIdProofs().add(candidateIdProof);
//		candidateIdProof.setCandidate(this);
//
//		return candidateIdProof;
//	}
//
//	public CandidateIdProof removeCandidateIdProof(CandidateIdProof candidateIdProof) {
//		getCandidateIdProofs().remove(candidateIdProof);
//		candidateIdProof.setCandidate(null);
//
//		return candidateIdProof;
//	}

}