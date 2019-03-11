package com.csipl.hrms.model.common;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Branch database table.
 * 
 */
@Entity
@NamedQuery(name="Branch.findAll", query="SELECT b FROM Branch b")
public class Branch  extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long branchId;

	private String allowModi;
	
	private String activeStatus;


	private String branchGstNo;

	private String branchName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveEndDate;

	@Temporal(TemporalType.DATE)
	private Date effectiveStartDate;
	
	private String projectBranchpPantIndicator;

	//bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="branchAddressId")
	private Address address;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="branch")
	private List<User> users;

	public Branch() {
	}

	public Long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getBranchGstNo() {
		return this.branchGstNo;
	}

	public void setBranchGstNo(String branchGstNo) {
		this.branchGstNo = branchGstNo;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getProjectBranchpPantIndicator() {
		return this.projectBranchpPantIndicator;
	}

	public void setProjectBranchpPantIndicator(String projectBranchpPantIndicator) {
		this.projectBranchpPantIndicator = projectBranchpPantIndicator;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setBranch(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setBranch(null);

		return user;
	}

}