package com.csipl.hrms.model.employee;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.common.Company;

import java.util.Date;


/**
 * The persistent class for the TicketType database table.
 * 
 */
@Entity
@NamedQuery(name="TicketType.findAll", query="SELECT t FROM TicketType t")
public class TicketType extends BaseModelWithoutGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ticketTypeId;

	private String activeStatus;

	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String email;

	private Long tat;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public TicketType() {
	}

	
	public Long getTicketTypeId() {
		return this.ticketTypeId;
	}

	public void setTicketTypeId(Long ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTat() {
		return this.tat;
	}

	public void setTat(Long tat) {
		this.tat = tat;
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

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}