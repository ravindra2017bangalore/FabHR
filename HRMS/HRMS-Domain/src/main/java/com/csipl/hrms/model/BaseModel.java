package com.csipl.hrms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;

@MappedSuperclass
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long userIdUpdate;
	
	//bi-directional many-to-one association to Groupg
		@ManyToOne
		@JoinColumn(name="groupId")
		private Groupg groupg;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	// bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	

	private String activeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveEndDate;

	@Temporal(TemporalType.TIMESTAMP)
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

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
	public Groupg getGroupg() {
		return this.groupg;
	}

	public void setGroupg(Groupg groupg) {
		this.groupg = groupg;
	}
	
	

}
