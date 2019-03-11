package com.csipl.hrms.dto.authorization;

public class UserRoleDTO {
	private Long userRolesSrNo;
	private Long userId;
	private String username;
	private String roleDescription;
	private Long roleId;
	private Long sUserId;
	public Long getUserRolesSrNo() {
		return userRolesSrNo;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public Long getsUserId() {
		return sUserId;
	}
	public void setUserRolesSrNo(Long userRolesSrNo) {
		this.userRolesSrNo = userRolesSrNo;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public void setsUserId(Long sUserId) {
		this.sUserId = sUserId;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
   }
