package com.csipl.hrms.model.payroll;
 
import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * The persistent class for the LoanIssue database table.
 * 
 */
@Entity
@NamedQuery(name="LoanIssue.findAll", query="SELECT l FROM LoanIssue l")
public class LoanIssue extends BaseModelWithoutGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionNo;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private BigDecimal emiAmount;

	@Temporal(TemporalType.DATE)
	private Date emiStartDate;
	
	private String interestType;

	@Temporal(TemporalType.DATE)
	private Date issueDate;

	private BigDecimal loanAmount;

	private String loanType;

	private String naration;

	private int noOfEmi;

	private BigDecimal rateOfInterest;

	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	private Long userId;

	private Long userIdUpdate;

	private BigDecimal loanPendingAmount;
	
	private BigDecimal settlementAmount;

	private String paymentMode;
	
	private String instrumentNo;

 	private String remark;
 	
 	private String isSettlementCompleted;




	//bi-directional many-to-one association to LoanEMI
	@OneToMany(mappedBy="loanIssue",cascade = CascadeType.ALL)
	private List<LoanEMI> loanEmis;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	
	public LoanIssue() {
	}

	public Long getTransactionNo() {
		return this.transactionNo;
	}

	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public BigDecimal getEmiAmount() {
		return this.emiAmount;
	}

	public void setEmiAmount(BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Date getEmiStartDate() {
		return this.emiStartDate;
	}

	public void setEmiStartDate(Date emiStartDate) {
		this.emiStartDate = emiStartDate;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public BigDecimal getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return this.loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getNaration() {
		return this.naration;
	}

	public void setNaration(String naration) {
		this.naration = naration;
	}

	public int getNoOfEmi() {
		return this.noOfEmi;
	}

	public void setNoOfEmi(int noOfEmi) {
		this.noOfEmi = noOfEmi;
	}

	public BigDecimal getRateOfInterest() {
		return this.rateOfInterest;
	}

	public void setRateOfInterest(BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public List<LoanEMI> getLoanEmis() {
		return this.loanEmis;
	}

	public void setLoanEmis(List<LoanEMI> loanEmis) {
		this.loanEmis = loanEmis;
	}

	public LoanEMI addLoanEmi(LoanEMI loanEmi) {
		getLoanEmis().add(loanEmi);
		loanEmi.setLoanIssue(this);

		return loanEmi;
	}

	public LoanEMI removeLoanEmi(LoanEMI loanEmi) {
		getLoanEmis().remove(loanEmi);
		loanEmi.setLoanIssue(null);

		return loanEmi;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public BigDecimal getLoanPendingAmount() {
		return loanPendingAmount;
	}

	public void setLoanPendingAmount(BigDecimal loanPendingAmount) {
		this.loanPendingAmount = loanPendingAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "LoanIssue [transactionNo=" + transactionNo + ", activeStatus=" + activeStatus + ", allowModi="
				+ allowModi + ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate + ", emiAmount=" + emiAmount
				+ ", emiStartDate=" + emiStartDate + ", interestType=" + interestType + ", issueDate=" + issueDate
				+ ", loanAmount=" + loanAmount + ", loanType=" + loanType + ", naration=" + naration + ", noOfEmi="
				+ noOfEmi + ", rateOfInterest=" + rateOfInterest + ", transactionDate=" + transactionDate + ", userId="
				+ userId + ", userIdUpdate=" + userIdUpdate + ", loanPendingAmount=" + loanPendingAmount
				+ ", settlementAmount=" + settlementAmount + ", paymentMode=" + paymentMode + ", instrumentNo="
				+ instrumentNo + ", remark=" + remark + ", isSettlementCompleted=" + isSettlementCompleted
				+ ", loanEmis=" + loanEmis + ", employee=" + employee + ", company=" + company + "]";
	}

}