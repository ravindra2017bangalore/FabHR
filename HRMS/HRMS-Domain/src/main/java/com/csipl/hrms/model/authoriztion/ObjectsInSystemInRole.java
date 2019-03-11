package com.csipl.hrms.model.authoriztion;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.util.Date;


/**
 * The persistent class for the ObjectsInSystemInRole database table.
 * 
 */
@Entity
@NamedQuery(name="ObjectsInSystemInRole.findAll", query="SELECT o FROM ObjectsInSystemInRole o")
public class ObjectsInSystemInRole extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ObjectsInSystemInRoleId")
	private Long objectsInSystemInRoleId;

	private String addRecord;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String delRecord;

	private String modRecord;

	private String viewRecord;

	//bi-directional many-to-one association to RoleMaster
	@ManyToOne
	@JoinColumn(name="roleId")
	private RoleMaster roleMaster;

	//bi-directional many-to-one association to ObjectsInSystem
	@ManyToOne
	@JoinColumn(name="objectId")
	private ObjectsInSystem objectsInSystem;

	public ObjectsInSystemInRole() {
	}

	public Long getObjectsInSystemInRoleId() {
		return this.objectsInSystemInRoleId;
	}

	public void setObjectsInSystemInRoleId(Long objectsInSystemInRoleId) {
		this.objectsInSystemInRoleId = objectsInSystemInRoleId;
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

	public String getViewRecord() {
		return this.viewRecord;
	}

	public void setViewRecord(String viewRecord) {
		this.viewRecord = viewRecord;
	}

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

	public ObjectsInSystem getObjectsInSystem() {
		return this.objectsInSystem;
	}

	public void setObjectsInSystem(ObjectsInSystem objectsInSystem) {
		this.objectsInSystem = objectsInSystem;
	}

}