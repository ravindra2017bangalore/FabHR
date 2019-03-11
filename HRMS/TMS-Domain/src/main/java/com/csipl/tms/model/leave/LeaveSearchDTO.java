package com.csipl.tms.model.leave;

import com.csipl.tms.dto.common.SearchDTO;

public class LeaveSearchDTO extends SearchDTO {
	private String employeeName;
	private String status;
	private Boolean statusFlag;
	private Long companyId;
	public Boolean getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(Boolean statusFlag) {
		this.statusFlag = statusFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
