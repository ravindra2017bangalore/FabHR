package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TdsSubSection database table.
 * 
 */
@Entity
@NamedQuery(name="TdsSubSection.findAll", query="SELECT t FROM TdsSubSection t")
public class TdsSubSection    implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tdsSubSectionId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String tdsSubSectionName;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to TdsSection
	@ManyToOne
	@JoinColumn(name="tdsSectionId")
	private TdsSection tdsSection;

	/*//bi-directional many-to-one association to TdsTransaction
	@OneToMany(mappedBy="tdsSubSection")
	private List<TdsTransaction> tdsTransactions;*/

	public TdsSubSection() {
	}

	public Long getTdsSubSectionId() {
		return this.tdsSubSectionId;
	}

	public void setTdsSubSectionId(Long tdsSubSectionId) {
		this.tdsSubSectionId = tdsSubSectionId;
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

	public String getTdsSubSectionName() {
		return this.tdsSubSectionName;
	}

	public void setTdsSubSectionName(String tdsSubSectionName) {
		this.tdsSubSectionName = tdsSubSectionName;
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

	public TdsSection getTdsSection() {
		return this.tdsSection;
	}

	public void setTdsSection(TdsSection tdsSection) {
		this.tdsSection = tdsSection;
	}

	/*public List<TdsTransaction> getTdsTransactions() {
		return this.tdsTransactions;
	}

	public void setTdsTransactions(List<TdsTransaction> tdsTransactions) {
		this.tdsTransactions = tdsTransactions;
	}*/

	/*public TdsTransaction addTdsTransaction(TdsTransaction tdsTransaction) {
		getTdsTransactions().add(tdsTransaction);
		tdsTransaction.setTdsSubSection(this);

		return tdsTransaction;
	}

	public TdsTransaction removeTdsTransaction(TdsTransaction tdsTransaction) {
		getTdsTransactions().remove(tdsTransaction);
		tdsTransaction.setTdsSubSection(null);

		return tdsTransaction;
	}*/

}