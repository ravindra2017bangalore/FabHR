package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Country;
import com.csipl.hrms.model.common.State;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the CandidateAddress database table.
 * 
 */
@Entity
@NamedQuery(name = "CandidateAddress.findAll", query = "SELECT c FROM CandidateAddress c")
public class CandidateAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	private String addressText;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

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

	// bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name = "countryId")
	private Country country;

	// bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name = "stateId")
	private State state;

	// bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name = "cityId")
	private City city;

	// bi-directional many-to-one association to CandidatePersonal
	@OneToMany(mappedBy = "candidateAddress1")
	private List<CandidatePersonal> candidatePersonals1;

	// bi-directional many-to-one association to CandidatePersonal
	@OneToMany(mappedBy = "candidateAddress2")
	private List<CandidatePersonal> candidatePersonals2;

	// bi-directional many-to-one association to CandidatePersonal
	@OneToMany(mappedBy = "candidateAddress3")
	private List<CandidatePersonal> candidatePersonals3;

	public CandidateAddress() {
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

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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

	public List<CandidatePersonal> getCandidatePersonals1() {
		return this.candidatePersonals1;
	}

	public void setCandidatePersonals1(List<CandidatePersonal> candidatePersonals1) {
		this.candidatePersonals1 = candidatePersonals1;
	}

	public List<CandidatePersonal> getCandidatePersonals2() {
		return this.candidatePersonals2;
	}

	public void setCandidatePersonals2(List<CandidatePersonal> candidatePersonals2) {
		this.candidatePersonals2 = candidatePersonals2;
	}

	public List<CandidatePersonal> getCandidatePersonals3() {
		return this.candidatePersonals3;
	}

	public void setCandidatePersonals3(List<CandidatePersonal> candidatePersonals3) {
		this.candidatePersonals3 = candidatePersonals3;
	}

}