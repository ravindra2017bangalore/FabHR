package com.csipl.hrms.model.common;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Groupg database table.
 * 
 */
@Entity
@NamedQuery(name = "Groupg.findAll", query = "SELECT g FROM Groupg g")
public class Groupg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupId;

	private String allowModi;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String groupAbbrebiation;

	private Date dateCreated;

	@Lob
	private byte[] groupLogo;

	private String groupLogoPath;

	private String groupName;

	private Long userId;

	private Long userIdUpdate;

	// bi-directional many-to-one association to Branch
	@OneToMany(mappedBy = "groupg")
	private List<Branch> branches;

	// bi-directional many-to-one association to Company
	@OneToMany(mappedBy = "groupg")
	private List<Company> companies;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupAddressId")
	private Address address;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "groupg")
	private List<User> users;

	public Groupg() {
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
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

	public String getGroupAbbrebiation() {
		return this.groupAbbrebiation;
	}

	public void setGroupAbbrebiation(String groupAbbrebiation) {
		this.groupAbbrebiation = groupAbbrebiation;
	}

	public byte[] getGroupLogo() {
		return this.groupLogo;
	}

	public void setGroupLogo(byte[] groupLogo) {
		this.groupLogo = groupLogo;
	}

	public String getGroupLogoPath() {
		return this.groupLogoPath;
	}

	public void setGroupLogoPath(String groupLogoPath) {
		this.groupLogoPath = groupLogoPath;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setGroupg(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setGroupg(null);

		return branch;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setGroupg(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setGroupg(null);

		return company;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setGroupg(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setGroupg(null);

		return user;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}