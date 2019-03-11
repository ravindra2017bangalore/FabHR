package com.csipl.hrms.model.authoriztion;



import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModelWithoutCG;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ObjectsInSystem database table.
 * 
 */
@Entity
@NamedQuery(name="ObjectsInSystem.findAll", query="SELECT o FROM ObjectsInSystem o")
public class ObjectsInSystem extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long objectId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String objectDescription;

	private String objectTechnicalName;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to AdditionalUserObject
	@OneToMany(mappedBy="objectsInSystem")
	private List<AdditionalUserObject> additionalUserObjects;

	//bi-directional many-to-one association to ObjectsInSystemInRole
	@OneToMany(mappedBy="objectsInSystem")
	private List<ObjectsInSystemInRole> objectsInSystemInRoles;

	public ObjectsInSystem() {
	}

	public Long getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
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

	public String getObjectDescription() {
		return this.objectDescription;
	}

	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}

	public String getObjectTechnicalName() {
		return this.objectTechnicalName;
	}

	public void setObjectTechnicalName(String objectTechnicalName) {
		this.objectTechnicalName = objectTechnicalName;
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

	public List<AdditionalUserObject> getAdditionalUserObjects() {
		return this.additionalUserObjects;
	}

	public void setAdditionalUserObjects(List<AdditionalUserObject> additionalUserObjects) {
		this.additionalUserObjects = additionalUserObjects;
	}

	public AdditionalUserObject addAdditionalUserObject(AdditionalUserObject additionalUserObject) {
		getAdditionalUserObjects().add(additionalUserObject);
		additionalUserObject.setObjectsInSystem(this);

		return additionalUserObject;
	}

	public AdditionalUserObject removeAdditionalUserObject(AdditionalUserObject additionalUserObject) {
		getAdditionalUserObjects().remove(additionalUserObject);
		additionalUserObject.setObjectsInSystem(null);

		return additionalUserObject;
	}

	public List<ObjectsInSystemInRole> getObjectsInSystemInRoles() {
		return this.objectsInSystemInRoles;
	}

	public void setObjectsInSystemInRoles(List<ObjectsInSystemInRole> objectsInSystemInRoles) {
		this.objectsInSystemInRoles = objectsInSystemInRoles;
	}

	public ObjectsInSystemInRole addObjectsInSystemInRole(ObjectsInSystemInRole objectsInSystemInRole) {
		getObjectsInSystemInRoles().add(objectsInSystemInRole);
		objectsInSystemInRole.setObjectsInSystem(this);

		return objectsInSystemInRole;
	}

	public ObjectsInSystemInRole removeObjectsInSystemInRole(ObjectsInSystemInRole objectsInSystemInRole) {
		getObjectsInSystemInRoles().remove(objectsInSystemInRole);
		objectsInSystemInRole.setObjectsInSystem(null);

		return objectsInSystemInRole;
	}

}