package com.csipl.hrms.model.payroll;



import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TdsPayroll database table.
 * 
 */
@Entity
@NamedQuery(name="TdsPayroll.findAll", query="SELECT t FROM TdsPayroll t")
public class TdsPayroll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionId;

	private BigDecimal actualAmount;

	private BigDecimal limitFrom;

	private BigDecimal limitTo;

	private BigDecimal taxAmouunt;

	private BigDecimal tdsPercentage;

	//bi-directional many-to-one association to TdsSlab
	@ManyToOne
	@JoinColumn(name="tdsSLabId")
	private TdsSlab tdsSlab;

	//bi-directional many-to-one association to TdsPayrollHd
	@ManyToOne
	@JoinColumn(name="transactionHdId")
	private TdsPayrollHd tdsPayrollHd;

	public TdsPayroll() {
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getActualAmount() {
		return this.actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}


	public BigDecimal getLimitFrom() {
		return this.limitFrom;
	}

	public void setLimitFrom(BigDecimal limitFrom) {
		this.limitFrom = limitFrom;
	}

	public BigDecimal getLimitTo() {
		return this.limitTo;
	}

	public void setLimitTo(BigDecimal limitTo) {
		this.limitTo = limitTo;
	}

	public BigDecimal getTaxAmouunt() {
		return this.taxAmouunt;
	}

	public void setTaxAmouunt(BigDecimal taxAmouunt) {
		this.taxAmouunt = taxAmouunt;
	}

	public BigDecimal getTdsPercentage() {
		return this.tdsPercentage;
	}

	public void setTdsPercentage(BigDecimal tdsPercentage) {
		this.tdsPercentage = tdsPercentage;
	}

	public TdsSlab getTdsSlab() {
		return this.tdsSlab;
	}

	public void setTdsSlab(TdsSlab tdsSlab) {
		this.tdsSlab = tdsSlab;
	}

	public TdsPayrollHd getTdsPayrollHd() {
		return this.tdsPayrollHd;
	}

	public void setTdsPayrollHd(TdsPayrollHd tdsPayrollHd) {
		this.tdsPayrollHd = tdsPayrollHd;
	}

}