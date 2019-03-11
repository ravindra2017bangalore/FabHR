package com.csipl.hrms.model.common;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the GuestUser database table.
 * 
 */
@Entity
@NamedQuery(name="GuestUser.findAll", query="SELECT g FROM GuestUser g")
public class GuestUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long guestId;

	private String company;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String description;

	private String email;

	private Long mobile;

	private String name;

	public GuestUser() {
	}

	public Long getGuestId() {
		return this.guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return this.mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}