package com.csipl.hrms.dto.organisation;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
	
	
	private String username;
	private String password;
	private Long userId;
	private Long employeeId;
	private Set<String>	roles = new HashSet<String>();
	private Set<String>	permissions	= new HashSet<String>();
	private String otp;
	private String emailOfUser;
	private String otpType;
	private String confirmPassword;
	private String nameOfUser;
	private String userPassword;
	private String oldPassword;
    private String newPassword;
    private String changePassword;
    private String message;
    private String mobile;
    private Long companyId;
    private Long groupId;
    private Long userIdUpadate;
    private String currentRole;
     private Long userAttempts;
    private String employeeLogoPath; 
    private String loginName;
    
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getEmailOfUser() {
		return emailOfUser;
	}
	public void setEmailOfUser(String emailOfUser) {
		this.emailOfUser = emailOfUser;
	}
	public String getOtpType() {
		return otpType;
	}
	public void setOtpType(String otpType) {
		this.otpType = otpType;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getNameOfUser() {
		return nameOfUser;
	}
	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getChangePassword() {
		return changePassword;
	}
	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}
	public Long getUserAttempts() {
		return userAttempts;
	}
	public void setUserAttempts(Long userAttempts) {
		this.userAttempts = userAttempts;
	}
	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
	public String getEmployeeLogoPath() {
		return employeeLogoPath;
	}
	public void setEmployeeLogoPath(String employeeLogoPath) {
		this.employeeLogoPath = employeeLogoPath;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getUserIdUpadate() {
		return userIdUpadate;
	}
	public void setUserIdUpadate(Long userIdUpadate) {
		this.userIdUpadate = userIdUpadate;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	 
 }
