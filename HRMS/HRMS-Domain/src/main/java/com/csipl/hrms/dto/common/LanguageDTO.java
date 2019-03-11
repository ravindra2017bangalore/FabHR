package com.csipl.hrms.dto.common;

import java.io.Serializable;
 
 
 public class LanguageDTO implements Serializable {
	private static final long serialVersionUID = 1L;

  	private Long languageId;
 	private String code;

	private String name;
	private Long companyId;
 
	public Long getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}