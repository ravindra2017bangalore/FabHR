package com.csipl.hrms.model.payroll;



import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TdsApproved database table.
 * 
 */
@Entity
@NamedQuery(name="TdsApproved.findAll", query="SELECT t FROM TdsApproved t")
public class TdsApproved implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionId;

	private BigDecimal approvedAmount;

	private BigDecimal limitAmount;

	private BigDecimal proofAmount;

	//bi-directional many-to-one association to TdsGroup
	@ManyToOne
	@JoinColumn(name="tdsGroupId")
	private TdsGroup tdsGroup;

	//bi-directional many-to-one association to TransactionApprovedHd
	@ManyToOne
	@JoinColumn(name="transactionApprovedHdId")
	private TransactionApprovedHd transactionApprovedHd;

	public TdsApproved() {
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getApprovedAmount() {
		return this.approvedAmount;
	}

	public void setApprovedAmount(BigDecimal approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public BigDecimal getLimitAmount() {
		return this.limitAmount;
	}

	public void setLimitAmount(BigDecimal limitAmount) {
		this.limitAmount = limitAmount;
	}

	public BigDecimal getProofAmount() {
		return this.proofAmount;
	}

	public void setProofAmount(BigDecimal proofAmount) {
		this.proofAmount = proofAmount;
	}

	public TdsGroup getTdsGroup() {
		return this.tdsGroup;
	}

	public void setTdsGroup(TdsGroup tdsGroup) {
		this.tdsGroup = tdsGroup;
	}

	public TransactionApprovedHd getTransactionApprovedHd() {
		return this.transactionApprovedHd;
	}

	public void setTransactionApprovedHd(TransactionApprovedHd transactionApprovedHd) {
		this.transactionApprovedHd = transactionApprovedHd;
	}

}