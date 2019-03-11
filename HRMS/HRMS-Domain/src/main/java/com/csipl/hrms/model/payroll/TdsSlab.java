package com.csipl.hrms.model.payroll;


import java.io.Serializable;
import javax.persistence.*;

 import com.csipl.hrms.model.BaseModelWithoutCG;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TdsSlab database table.
 * 
 */
@Entity
@NamedQuery(name="TdsSlab.findAll", query="SELECT t FROM TdsSlab t")
public class TdsSlab extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsSLabId;

	private String allowModi;

 
	private BigDecimal limitFrom;

	private BigDecimal limitTo;

	private BigDecimal tdsPercentage;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to TdsPayroll
	@OneToMany(mappedBy="tdsSlab")
	private List<TdsPayroll> tdsPayrolls;

	//bi-directional many-to-one association to TdsSlabHd
	@ManyToOne
	@JoinColumn(name="tdsSLabHdId")
	private TdsSlabHd tdsSlabHd;

	public TdsSlab() {
	}

	public Long getTdsSLabId() {
		return this.tdsSLabId;
	}

	public void setTdsSLabId(Long tdsSLabId) {
		this.tdsSLabId = tdsSLabId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
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

	public BigDecimal getTdsPercentage() {
		return this.tdsPercentage;
	}

	public void setTdsPercentage(BigDecimal tdsPercentage) {
		this.tdsPercentage = tdsPercentage;
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

	public List<TdsPayroll> getTdsPayrolls() {
		return this.tdsPayrolls;
	}

	public void setTdsPayrolls(List<TdsPayroll> tdsPayrolls) {
		this.tdsPayrolls = tdsPayrolls;
	}

	public TdsPayroll addTdsPayroll(TdsPayroll tdsPayroll) {
		getTdsPayrolls().add(tdsPayroll);
		tdsPayroll.setTdsSlab(this);

		return tdsPayroll;
	}

	public TdsPayroll removeTdsPayroll(TdsPayroll tdsPayroll) {
		getTdsPayrolls().remove(tdsPayroll);
		tdsPayroll.setTdsSlab(null);

		return tdsPayroll;
	}

	public TdsSlabHd getTdsSlabHd() {
		return this.tdsSlabHd;
	}

	public void setTdsSlabHd(TdsSlabHd tdsSlabHd) {
		this.tdsSlabHd = tdsSlabHd;
	}

}