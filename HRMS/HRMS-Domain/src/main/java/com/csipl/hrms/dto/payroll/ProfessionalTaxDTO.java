package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

  public class ProfessionalTaxDTO {
	 private Long professionalHeadId;
	
	private String  stateName;
	private Long stateId;
	
	private Long userId;
	private Date dateCreated;
	private String activeStatus;
	private String effectiveStartDate;
	private Date effectiveEndDate;
	private Long companyId;
	private Long userIdUpdate;
	private Long groupId;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
	private List<ProfessionalTaxInfoDTO> professionalTaxInfos;
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
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Long getProfessionalHeadId() {
		return professionalHeadId;
	}
	public void setProfessionalHeadId(Long professionalHeadId) {
		this.professionalHeadId = professionalHeadId;
	}
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	
	
	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}
	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}
	public List<ProfessionalTaxInfoDTO> getProfessionalTaxInfos() {
		return professionalTaxInfos;
	}
	public void setProfessionalTaxInfos(List<ProfessionalTaxInfoDTO> professionalTaxInfos) {
		this.professionalTaxInfos = professionalTaxInfos;
	}
	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}
	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	 
	  
}
