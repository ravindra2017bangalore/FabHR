package com.csipl.hrms.model.employee;
 
import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.payroll.PayHead;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PayStructure database table.
 * 
 */
@Entity
@NamedQuery(name="PayStructure.findAll", query="SELECT p FROM PayStructure p")
public class PayStructure extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long payStructureId;

	private String allowModi;

	private BigDecimal amount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to PayHead
	@ManyToOne
	@JoinColumn(name="payHeadId")
	private PayHead payHead;

	//bi-directional many-to-one association to PayStructureHd
	@ManyToOne
	@JoinColumn(name="payStructureHdId")
	private PayStructureHd payStructureHd;

	public PayStructure() {
	}

	public Long getPayStructureId() {
		return this.payStructureId;
	}

	public void setPayStructureId(Long payStructureId) {
		this.payStructureId = payStructureId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public PayHead getPayHead() {
		return this.payHead;
	}

	public void setPayHead(PayHead payHead) {
		this.payHead = payHead;
	}

	public PayStructureHd getPayStructureHd() {
		return this.payStructureHd;
	}

	public void setPayStructureHd(PayStructureHd payStructureHd) {
		this.payStructureHd = payStructureHd;
	}

}