package com.csipl.hrms.dto.organisation;

import java.util.Date;

public class DesignationDTO {
 	
	private Long designationId;
	private String designationName;
	private Long departmentId;
	private String departmentName;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	private String checkedStatus;
	private Long deptDesgId;
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public String getCheckedStatus() {
		return checkedStatus;
	}
	public void setCheckedStatus(String checkedStatus) {
		this.checkedStatus = checkedStatus;
	}
	public Long getDeptDesgId() {
		return deptDesgId;
	}
	public void setDeptDesgId(Long deptDesgId) {
		this.deptDesgId = deptDesgId;
	}
	
 
	
}

