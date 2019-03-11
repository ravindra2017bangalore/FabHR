package com.csipl.hrms.dto.payroll;

import com.csipl.hrms.model.payroll.TdsSection;

public class TdsSubSectionDTO {
	private Long tdsSubSectionId;
	private String tdsSubSectionName;
	private TdsSection tdsSection;
	public Long getTdsSubSectionId() {
		return tdsSubSectionId;
	}
	public void setTdsSubSectionId(Long tdsSubSectionId) {
		this.tdsSubSectionId = tdsSubSectionId;
	}
	public String getTdsSubSectionName() {
		return tdsSubSectionName;
	}
	public void setTdsSubSectionName(String tdsSubSectionName) {
		this.tdsSubSectionName = tdsSubSectionName;
	}
	public TdsSection getTdsSection() {
		return tdsSection;
	}
	public void setTdsSection(TdsSection tdsSection) {
		this.tdsSection = tdsSection;
	}
}
