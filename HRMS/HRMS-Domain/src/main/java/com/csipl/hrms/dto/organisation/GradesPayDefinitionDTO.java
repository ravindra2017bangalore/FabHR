package com.csipl.hrms.dto.organisation;

import java.math.BigDecimal;
import java.util.Date;

public class GradesPayDefinitionDTO {
	private Long gradesPayId;
	private Long payHeadId;
	private String payHeadName;
	private BigDecimal percenatage;
	private Long gradesId;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	
	public Long getGradesPayId() {
		return gradesPayId;
	}
	public Long getGradesId() {
		return gradesId;
	}
	public void setGradesId(Long gradesId) {
		this.gradesId = gradesId;
	}
	public String getPayHeadName() {
		return payHeadName;
	}
	public void setPayHeadName(String payHeadName) {
		this.payHeadName = payHeadName;
	}
	public void setGradesPayId(Long gradesPayId) {
		this.gradesPayId = gradesPayId;
	}
	public Long getPayHeadId() {
		return payHeadId;
	}
	public void setPayHeadId(Long payHeadId) {
		this.payHeadId = payHeadId;
	}
	public BigDecimal getPercenatage() {
		return percenatage;
	}
	public void setPercenatage(BigDecimal percenatage) {
		this.percenatage = percenatage;
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
}
