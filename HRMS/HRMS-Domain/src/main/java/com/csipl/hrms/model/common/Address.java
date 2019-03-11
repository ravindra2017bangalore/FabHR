package com.csipl.hrms.model.common;





import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.util.Date;
import java.util.List;





/**
 * The persistent class for the Address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long addressId;

	private String addressText;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String emailId;

	private String fax;

	private String landmark;

	private String mobile;

	private String pincode;

	private String telephone;

	private Long userId;

	private Long userIdUpdate;

	private String website;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="countryId")
	private Country country;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="stateId")
	private State state;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="cityId")
	private City city;

	//bi-directional many-to-one association to Branch
	@OneToMany(mappedBy="address")
	private List<Branch> branches;

	//bi-directional many-to-one association to Client
//	@OneToMany(mappedBy="address")
//	private List<Client> clients;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="address1")
	private List<Company> companies1;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="address2")
	private List<Company> companies2;

	//bi-directional many-to-one association to Groupg
	@OneToMany(mappedBy="address")
	private List<Groupg> groupgs;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<User> users;

	public Address() {
	}

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressText() {
		return this.addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setAddress(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setAddress(null);

		return branch;
	}

/*	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setAddress(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setAddress(null);

		return client;
	}
*/
	public List<Company> getCompanies1() {
		return this.companies1;
	}

	public void setCompanies1(List<Company> companies1) {
		this.companies1 = companies1;
	}

	public Company addCompanies1(Company companies1) {
		getCompanies1().add(companies1);
		companies1.setAddress1(this);

		return companies1;
	}

	public Company removeCompanies1(Company companies1) {
		getCompanies1().remove(companies1);
		companies1.setAddress1(null);

		return companies1;
	}

	public List<Company> getCompanies2() {
		return this.companies2;
	}

	public void setCompanies2(List<Company> companies2) {
		this.companies2 = companies2;
	}

	public Company addCompanies2(Company companies2) {
		getCompanies2().add(companies2);
		companies2.setAddress2(this);

		return companies2;
	}

	public Company removeCompanies2(Company companies2) {
		getCompanies2().remove(companies2);
		companies2.setAddress2(null);

		return companies2;
	}

	public List<Groupg> getGroupgs() {
		return this.groupgs;
	}

	public void setGroupgs(List<Groupg> groupgs) {
		this.groupgs = groupgs;
	}

	public Groupg addGroupg(Groupg groupg) {
		getGroupgs().add(groupg);
		groupg.setAddress(this);

		return groupg;
	}

	public Groupg removeGroupg(Groupg groupg) {
		getGroupgs().remove(groupg);
		groupg.setAddress(null);

		return groupg;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}

}