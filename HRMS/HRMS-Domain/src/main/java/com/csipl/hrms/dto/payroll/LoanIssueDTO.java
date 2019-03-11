package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.csipl.hrms.model.payroll.LoanEMI;

public class LoanIssueDTO {

	private Long transactionNo;
	private Long employeeId;
	private BigDecimal loanAmount;
	private Date issueDate;
	private int noOfEmi;
	private BigDecimal rateOfInterest;
	private String naration;
	private String loanType;
	private String loanTypeLabel;
	private String interestType;
	private BigDecimal emiAmount;
	private Date emiStartDate;
	private Date transactionDate;
	private Date dateOfJoining;
	private String employeeCode;
	private String departmentName;
	private String designationName;
	private String employeeName;
	private boolean flag;
	private Long userId;
	private Date dateCreated;
	private String activeStatus;
	private BigDecimal loanPendingAmount;
	private String activeStatusLabel;
	private Long companyId;
	private Long userIdUpdate;
	private String lovName;

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public String getLovName() {
		return lovName;
	}

	public void setLovName(String lovName) {
		this.lovName = lovName;
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

	private BigDecimal settlementAmount;
 	private String paymentMode;
 	private String instrumentNo;
  	private String remark;
  	private String isSettlementCompleted;
  	
  	private List<LoanEMIDTO> loanEmisDto;
      
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getNoOfEmi() {
		return noOfEmi;
	}

	public void setNoOfEmi(int noOfEmi) {
		this.noOfEmi = noOfEmi;
	}

	public String getNaration() {
		return naration;
	}

	public void setNaration(String naration) {
		this.naration = naration;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanTypeLabel() {
		return loanTypeLabel;
	}

	public void setLoanTypeLabel(String loanTypeLabel) {
		this.loanTypeLabel = loanTypeLabel;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public BigDecimal getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Date getEmiStartDate() {
		return emiStartDate;
	}

	public void setEmiStartDate(Date emiStartDate) {
		this.emiStartDate = emiStartDate;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public BigDecimal getLoanPendingAmount() {
		return loanPendingAmount;
	}

	public void setLoanPendingAmount(BigDecimal loanPendingAmount) {
		this.loanPendingAmount = loanPendingAmount;
	}

	public String getActiveStatusLabel() {
		return activeStatusLabel;
	}

	public void setActiveStatusLabel(String activeStatusLabel) {
		this.activeStatusLabel = activeStatusLabel;
	}

	public List<LoanEMIDTO> getLoanEmisDto() {
		return loanEmisDto;
	}

	public void setLoanEmisDto(List<LoanEMIDTO> loanEmisDto) {
		this.loanEmisDto = loanEmisDto;
	}

	public BigDecimal getSettlementAmount() {
		return settlementAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public String getInstrumentNo() {
		return instrumentNo;
	}

	public String getRemark() {
		return remark;
	}

	public String getIsSettlementCompleted() {
		return isSettlementCompleted;
	}

	public void setSettlementAmount(BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setInstrumentNo(String instrumentNo) {
		this.instrumentNo = instrumentNo;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIsSettlementCompleted(String isSettlementCompleted) {
		this.isSettlementCompleted = isSettlementCompleted;
	}

	@Override
	public String toString() {
		return "LoanIssueDTO [transactionNo=" + transactionNo + ", employeeId=" + employeeId + ", loanAmount="
				+ loanAmount + ", issueDate=" + issueDate + ", noOfEmi=" + noOfEmi + ", rateOfInterest="
				+ rateOfInterest + ", naration=" + naration + ", loanType=" + loanType + ", loanTypeLabel="
				+ loanTypeLabel + ", interestType=" + interestType + ", emiAmount=" + emiAmount + ", emiStartDate="
				+ emiStartDate + ", transactionDate=" + transactionDate + ", dateOfJoining=" + dateOfJoining
				+ ", employeeCode=" + employeeCode + ", departmentName=" + departmentName + ", designationName="
				+ designationName + ", employeeName=" + employeeName + ", flag=" + flag + ", userId=" + userId
				+ ", dateCreated=" + dateCreated + ", activeStatus=" + activeStatus + ", loanPendingAmount="
				+ loanPendingAmount + ", activeStatusLabel=" + activeStatusLabel + ", settlementAmount="
				+ settlementAmount + ", paymentMode=" + paymentMode + ", instrumentNo=" + instrumentNo + ", remark="
				+ remark + ", isSettlementCompleted=" + isSettlementCompleted + ", loanEmisDto=" + loanEmisDto + "]";
	}

}