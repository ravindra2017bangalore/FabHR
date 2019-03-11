package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TdsTransaction database table.
 * 
 */
@Entity
@NamedQuery(name="TdsTransaction.findAll", query="SELECT t FROM TdsTransaction t")
public class TdsTransaction extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsTransactionId;

	private String allowModi;

	private String approveStatus;

	private String fileLocation;

	private String financialYear;

	private BigDecimal investmentAmount;
	
	private BigDecimal approvedAmount;

	private String investmentDetail;

	private BigDecimal maxLimit;

	private int noOfDocuments;

	private String proof;
	
	private String status;
	
	public BigDecimal getBasicDA() {
		return basicDA;
	}

	public void setBasicDA(BigDecimal basicDA) {
		this.basicDA = basicDA;
	}

	private String city;
	
	private BigDecimal basicDA;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	private String activeStatus;


	//bi-directional many-to-one association to TdsSection
	@ManyToOne
	@JoinColumn(name="tdsSectionId")
	private TdsSection tdsSection;

	//bi-directional many-to-one association to TdsGroup
	@ManyToOne
	@JoinColumn(name="tdsGroupId")
	private TdsGroup tdsGroup;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public TdsTransaction() {
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getApproveStatus() {
		return this.approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getInvestmentAmount() {
		return this.investmentAmount;
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
		return this.investmentDetail;
	}

	public void setInvestmentDetail(String investmentDetail) {
		this.investmentDetail = investmentDetail;
	}

	public BigDecimal getMaxLimit() {
		return this.maxLimit;
	}

	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}

	public int getNoOfDocuments() {
		return this.noOfDocuments;
	}

	public void setNoOfDocuments(int noOfDocuments) {
		this.noOfDocuments = noOfDocuments;
	}

	public String getProof() {
		return this.proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public TdsSection getTdsSection() {
		return this.tdsSection;
	}

	public void setTdsSection(TdsSection tdsSection) {
		this.tdsSection = tdsSection;
	}

	public TdsGroup getTdsGroup() {
		return this.tdsGroup;
	}

	public void setTdsGroup(TdsGroup tdsGroup) {
		this.tdsGroup = tdsGroup;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getTdsTransactionId() {
		return tdsTransactionId;
	}

	public void setTdsTransactionId(Long tdsTransactionId) {
		this.tdsTransactionId = tdsTransactionId;
	}

}