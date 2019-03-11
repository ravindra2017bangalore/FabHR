package com.csipl.hrms.model.common;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Company database table.
 * 
 */
@Entity
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	private String allowModi;

	private String companyAbbreviation;

	@Lob
	private byte[] companyLogo;

	private String companyLogoPath;

	private String companyName;

	private String domainName;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	private String epfNo;

	private String esicNo;

	private String gstNo;

	private String gumastaNo;

	@Column(name = "ImportExportCode")
	private String importExportCode;

	private String nagarnigamNo;

	private String panNo;

	private String registrationNo;

	private Long retirementAge;

	private String tanNo;

	private String typeOfIndustry;

	private Long userId;

	private Long userIdUpdate;

	// bi-directional many-to-one association to Bank
	// @OneToMany(mappedBy="company")
	// private List<Bank> banks;

	// bi-directional many-to-one association to Branch
	@OneToMany(mappedBy = "company")
	private List<Branch> branches;

	// bi-directional many-to-one association to Client
	// @OneToMany(mappedBy="company")
	// private List<Client> clients;

	// bi-directional many-to-one association to Groupg
	@ManyToOne
	@JoinColumn(name = "groupId")
	private Groupg groupg;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "registeredOfficeAddressId")
	private Address address1;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "corporateOfficeAddressId")
	private Address address2;

	/*
	 * //bi-directional many-to-one association to Department
	 * 
	 * @OneToMany(mappedBy="company") private List<Department> departments;
	 * 
	 * //bi-directional many-to-one association to Designation
	 * 
	 * @OneToMany(mappedBy="company") private List<Designation> designations;
	 * 
	 * //bi-directional many-to-one association to Grade
	 * 
	 * @OneToMany(mappedBy="company") private List<Grade> grades;
	 * 
	 * //bi-directional many-to-one association to Project
	 * 
	 * @OneToMany(mappedBy="company") private List<Project> projects;
	 */

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "company")
	private List<User> users;

	// @OneToMany(mappedBy="company")
	// private List<Leave> leaves;

	private String activeStatus;

	public Company() {
	}

	@Temporal(TemporalType.DATE)
	private Date effectiveEndDate;

	@Temporal(TemporalType.DATE)
	private Date effectiveStartDate;

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getCompanyAbbreviation() {
		return this.companyAbbreviation;
	}

	public void setCompanyAbbreviation(String companyAbbreviation) {
		this.companyAbbreviation = companyAbbreviation;
	}

	public byte[] getCompanyLogo() {
		return this.companyLogo;
	}

	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getCompanyLogoPath() {
		return this.companyLogoPath;
	}

	public void setCompanyLogoPath(String companyLogoPath) {
		this.companyLogoPath = companyLogoPath;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getEpfNo() {
		return this.epfNo;
	}

	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}

	public String getEsicNo() {
		return this.esicNo;
	}

	public void setEsicNo(String esicNo) {
		this.esicNo = esicNo;
	}

	public String getGstNo() {
		return this.gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getGumastaNo() {
		return this.gumastaNo;
	}

	public void setGumastaNo(String gumastaNo) {
		this.gumastaNo = gumastaNo;
	}

	public String getImportExportCode() {
		return this.importExportCode;
	}

	public void setImportExportCode(String importExportCode) {
		this.importExportCode = importExportCode;
	}

	public String getNagarnigamNo() {
		return this.nagarnigamNo;
	}

	public void setNagarnigamNo(String nagarnigamNo) {
		this.nagarnigamNo = nagarnigamNo;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Long getRetirementAge() {
		return this.retirementAge;
	}

	public void setRetirementAge(Long retirementAge) {
		this.retirementAge = retirementAge;
	}

	public String getTanNo() {
		return this.tanNo;
	}

	public void setTanNo(String tanNo) {
		this.tanNo = tanNo;
	}

	public String getTypeOfIndustry() {
		return this.typeOfIndustry;
	}

	public void setTypeOfIndustry(String typeOfIndustry) {
		this.typeOfIndustry = typeOfIndustry;
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

	/*
	 * public List<Bank> getBanks() { return this.banks; }
	 * 
	 * public void setBanks(List<Bank> banks) { this.banks = banks; }
	 * 
	 * public Bank addBank(Bank bank) { getBanks().add(bank); bank.setCompany(this);
	 * 
	 * return bank; }
	 * 
	 * public Bank removeBank(Bank bank) { getBanks().remove(bank);
	 * bank.setCompany(null);
	 * 
	 * return bank; }
	 */

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setCompany(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setCompany(null);

		return branch;
	}

	/*
	 * public List<Client> getClients() { return this.clients; }
	 * 
	 * public void setClients(List<Client> clients) { this.clients = clients; }
	 * 
	 * public Client addClient(Client client) { getClients().add(client);
	 * client.setCompany(this);
	 * 
	 * return client; }
	 * 
	 * public Client removeClient(Client client) { getClients().remove(client);
	 * client.setCompany(null);
	 * 
	 * return client; }
	 */

	public Groupg getGroupg() {
		return this.groupg;
	}

	public void setGroupg(Groupg groupg) {
		this.groupg = groupg;
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

	/*
	 * public List<Department> getDepartments() { return this.departments; }
	 * 
	 * public void setDepartments(List<Department> departments) { this.departments =
	 * departments; }
	 * 
	 * public Department addDepartment(Department department) {
	 * getDepartments().add(department); department.setCompany(this);
	 * 
	 * return department; }
	 * 
	 * public Department removeDepartment(Department department) {
	 * getDepartments().remove(department); department.setCompany(null);
	 * 
	 * return department; }
	 * 
	 * public List<Designation> getDesignations() { return this.designations; }
	 * 
	 * public void setDesignations(List<Designation> designations) {
	 * this.designations = designations; }
	 * 
	 * public Designation addDesignation(Designation designation) {
	 * getDesignations().add(designation); designation.setCompany(this);
	 * 
	 * return designation; }
	 * 
	 * public Designation removeDesignation(Designation designation) {
	 * getDesignations().remove(designation); designation.setCompany(null);
	 * 
	 * return designation; }
	 * 
	 * public List<Grade> getGrades() { return this.grades; }
	 * 
	 * public void setGrades(List<Grade> grades) { this.grades = grades; }
	 * 
	 * public Grade addGrade(Grade grade) { getGrades().add(grade);
	 * grade.setCompany(this);
	 * 
	 * return grade; }
	 * 
	 * public Grade removeGrade(Grade grade) { getGrades().remove(grade);
	 * grade.setCompany(null);
	 * 
	 * return grade; }
	 * 
	 * public List<Project> getProjects() { return this.projects; }
	 * 
	 * public void setProjects(List<Project> projects) { this.projects = projects; }
	 * 
	 * public Project addProject(Project project) { getProjects().add(project);
	 * project.setCompany(this);
	 * 
	 * return project; }
	 * 
	 * public Project removeProject(Project project) {
	 * getProjects().remove(project); project.setCompany(null);
	 * 
	 * return project; }
	 */

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setCompany(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setCompany(null);

		return user;
	}
	/*
	 * public List<Leave> getLeaves() { return this.leaves; }
	 * 
	 * public void setLeaves(List<Leave> leaves) { this.leaves = leaves; }
	 * 
	 * public Leave addLeave(Leave leave) { getLeaves().add(leave);
	 * leave.setCompany(this);
	 * 
	 * return leave; }
	 * 
	 * public Leave removeLeave(Leave leave) { getLeaves().remove(leave);
	 * leave.setCompany(null);
	 * 
	 * return leave; }
	 */
	/*
	 * @Override public boolean equals(Object obj) { // checking if both the object
	 * references are // referring to the same object. if(this == obj) return true;
	 * 
	 * // it checks if the argument is of the // type Geek by comparing the classes
	 * // of the passed argument and this object. // if(!(obj instanceof Geek))
	 * return false; ---> avoid. if(obj == null || obj.getClass()!= this.getClass())
	 * return false;
	 * 
	 * // type casting of the argument. Company company = (Company) obj; return
	 * (company.effectiveStartDate.compareTo( this.effectiveStartDate ) == 0 &&
	 * company.effectiveEndDate.compareTo(this.effectiveEndDate ) == 0 &&
	 * company.companyName.equalsIgnoreCase(this.companyName));
	 * 
	 * }
	 * 
	 * @Override public int hashCode() {
	 * 
	 * // We are returning the Geek_id // as a hashcode value. // we can also return
	 * some // other calculated value or may // be memory address of the // Object
	 * on which it is invoked. // it depends on how you implement // hashCode()
	 * method. final int PRIME = 31; int result = 1; return result = PRIME * result
	 * + getCompanyName().hashCode()+getEffectiveEndDate().hashCode()+
	 * getEffectiveStartDate().hashCode();
	 * 
	 * 
	 * }
	 */

}