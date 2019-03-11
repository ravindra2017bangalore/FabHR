package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.BaseModelWithoutGroup;


/**
 * The persistent class for the TdsStandardExemption database table.
 * 
 */
@Entity
@NamedQuery(name="TdsStandardExemption.findAll", query="SELECT t FROM TdsStandardExemption t")
public class TdsStandardExemption extends BaseModelWithoutGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsStandardExemptionId;

	private BigDecimal amount;

	private String financialYear;

	public TdsStandardExemption() {
	}

	public Long getTdsStandardExemptionId() {
		return tdsStandardExemptionId;
	}

	public void setTdsStandardExemptionId(Long tdsStandardExemptionId) {
		this.tdsStandardExemptionId = tdsStandardExemptionId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

}
