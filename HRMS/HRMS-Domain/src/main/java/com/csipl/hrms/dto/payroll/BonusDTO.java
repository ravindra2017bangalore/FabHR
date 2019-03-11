package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

public class BonusDTO {
	
private Long bonusId;
private BigDecimal bonusPer;
private Long gradesId;
private String gradesName;
private String effectiveDate;
private Long userId;
private Date dateCreated;
private Long companyId;
private Long userIdUpdate;


private String activeStatus;
public String getActiveStatus() {
	return activeStatus;
}
public void setActiveStatus(String activeStatus) {
	this.activeStatus = activeStatus;
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
public String getEffectiveDate() {
	return effectiveDate;
}
public void setEffectiveDate(String effectiveDate) {
	this.effectiveDate = effectiveDate;
}
public Long getBonusId() {
	return bonusId;
}
public Long getGradesId() {
	return gradesId;
}
public void setGradesId(Long gradesId) {
	this.gradesId = gradesId;
}
public String getGradesName() {
	return gradesName;
}
public void setGradesName(String gradesName) {
	this.gradesName = gradesName;
}
public void setBonusId(Long bonusId) {
	this.bonusId = bonusId;
}

public BigDecimal getBonusPer() {
	return bonusPer;
}
public void setBonusPer(BigDecimal bonusPer) {
	this.bonusPer = bonusPer;
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
