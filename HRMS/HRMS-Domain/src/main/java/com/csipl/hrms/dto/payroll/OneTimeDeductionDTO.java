package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class OneTimeDeductionDTO {
	private String deductionMonth;
	private String remarks;
	private Long userId;
	private Long employeeId;
	private String employeeCode;
	private String departmentName;
	private String designationName;
	private String employeeName;
	private Long deductionId;
	private boolean flag;
	private Long companyId;
	private Long UpdateId;
	private String lovName;

	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getUpdateId() {
		return UpdateId;
	}
	public void setUpdateId(Long UpdateId) {
		this.UpdateId = UpdateId;
	}
	public Long getDeductionId() {
		return deductionId;
	}
	public void setDeductionId(Long deductionId) {
		this.deductionId = deductionId;
	}
	public String getemployeeName() {
		return employeeName;
	}
	public void setemployeeName(String name) {
		employeeName = name;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
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
	private BigDecimal deductionAmount;
	public BigDecimal getDeductionAmount() {
		return deductionAmount;
	}
	public void setDeductionAmount(BigDecimal deductionAmount) {
		this.deductionAmount = deductionAmount;
	}
	public String getDeductionMonth() {
		return deductionMonth;
	}
	public void setDeductionMonth(String deductionMonth) {
		this.deductionMonth = deductionMonth;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public boolean isFlag() {
		return flag;
	}
	public String getLovName() {
		return lovName;
	}
	public void setLovName(String lovName) {
		this.lovName = lovName;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	

}
