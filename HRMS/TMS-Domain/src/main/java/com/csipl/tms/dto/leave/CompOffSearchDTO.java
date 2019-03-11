package com.csipl.tms.dto.leave;

import com.csipl.tms.dto.common.SearchDTO;

public class CompOffSearchDTO extends SearchDTO {
	private String employeeName;
	private Long companyId;

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
