package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;

public class TdsTransactionDTO {

	private Long tdsTransactionId;
	private String approveStatus;
	private BigDecimal investmentAmount;
	private BigDecimal approvedAmount;
	private String investmentDetail;
	private int noOfDocuments;
	private String proof;
	private Long tdsSectionId;
	private String tdsSectionName;
	private Long tdsGroupId;
	private String tdsGroupName;
	private String tdsDescription;
	private Long employeeId;
	private Long userId;
	private String dateCreated;
	private BigDecimal maxLimit;
	private String fileLocation;
	private String status;
	private String financialYear;
	private String city;
	private Long userIdUpdate;
	
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public Long getTdsTransactionId() {
		return tdsTransactionId;
	}

	public BigDecimal getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(BigDecimal investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public BigDecimal getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(BigDecimal approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public String getInvestmentDetail() {
		return investmentDetail;
	}

	public void setInvestmentDetail(String investmentDetail) {
		this.investmentDetail = investmentDetail;
	}

	public int getNoOfDocuments() {
		return noOfDocuments;
	}

	public void setNoOfDocuments(int noOfDocuments) {
		this.noOfDocuments = noOfDocuments;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public Long getTdsSectionId() {
		return tdsSectionId;
	}

	public void setTdsSectionId(Long tdsSectionId) {
		this.tdsSectionId = tdsSectionId;
	}

	public String getTdsSectionName() {
		return tdsSectionName;
	}

	public void setTdsSectionName(String tdsSectionName) {
		this.tdsSectionName = tdsSectionName;
	}

	public Long getTdsGroupId() {
		return tdsGroupId;
	}

	public void setTdsGroupId(Long tdsGroupId) {
		this.tdsGroupId = tdsGroupId;
	}

	public String getTdsGroupName() {
		return tdsGroupName;
	}

	public String getTdsDescription() {
		return tdsDescription;
	}

	public void setTdsDescription(String tdsDescription) {
		this.tdsDescription = tdsDescription;
	}

	public void setTdsGroupName(String tdsGroupName) {
		this.tdsGroupName = tdsGroupName;
	}

	public void setTdsTransactionId(Long tdsTransactionId) {
		this.tdsTransactionId = tdsTransactionId;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigDecimal getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
