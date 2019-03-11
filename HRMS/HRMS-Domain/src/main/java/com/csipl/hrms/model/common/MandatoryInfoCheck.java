
package com.csipl.hrms.model.common;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.employee.Employee;
import java.util.Date;

/**
 * The persistent class for the MandatoryInfoCheck database table.
 * 
 */
@Entity
@NamedQuery(name = "MandatoryInfoCheck.findAll", query = "SELECT m FROM MandatoryInfoCheck m")
public class MandatoryInfoCheck extends BaseModelWithoutCG implements Serializable {
	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mandatoryInfoCheckId;

	@Column(name = "AI")
	private String ai;

	@Column(name = "BA")
	private String ba;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	@Column(name = "ES")
	private String es;

	private String PA;

	private String PF;

	@Column(name = "NU")
	private String nu;

	@Column(name = "NA")
	private String na;

	@Column(name = "NM")
	private String nm;

	@Column(name = "MI")
	private String mi;

	@Column(name = "UA")
	private String ua;

	@Column(name = "UI")
	private String ui;

	private Long userId;

	private Long userIdUpdate;

	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	public MandatoryInfoCheck() {
	}

	public Long getMandatoryInfoCheckId() {
		return this.mandatoryInfoCheckId;
	}

	public void setMandatoryInfoCheckId(Long mandatoryInfoCheckId) {
		this.mandatoryInfoCheckId = mandatoryInfoCheckId;
	}

	public String getAi() {
		return this.ai;
	}

	public void setAi(String ai) {
		this.ai = ai;
	}

	public String getBa() {
		return this.ba;
	}

	public void setBa(String ba) {
		this.ba = ba;
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

	public String getEs() {
		return this.es;
	}

	public void setEs(String es) {
		this.es = es;
	}

	public String getMi() {
		return this.mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getUa() {
		return this.ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getUi() {
		return this.ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getPA() {
		return PA;
	}

	public void setPA(String pA) {
		PA = pA;
	}

	public String getPF() {
		return PF;
	}

	public void setPF(String pF) {
		PF = pF;
	}

	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getNa() {
		return na;
	}

	public void setNa(String na) {
		this.na = na;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

}