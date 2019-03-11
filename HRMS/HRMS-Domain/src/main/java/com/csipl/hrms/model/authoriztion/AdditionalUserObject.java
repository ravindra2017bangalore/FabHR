package com.csipl.hrms.model.authoriztion;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.User;

import java.util.Date;


/**
 * The persistent class for the AdditionalUserObjects database table.
 * 
 */
@Entity
@Table(name="AdditionalUserObjects")
@NamedQuery(name="AdditionalUserObject.findAll", query="SELECT a FROM AdditionalUserObject a")
public class AdditionalUserObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long additionalUserObjectsId;

	private String addRecord;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String delRecord;

	private String modRecord;

	private Long sUserId;

	private Long userIdUpdate;

	private String viewRecord;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to ObjectsInSystem
	@ManyToOne
	@JoinColumn(name="objectId")
	private ObjectsInSystem objectsInSystem;

	public AdditionalUserObject() {
	}

	public Long getAdditionalUserObjectsId() {
		return this.additionalUserObjectsId;
	}

	public void setAdditionalUserObjectsId(Long additionalUserObjectsId) {
		this.additionalUserObjectsId = additionalUserObjectsId;
	}

	public String getAddRecord() {
		return this.addRecord;
	}

	public void setAddRecord(String addRecord) {
		this.addRecord = addRecord;
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

	public String getDelRecord() {
		return this.delRecord;
	}

	public void setDelRecord(String delRecord) {
		this.delRecord = delRecord;
	}

	public String getModRecord() {
		return this.modRecord;
	}

	public void setModRecord(String modRecord) {
		this.modRecord = modRecord;
	}

	public Long getSUserId() {
		return this.sUserId;
	}

	public void setSUserId(Long sUserId) {
		this.sUserId = sUserId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public String getViewRecord() {
		return this.viewRecord;
	}

	public void setViewRecord(String viewRecord) {
		this.viewRecord = viewRecord;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ObjectsInSystem getObjectsInSystem() {
		return this.objectsInSystem;
	}

	public void setObjectsInSystem(ObjectsInSystem objectsInSystem) {
		this.objectsInSystem = objectsInSystem;
	}

}