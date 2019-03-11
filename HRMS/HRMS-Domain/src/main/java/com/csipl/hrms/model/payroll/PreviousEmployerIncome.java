package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PreviousEmployerIncome database table.
 * 
 */
@Entity
@NamedQuery(name="PreviousEmployerIncome.findAll", query="SELECT p FROM PreviousEmployerIncome p")
public class PreviousEmployerIncome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long previousEmployerIncomeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String particular;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to PreviousEmployerIncomeTd
	@OneToMany(mappedBy="previousEmployerIncome")
	private List<PreviousEmployerIncomeTds> previousEmployerIncomeTds;

	public PreviousEmployerIncome() {
	}

	public Long getPreviousEmployerIncomeId() {
		return previousEmployerIncomeId;
	}

	public void setPreviousEmployerIncomeId(Long previousEmployerIncomeId) {
		this.previousEmployerIncomeId = previousEmployerIncomeId;
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

	public String getParticular() {
		return this.particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public List<PreviousEmployerIncomeTds> getPreviousEmployerIncomeTds() {
		return this.previousEmployerIncomeTds;
	}

	public void setPreviousEmployerIncomeTds(List<PreviousEmployerIncomeTds> previousEmployerIncomeTds) {
		this.previousEmployerIncomeTds = previousEmployerIncomeTds;
	}

	public PreviousEmployerIncomeTds addPreviousEmployerIncomeTd(PreviousEmployerIncomeTds previousEmployerIncomeTd) {
		getPreviousEmployerIncomeTds().add(previousEmployerIncomeTd);
		previousEmployerIncomeTd.setPreviousEmployerIncome(this);

		return previousEmployerIncomeTd;
	}

	public PreviousEmployerIncomeTds removePreviousEmployerIncomeTd(PreviousEmployerIncomeTds previousEmployerIncomeTd) {
		getPreviousEmployerIncomeTds().remove(previousEmployerIncomeTd);
		previousEmployerIncomeTd.setPreviousEmployerIncome(null);

		return previousEmployerIncomeTd;
	}

}
