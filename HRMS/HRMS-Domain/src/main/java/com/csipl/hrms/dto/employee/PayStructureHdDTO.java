package com.csipl.hrms.dto.employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayStructureHdDTO {
	private Long payStructureHdId;
	private Long gradesId;
	private String gradesName;
	private BigDecimal grossPay;
	private Date effectiveDate;
	private String activeStatus;
	private Long employeeId;
 	private Long userId;
	private Date dateCreated;
	private boolean updateFlag;
	private Date dateEnd;
	private String firstName;
	private String lastName;
	private String employeeCode;
	private String departmentName;
	private String designationName;
	private String isNoPFDeduction;	
	private boolean revisionUpdateFlag;
	private Long userIdUpdate;
	private Long companyId;

	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	private List<PayStructureDTO> payStructureDtoList = new ArrayList<PayStructureDTO>();

	public Long getPayStructureHdId() {
		return payStructureHdId;
	}

	public void setPayStructureHdId(Long payStructureHdId) {
		this.payStructureHdId = payStructureHdId;
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

	public BigDecimal getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(BigDecimal grossPay) {
		this.grossPay = grossPay;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

 	public List<PayStructureDTO> getPayStructureDtoList() {
		return payStructureDtoList;
	}

	public void setPayStructureDtoList(List<PayStructureDTO> payStructureDtoList) {
		this.payStructureDtoList = payStructureDtoList;
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
	public boolean isUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getIsNoPFDeduction() {
		return isNoPFDeduction;
	}

	public void setIsNoPFDeduction(String isNoPFDeduction) {
		this.isNoPFDeduction = isNoPFDeduction;
	}

	public boolean isRevisionUpdateFlag() {
		return revisionUpdateFlag;
	}

	public void setRevisionUpdateFlag(boolean revisionUpdateFlag) {
		this.revisionUpdateFlag = revisionUpdateFlag;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
}
