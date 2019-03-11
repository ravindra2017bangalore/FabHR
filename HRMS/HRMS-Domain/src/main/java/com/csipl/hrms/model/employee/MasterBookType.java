package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.Company;

import java.util.Date;


/**
 * The persistent class for the MasterBookType database table.
 * 
 */
@Entity
@NamedQuery(name="MasterBookType.findAll", query="SELECT m FROM MasterBookType m")
public class MasterBookType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long bookTypeId;

	private String allowModi;

	private String bookType;

	private String bookTypeName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private Long groupId;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public MasterBookType() {
	}

	public Long getBookTypeId() {
		return this.bookTypeId;
	}

	public void setBookTypeId(Long bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookTypeName() {
		return this.bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
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

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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