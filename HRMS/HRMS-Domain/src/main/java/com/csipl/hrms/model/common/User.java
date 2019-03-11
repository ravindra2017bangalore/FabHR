package com.csipl.hrms.model.common;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.authoriztion.AdditionalUserObject;
import com.csipl.hrms.model.authoriztion.UserRole;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String emailOfUser;

	private String nameOfUser;

	private String loginName;

	private Long suserId;

	private String userPassword;

	private String changePassword;

	private Long userAttempts;

	// bi-directional many-to-one association to AdditionalUserObject
	@OneToMany(mappedBy = "user")
	private List<AdditionalUserObject> additionalUserObjects;

	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserRole> userRoles;
	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userAddressId")
	private Address address;

	// bi-directional many-to-one association to Groupg
	@ManyToOne
	@JoinColumn(name = "groupId")
	private Groupg groupg;

	// bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;

	// bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name = "branchId")
	private Branch branch;

	public User() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getEmailOfUser() {
		return this.emailOfUser;
	}

	public void setEmailOfUser(String emailOfUser) {
		this.emailOfUser = emailOfUser;
	}

	public String getNameOfUser() {
		return this.nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getSuserId() {
		return this.suserId;
	}

	public void setSuserId(Long suserId) {
		this.suserId = suserId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<AdditionalUserObject> getAdditionalUserObjects() {
		return this.additionalUserObjects;
	}

	public void setAdditionalUserObjects(List<AdditionalUserObject> additionalUserObjects) {
		this.additionalUserObjects = additionalUserObjects;
	}

	public AdditionalUserObject addAdditionalUserObject(AdditionalUserObject additionalUserObject) {
		getAdditionalUserObjects().add(additionalUserObject);
		additionalUserObject.setUser(this);

		return additionalUserObject;
	}

	public AdditionalUserObject removeAdditionalUserObject(AdditionalUserObject additionalUserObject) {
		getAdditionalUserObjects().remove(additionalUserObject);
		additionalUserObject.setUser(null);

		return additionalUserObject;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/*
	 * public UserRole addUserRole(UserRole userRole) {
	 * getUserRoles().add(userRole); userRole.setUser(this);
	 * 
	 * return userRole; }
	 * 
	 * public UserRole removeUserRole(UserRole userRole) {
	 * getUserRoles().remove(userRole); userRole.setUser(null);
	 * 
	 * return userRole; }
	 */

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Groupg getGroupg() {
		return this.groupg;
	}

	public void setGroupg(Groupg groupg) {
		this.groupg = groupg;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

	public Long getUserAttempts() {
		return userAttempts;
	}

	public void setUserAttempts(Long userAttempts) {
		this.userAttempts = userAttempts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", allowModi=" + allowModi + ", dateUpdate=" + dateUpdate + ", emailOfUser="
				+ emailOfUser + ", nameOfUser=" + nameOfUser + ", loginName=" + loginName + ", suserId=" + suserId
				+ ", userPassword=" + userPassword + ", changePassword=" + changePassword + ", userAttempts="
				+ userAttempts + ", additionalUserObjects=" + additionalUserObjects + ", userRoles=" + userRoles
				+ ", address=" + address + ", groupg=" + groupg + ", company=" + company + ", branch=" + branch + "]";
	}

}