package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FinancialYear database table.
 * 
 */
@Entity
@NamedQuery(name="FinancialYear.findAll", query="SELECT f FROM FinancialYear f")
public class FinancialYear  extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long financialYearId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	private Date dateTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String financialYear;


	private String isPayrollDaysManuals;

	//bi-directional many-to-one association to Company
	
	//bi-directional many-to-one association to PayrollControl
	@OneToMany(mappedBy="financialYear", cascade = CascadeType.ALL)
	private List<PayrollControl> payrollControls;

	public FinancialYear() {
	}

	public Long getFinancialYearId() {
		return this.financialYearId;
	}

	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
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

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	

	public String getIsPayrollDaysManuals() {
		return this.isPayrollDaysManuals;
	}

	public void setIsPayrollDaysManuals(String isPayrollDaysManuals) {
		this.isPayrollDaysManuals = isPayrollDaysManuals;
	}

	
	public List<PayrollControl> getPayrollControls() {
		return this.payrollControls;
	}

	public void setPayrollControls(List<PayrollControl> payrollControls) {
		this.payrollControls = payrollControls;
	}

	public PayrollControl addPayrollControl(PayrollControl payrollControl) {
		getPayrollControls().add(payrollControl);
		payrollControl.setFinancialYear(this);

		return payrollControl;
	}

	public PayrollControl removePayrollControl(PayrollControl payrollControl) {
		getPayrollControls().remove(payrollControl);
		payrollControl.setFinancialYear(null);

		return payrollControl;
	}

	

}