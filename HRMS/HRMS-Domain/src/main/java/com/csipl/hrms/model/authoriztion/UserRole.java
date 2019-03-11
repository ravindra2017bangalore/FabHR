package com.csipl.hrms.model.authoriztion;





import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.User;

import java.util.Date;


/**
 * The persistent class for the UserRoles database table.
 * 
 */
@Entity
@Table(name="UserRoles")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userRolesSrNo;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private Long sUserId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to RoleMaster
	@ManyToOne
	@JoinColumn(name="roleId")
	private RoleMaster roleMaster;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public UserRole() {
	}

	public Long getUserRolesSrNo() {
		return this.userRolesSrNo;
	}

	public void setUserRolesSrNo(Long userRolesSrNo) {
		this.userRolesSrNo = userRolesSrNo;
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

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}