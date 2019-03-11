package com.csipl.hrms.dto.employee;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EmployeeEducationDTO {
 
	private Long educationId;
	private String degreeName;
	private BigDecimal marksPer;
	private String nameOfBoard;
	private String nameOfInstitution;
	private Long passingYear;
	private String qualificationId;
	private String regularCorrespondance;
	private Long employeeId;
	private Long userId;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public Long getEducationId() {
		return educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public BigDecimal getMarksPer() {
		return marksPer;
	}

	public void setMarksPer(BigDecimal marksPer) {
		this.marksPer = marksPer;
	}

	public String getNameOfBoard() {
		return nameOfBoard;
	}

	public void setNameOfBoard(String nameOfBoard) {
		this.nameOfBoard = nameOfBoard;
	}

	public String getNameOfInstitution() {
		return nameOfInstitution;
	}

	public void setNameOfInstitution(String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
	}

	public Long getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Long passingYear) {
		this.passingYear = passingYear;
	}

	public String getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getRegularCorrespondance() {
		return regularCorrespondance;
	}

	public void setRegularCorrespondance(String regularCorrespondance) {
		this.regularCorrespondance = regularCorrespondance;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EduInformationDTO [educationId=" + educationId + ", degreeName=" + degreeName + ", marksPer=" + marksPer
				+ ", nameOfBoard=" + nameOfBoard + ", nameOfInstitution=" + nameOfInstitution + ", passingYear="
				+ passingYear + ", qualificationId=" + qualificationId + ", regularCorrespondance="
				+ regularCorrespondance + ", employeeId=" + employeeId + "]";
	}

}

