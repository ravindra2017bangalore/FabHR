package com.csipl.hrms.dto.organisation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.model.organisation.GradesPayDefinition;

public class GradeDTO {
	private Long gradesId;
	private String gradesName;
	private BigDecimal salaryFrom;
	private BigDecimal salaryTo;
	private BigDecimal incrementPer;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	
	private List<GradesPayDefinitionDTO> gradesPayDefinitions;
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
	public BigDecimal getSalaryFrom() {
		return salaryFrom;
	}
	public void setSalaryFrom(BigDecimal salaryFrom) {
		this.salaryFrom = salaryFrom;
	}
	public BigDecimal getSalaryTo() {
		return salaryTo;
	}
	public void setSalaryTo(BigDecimal salaryTo) {
		this.salaryTo = salaryTo;
	}
	public BigDecimal getIncrementPer() {
		return incrementPer;
	}
	public void setIncrementPer(BigDecimal incrementPer) {
		this.incrementPer = incrementPer;
	}
	public List<GradesPayDefinitionDTO> getGradesPayDefinitions() {
		return gradesPayDefinitions;
	}
	public void setGradesPayDefinitions(List<GradesPayDefinitionDTO> gradesPayDefinitions) {
		this.gradesPayDefinitions = gradesPayDefinitions;
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
	
	
	
	
	/*@Override
	public String toString() {
		return "GradeDTO [gradesName=" + gradesName + ", salaryFrom=" + salaryFrom + ", salaryTo=" + salaryTo
				+ ", incrementPer=" + incrementPer + "]";
	}
	*/
}
