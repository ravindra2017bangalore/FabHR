package com.csipl.hrms.model.employee;


import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.candidate.CandidateLanguage;
import com.csipl.hrms.model.common.Address;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.common.State;
import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;
import com.csipl.hrms.model.organisation.Project;
import com.csipl.hrms.model.payroll.TdsTransaction;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long employeeId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.DATE)
	private Date anniversaryDate;

	private String bloodGroup;

	
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;
	
	@Temporal(TemporalType.DATE)
	private Date contractOverDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private String employeeCode;

	private String empType;

	private String firstName;

	private String gender;

	private String employeeLogoPath;

	private String lastName;
	
	private String adharNumber;

	private String maritalStatus;

	private String middleName;

	private Long noticePeriodDays;

	private Long probationDays;

	private String referenceName;
	
	private Long gradesId;
	
	private String voluntaryPfContribution;
	
	private String alternateNumber;
	
 	private String timeContract;

	private String contactNo;
	
	private String officialEmail;

	private String personalEmail;
	
	@Column(name="ReportingToEmployee")
	private Long reportingToEmployee;

	private Long shiftId; 
	
	private Long patternId;
	//bi-directional many-to-one association to Address
	@ManyToOne( cascade = CascadeType.ALL)
 	@JoinColumn(name="permanentAddressId")
	private Address address1;

	//bi-directional many-to-one association to Address
	@ManyToOne( cascade = CascadeType.ALL)
 	@JoinColumn(name="presentAddressId")
	private Address address2;

	//bi-directional many-to-one association to Address
 	@ManyToOne( cascade = CascadeType.ALL)
 	@JoinColumn(name="referenceAddressId")
	private Address address3;

 	//bi-directional many-to-one association to EmployeeLanguage
 	@OneToMany(mappedBy="employee" ,cascade = CascadeType.ALL)
 		private List<EmployeeLanguage> employeeLanguages;
 	
	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	//bi-directional many-to-one association to Designation
	@ManyToOne
	@JoinColumn(name="designationId")
	private Designation designation;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;

	//bi-directional many-to-one association to State
		@ManyToOne
		@JoinColumn(name="stateId")
		private State state;
	
	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="cityId")
	private City city;

	
	//bi-directional many-to-one association to EmployeeSkill
	//@ManyToOne( cascade = CascadeType.ALL)
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL )
	private List<EmployeeSkill> employeeSkills;
	
	
	//bi-directional many-to-one association to PayStructureHd
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL )
	private List<PayStructureHd> payStructureHds;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	private List<EmployeeBank> employeeBanks;
	
	//bi-directional many-to-one association to EmployeeIdProof
		@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
		private List<EmployeeIdProof> employeeIdProofs;
		
		@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
		private List<EmployeeStatuary> employeeStatuaries;
		
		//bi-directional many-to-one association to TdsApproved
	/*	@OneToMany(mappedBy="employee")
		private List<TdsApproved> tdsApproveds;*/
	
		//bi-directional many-to-one association to TdsTransaction
		@OneToMany(mappedBy="employee")
		private List<TdsTransaction> tdsTransactions;
		
		@OneToMany(mappedBy="employee" ,cascade = CascadeType.ALL)
		private List<MandatoryInfoCheck> mandatoryInfoChecks;
  		
		
	@Transient
	 private  boolean newSkillValues;
	
	@Transient
	 private  String genderValue;
	
	@Transient
	 private  String bankNameValue;
	
	@Transient
	 private  String accountTypeValue;
	
	@Transient
	 private  String maritalStatusValue;
	

	@Transient
	 private  String empTypeValue;
	
	@Transient
	 private  String bloodGroupValue;
	
	
	public List<EmployeeSkill> getEmployeeSkills() {
		return this.employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	
	
	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().add(employeeSkill);
		employeeSkill.setEmployee(this);

		return employeeSkill;
	}

	public EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().remove(employeeSkill);
		employeeSkill.setEmployee(null);

		return employeeSkill;
	}
	
	
	public List<EmployeeStatuary> getEmployeeStatuaries() {
		return this.employeeStatuaries;
	}

	public void setEmployeeStatuaries(List<EmployeeStatuary> employeeStatuaries) {
		this.employeeStatuaries = employeeStatuaries;
	}

	public EmployeeStatuary addEmployeeStatuary(EmployeeStatuary employeeStatuary) {
		getEmployeeStatuaries().add(employeeStatuary);
		employeeStatuary.setEmployee(this);

		return employeeStatuary;
	}

	public EmployeeStatuary removeEmployeeStatuary(EmployeeStatuary employeeStatuary) {
		getEmployeeStatuaries().remove(employeeStatuary);
		employeeStatuary.setEmployee(null);

		return employeeStatuary;
	}

/*	//bi-directional many-to-one association to EmployeeAsset
	@OneToMany(mappedBy="employee")
	private List<EmployeeAsset> employeeAssets;

	//bi-directional many-to-one association to EmployeeBank
	

	//bi-directional many-to-one association to EmployeeDocument
	@OneToMany(mappedBy="employee")
	private List<EmployeeDocument> employeeDocuments;

	//bi-directional many-to-one association to EmployeeEducation
	@OneToMany(mappedBy="employee")
	private List<EmployeeEducation> employeeEducations;

	//bi-directional many-to-one association to EmployeeFamily
	@OneToMany(mappedBy="employee")
	private List<EmployeeFamily> employeeFamilies;

	


	//bi-directional many-to-one association to EmployeeStatuary
	@OneToMany(mappedBy="employee")
	private List<EmployeeStatuary> employeeStatuaries;

	//bi-directional many-to-one association to LoanIssue
	@OneToMany(mappedBy="employee")
	private List<LoanIssue> loanIssues;
	
	
		//bi-directional many-to-one association to TicketDesc
	@OneToMany(mappedBy="employee")
	private List<TicketDesc> ticketDesc;

	//bi-directional many-to-one association to PayStructure
	@OneToMany(mappedBy="employee")
	private List<PayStructure> payStructures;

	//bi-directional many-to-one association to ProfessionalInformation
	@OneToMany(mappedBy="employee")
	private List<ProfessionalInformation> professionalInformations;

	//bi-directional many-to-one association to TdsTransaction
	@OneToMany(mappedBy="employee")
	private List<TdsTransaction> tdsTransactions;*/

	public Employee() {
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

	public Date getContractOverDate() {
		return this.contractOverDate;
	}

	public void setContractOverDate(Date contractOverDate) {
		this.contractOverDate = contractOverDate;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmpType() {
		return this.empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeLogoPath() {
		return employeeLogoPath;
	}

	public void setEmployeeLogoPath(String employeeLogoPath) {
		this.employeeLogoPath = employeeLogoPath;
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

	public Long getNoticePeriodDays() {
		return this.noticePeriodDays;
	}

	public void setNoticePeriodDays(Long noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
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

	public Long getReportingToEmployee() {
		return this.reportingToEmployee;
	}

	public void setReportingToEmployee(Long reportingToEmployee) {
		this.reportingToEmployee = reportingToEmployee;
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

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public boolean isNewSkillValues() {
		return newSkillValues;
	}

	public void setNewSkillValues(boolean newSkillValues) {
		this.newSkillValues = newSkillValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getVoluntaryPfContribution() {
		return voluntaryPfContribution;
	}

	public void setVoluntaryPfContribution(String voluntaryPfContribution) {
		this.voluntaryPfContribution = voluntaryPfContribution;
	}

	public List<PayStructureHd> getPayStructureHds() {
		return this.payStructureHds;
	}

	public void setPayStructureHds(List<PayStructureHd> payStructureHds) {
		this.payStructureHds = payStructureHds;
	}

	public List<EmployeeBank> getEmployeeBanks() {
		return this.employeeBanks;
	}

	public void setEmployeeBanks(List<EmployeeBank> employeeBanks) {
		this.employeeBanks = employeeBanks;
	}

	public EmployeeBank addEmployeeBank(EmployeeBank employeeBank) {
		getEmployeeBanks().add(employeeBank);
		employeeBank.setEmployee(this);

		return employeeBank;
	}

	public EmployeeBank removeEmployeeBank(EmployeeBank employeeBank) {
		getEmployeeBanks().remove(employeeBank);
		employeeBank.setEmployee(null);

		return employeeBank;
	}
	
	public List<EmployeeIdProof> getEmployeeIdProofs() {
		return this.employeeIdProofs;
	}

	public void setEmployeeIdProofs(List<EmployeeIdProof> employeeIdProofs) {
		this.employeeIdProofs = employeeIdProofs;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	 
	/*public List<EmployeeAsset> getEmployeeAssets() {
		return this.employeeAssets;
	}

	public void setEmployeeAssets(List<EmployeeAsset> employeeAssets) {
		this.employeeAssets = employeeAssets;
	}

	public EmployeeAsset addEmployeeAsset(EmployeeAsset employeeAsset) {
		getEmployeeAssets().add(employeeAsset);
		employeeAsset.setEmployee(this);

		return employeeAsset;
	}

	public EmployeeAsset removeEmployeeAsset(EmployeeAsset employeeAsset) {
		getEmployeeAssets().remove(employeeAsset);
		employeeAsset.setEmployee(null);

		return employeeAsset;
	}

	

	public List<EmployeeDocument> getEmployeeDocuments() {
		return this.employeeDocuments;
	}

	public void setEmployeeDocuments(List<EmployeeDocument> employeeDocuments) {
		this.employeeDocuments = employeeDocuments;
	}

	public EmployeeDocument addEmployeeDocument(EmployeeDocument employeeDocument) {
		getEmployeeDocuments().add(employeeDocument);
		employeeDocument.setEmployee(this);

		return employeeDocument;
	}

	public EmployeeDocument removeEmployeeDocument(EmployeeDocument employeeDocument) {
		getEmployeeDocuments().remove(employeeDocument);
		employeeDocument.setEmployee(null);

		return employeeDocument;
	}

	public List<EmployeeEducation> getEmployeeEducations() {
		return this.employeeEducations;
	}

	public void setEmployeeEducations(List<EmployeeEducation> employeeEducations) {
		this.employeeEducations = employeeEducations;
	}

	public EmployeeEducation addEmployeeEducation(EmployeeEducation employeeEducation) {
		getEmployeeEducations().add(employeeEducation);
		employeeEducation.setEmployee(this);

		return employeeEducation;
	}

	public EmployeeEducation removeEmployeeEducation(EmployeeEducation employeeEducation) {
		getEmployeeEducations().remove(employeeEducation);
		employeeEducation.setEmployee(null);

		return employeeEducation;
	}

	public List<EmployeeFamily> getEmployeeFamilies() {
		return this.employeeFamilies;
	}

	public void setEmployeeFamilies(List<EmployeeFamily> employeeFamilies) {
		this.employeeFamilies = employeeFamilies;
	}

	public EmployeeFamily addEmployeeFamily(EmployeeFamily employeeFamily) {
		getEmployeeFamilies().add(employeeFamily);
		employeeFamily.setEmployee(this);

		return employeeFamily;
	}

	public EmployeeFamily removeEmployeeFamily(EmployeeFamily employeeFamily) {
		getEmployeeFamilies().remove(employeeFamily);
		employeeFamily.setEmployee(null);

		return employeeFamily;
	}

	



	public List<EmployeeStatuary> getEmployeeStatuaries() {
		return this.employeeStatuaries;
	}

	public void setEmployeeStatuaries(List<EmployeeStatuary> employeeStatuaries) {
		this.employeeStatuaries = employeeStatuaries;
	}

	public EmployeeStatuary addEmployeeStatuary(EmployeeStatuary employeeStatuary) {
		getEmployeeStatuaries().add(employeeStatuary);
		employeeStatuary.setEmployee(this);

		return employeeStatuary;
	}

	public EmployeeStatuary removeEmployeeStatuary(EmployeeStatuary employeeStatuary) {
		getEmployeeStatuaries().remove(employeeStatuary);
		employeeStatuary.setEmployee(null);

		return employeeStatuary;
	}

	public List<LoanIssue> getLoanIssues() {
		return this.loanIssues;
	}

	public void setLoanIssues(List<LoanIssue> loanIssues) {
		this.loanIssues = loanIssues;
	}

	public LoanIssue addLoanIssue(LoanIssue loanIssue) {
		getLoanIssues().add(loanIssue);
		loanIssue.setEmployee(this);

		return loanIssue;
	}

	public LoanIssue removeLoanIssue(LoanIssue loanIssue) {
		getLoanIssues().remove(loanIssue);
		loanIssue.setEmployee(null);

		return loanIssue;
	}

	

	public List<ProfessionalInformation> getProfessionalInformations() {
		return this.professionalInformations;
	}

	public void setProfessionalInformations(List<ProfessionalInformation> professionalInformations) {
		this.professionalInformations = professionalInformations;
	}

	public ProfessionalInformation addProfessionalInformation(ProfessionalInformation professionalInformation) {
		getProfessionalInformations().add(professionalInformation);
		professionalInformation.setEmployee(this);

		return professionalInformation;
	}

	public ProfessionalInformation removeProfessionalInformation(ProfessionalInformation professionalInformation) {
		getProfessionalInformations().remove(professionalInformation);
		professionalInformation.setEmployee(null);

		return professionalInformation;
	}

	*/
	
	
/*	public List<TdsApproved> getTdsApproveds() {
		return this.tdsApproveds;
	}

	public void setTdsApproveds(List<TdsApproved> tdsApproveds) {
		this.tdsApproveds = tdsApproveds;
	}*/

/*	public TdsApproved addTdsApproved(TdsApproved tdsApproved) {
		getTdsApproveds().add(tdsApproved);
		tdsApproved.setEmployee(this);

		return tdsApproved;
	}

	public TdsApproved removeTdsApproved(TdsApproved tdsApproved) {
		getTdsApproveds().remove(tdsApproved);
		tdsApproved.setEmployee(null);

		return tdsApproved;
	}*/
	
	
	public List<TdsTransaction> getTdsTransactions() {
		return this.tdsTransactions;
	}

	public void setTdsTransactions(List<TdsTransaction> tdsTransactions) {
		this.tdsTransactions = tdsTransactions;
	}

	public TdsTransaction addTdsTransaction(TdsTransaction tdsTransaction) {
		getTdsTransactions().add(tdsTransaction);
		tdsTransaction.setEmployee(this);

		return tdsTransaction;
	}

	public TdsTransaction removeTdsTransaction(TdsTransaction tdsTransaction) {
		getTdsTransactions().remove(tdsTransaction);
		tdsTransaction.setEmployee(null);

		return tdsTransaction;
	}
	
	
	public List<MandatoryInfoCheck> getMandatoryInfoChecks() {
		return this.mandatoryInfoChecks;
	}

	public void setMandatoryInfoChecks(List<MandatoryInfoCheck> mandatoryInfoChecks) {
		this.mandatoryInfoChecks = mandatoryInfoChecks;
	}

	public MandatoryInfoCheck addMandatoryInfoCheck(MandatoryInfoCheck mandatoryInfoCheck) {
		getMandatoryInfoChecks().add(mandatoryInfoCheck);
		mandatoryInfoCheck.setEmployee(this);

		return mandatoryInfoCheck;
	}

	public MandatoryInfoCheck removeMandatoryInfoCheck(MandatoryInfoCheck mandatoryInfoCheck) {
		getMandatoryInfoChecks().remove(mandatoryInfoCheck);
		mandatoryInfoCheck.setEmployee(null);

		return mandatoryInfoCheck;
	}
	
	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getGenderValue() {
		return genderValue;
	}

	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getBankNameValue() {
		return bankNameValue;
	}

	public String getAccountTypeValue() {
		return accountTypeValue;
	}

	public String getMaritalStatusValue() {
		return maritalStatusValue;
	}

	public void setBankNameValue(String bankNameValue) {
		this.bankNameValue = bankNameValue;
	}

	public void setAccountTypeValue(String accountTypeValue) {
		this.accountTypeValue = accountTypeValue;
	}

	public void setMaritalStatusValue(String maritalStatusValue) {
		this.maritalStatusValue = maritalStatusValue;
	}

	public String getEmpTypeValue() {
		return empTypeValue;
	}

	public String getBloodGroupValue() {
		return bloodGroupValue;
	}

	public void setEmpTypeValue(String empTypeValue) {
		this.empTypeValue = empTypeValue;
	}

	public void setBloodGroupValue(String bloodGroupValue) {
		this.bloodGroupValue = bloodGroupValue;
	}

	public Long getGradesId() {
		return gradesId;
	}

	public void setGradesId(Long gradesId) {
		this.gradesId = gradesId;
	}

	public String getTimeContract() {
		return timeContract;
	}

	public void setTimeContract(String timeContract) {
		this.timeContract = timeContract;
	}

	public List<EmployeeLanguage> getEmployeeLanguages() {
		return this.employeeLanguages;
	}

	public void setEmployeeLanguages(List<EmployeeLanguage> employeeLanguages) {
		this.employeeLanguages = employeeLanguages;
	}

	public EmployeeLanguage addEmployeeLanguage(EmployeeLanguage employeeLanguage) {
		getEmployeeLanguages().add(employeeLanguage);
		employeeLanguage.setEmployee(this);

		return employeeLanguage;
	}

	public EmployeeLanguage removeEmployeeLanguage(EmployeeLanguage employeeLanguage) {
		getEmployeeLanguages().remove(employeeLanguage);
		employeeLanguage.setEmployee(null);

		return employeeLanguage;
	}

	public Long getShiftId() {
		return shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}

	public Long getPatternId() {
		return patternId;
	}

	public void setPatternId(Long patternId) {
		this.patternId = patternId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}