package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.organisation.Grade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the PayStructureHd database table.
 * 
 */
@Entity
@NamedQuery(name = "PayStructureHd.findAll", query = "SELECT p FROM PayStructureHd p")
public class PayStructureHd extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payStructureHdId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateEnd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private BigDecimal grossPay;
	
	private BigDecimal costToCompany;

	private Long userId;

	private Long userIdUpdate;

	private String isNoPFDeduction;

	
	@Transient
	 private  boolean updateFlage;
	
	// bi-directional many-to-one association to PayStructure
	@OneToMany(mappedBy = "payStructureHd", cascade = CascadeType.ALL)
 	private List<PayStructure> payStructures;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	// bi-directional many-to-one association to Grade
	@ManyToOne
	@JoinColumn(name = "gradesId")
	private Grade grade;

	public PayStructureHd() {
	}

	public Long getPayStructureHdId() {
		return this.payStructureHdId;
	}

	public void setPayStructureHdId(Long payStructureHdId) {
		this.payStructureHdId = payStructureHdId;
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

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public BigDecimal getGrossPay() {
		return this.grossPay;
	}

	public void setGrossPay(BigDecimal grossPay) {
		this.grossPay = grossPay;
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

	public List<PayStructure> getPayStructures() {
		return this.payStructures;
	}

	public void setPayStructures(List<PayStructure> payStructures) {
		this.payStructures = payStructures;
	}

	public PayStructure addPayStructure(PayStructure payStructure) {
		getPayStructures().add(payStructure);
		payStructure.setPayStructureHd(this);

		return payStructure;
	}

	public PayStructure removePayStructure(PayStructure payStructure) {
		getPayStructures().remove(payStructure);
		payStructure.setPayStructureHd(null);

		return payStructure;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public boolean isUpdateFlage() {
		return updateFlage;
	}

	public void setUpdateFlage(boolean updateFlage) {
		this.updateFlage = updateFlage;
	}

	public BigDecimal getCostToCompany() {
		return costToCompany;
	}

	public void setCostToCompany(BigDecimal costToCompany) {
		this.costToCompany = costToCompany;
	}

	public String getIsNoPFDeduction() {
		return isNoPFDeduction;
	}

	public void setIsNoPFDeduction(String isNoPFDeduction) {
		this.isNoPFDeduction = isNoPFDeduction;
	}

}