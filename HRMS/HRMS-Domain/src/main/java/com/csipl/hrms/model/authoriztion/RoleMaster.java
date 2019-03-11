package com.csipl.hrms.model.authoriztion;



import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModelWithoutCG;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RoleMaster database table.
 * 
 */
@Entity
@NamedQuery(name="RoleMaster.findAll", query="SELECT r FROM RoleMaster r")
public class RoleMaster extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String roleDescription;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to ObjectsInSystemInRole
	@OneToMany(mappedBy="roleMaster",fetch =FetchType.EAGER)
	private List<ObjectsInSystemInRole> objectsInSystemInRoles;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="roleMaster")
	private List<UserRole> userRoles;

	public RoleMaster() {
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
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

	public List<ObjectsInSystemInRole> getObjectsInSystemInRoles() {
		return this.objectsInSystemInRoles;
	}

	public void setObjectsInSystemInRoles(List<ObjectsInSystemInRole> objectsInSystemInRoles) {
		this.objectsInSystemInRoles = objectsInSystemInRoles;
	}

	public ObjectsInSystemInRole addObjectsInSystemInRole(ObjectsInSystemInRole objectsInSystemInRole) {
		getObjectsInSystemInRoles().add(objectsInSystemInRole);
		objectsInSystemInRole.setRoleMaster(this);

		return objectsInSystemInRole;
	}

	public ObjectsInSystemInRole removeObjectsInSystemInRole(ObjectsInSystemInRole objectsInSystemInRole) {
		getObjectsInSystemInRoles().remove(objectsInSystemInRole);
		objectsInSystemInRole.setRoleMaster(null);

		return objectsInSystemInRole;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRoleMaster(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRoleMaster(null);

		return userRole;
	}

}