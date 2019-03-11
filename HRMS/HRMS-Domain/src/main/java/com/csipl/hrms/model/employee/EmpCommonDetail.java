package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EmpCommonDetails database table.
 * 
 */
@Entity
@Table(name="EmpCommonDetails")
//@NamedQuery(name="EmpCommonDetail.findAll", query="SELECT e FROM EmpCommonDetail e")
public class EmpCommonDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empCommonDetailsId;

	private Long companyId;

	private String companyName;

	private Long departmentId;

	private String departmentName;

	private Long designationId;

	private String designationName;

	private String emailId;

	private String employeeCode;

	private Long employeeId;

	private String firstName;

	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	private String lastName;

	private String mobile;

	private String patternId;

	private String patternName;

	private Long reportingemployeeId;

	private Long shiftId;

	private String shiftName;

	public EmpCommonDetail() {
	}

	public Long getEmpCommonDetailsId() {
		return this.empCommonDetailsId;
	}

	public void setEmpCommonDetailsId(Long empCommonDetailsId) {
		this.empCommonDetailsId = empCommonDetailsId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPatternId() {
		return this.patternId;
	}

	public void setPatternId(String patternId) {
		this.patternId = patternId;
	}

	public String getPatternName() {
		return this.patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}

	public Long getReportingemployeeId() {
		return this.reportingemployeeId;
	}

	public void setReportingemployeeId(Long reportingemployeeId) {
		this.reportingemployeeId = reportingemployeeId;
	}

	public Long getShiftId() {
		return this.shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}

	public String getShiftName() {
		return this.shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

}