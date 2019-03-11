package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.util.Date;


/**
 * The persistent class for the PayrollControl database table.
 * 
 */
@Entity
@NamedQuery(name="PayrollControl.findAll", query="SELECT p FROM PayrollControl p")
public class PayrollControl extends BaseModelWithoutCG  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long controlId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private int groupId;

	private int payrollDays;

	private String processMonth;

	

	//bi-directional many-to-one association to FinancialYear
	@ManyToOne
	@JoinColumn(name="financialYearId")
	private FinancialYear financialYear;

	public PayrollControl() {
	}

	public Long getControlId() {
		return this.controlId;
	}

	public void setControlId(Long controlId) {
		this.controlId = controlId;
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

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getPayrollDays() {
		return this.payrollDays;
	}

	public void setPayrollDays(int payrollDays) {
		this.payrollDays = payrollDays;
	}

	public String getProcessMonth() {
		return this.processMonth;
	}

	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}



	public FinancialYear getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}

	
}