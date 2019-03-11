package com.csipl.hrms.model.organisation;


import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.payroll.PayHead;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GradesPayDefinition database table.
 * 
 */
@Entity
@NamedQuery(name="GradesPayDefinition.findAll", query="SELECT g FROM GradesPayDefinition g")
public class GradesPayDefinition extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long gradesPayId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private BigDecimal percenatage;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Grade
	@ManyToOne
	@JoinColumn(name="gradesId")
	private Grade grade;

	//bi-directional many-to-one association to PayHead
	@ManyToOne
	@JoinColumn(name="payHeadId")
	private PayHead payHead;

	public GradesPayDefinition() {
	}

	public Long getGradesPayId() {
		return this.gradesPayId;
	}

	public void setGradesPayId(Long gradesPayId) {
		this.gradesPayId = gradesPayId;
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

	public BigDecimal getPercenatage() {
		return this.percenatage;
	}

	public void setPercenatage(BigDecimal percenatage) {
		this.percenatage = percenatage;
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

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public PayHead getPayHead() {
		return this.payHead;
	}

	public void setPayHead(PayHead payHead) {
		this.payHead = payHead;
	}

}