package com.csipl.hrms.model.employee;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EmployeeAssets database table.
 * 
 */
@Entity
@Table(name="EmployeeAssets")
@NamedQuery(name="EmployeeAsset.findAll", query="SELECT e FROM EmployeeAsset e")
public class EmployeeAsset extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeAssetsId;

	private String activeStatus;

	private String allowModi;

	private BigDecimal amount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	private Date dateTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String issueDescription;

	private Long quantity;

	

	//bi-directional many-to-one association to Employee
	/*@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;*/
    private Long employeeId;
	//bi-directional many-to-one association to Item
/*	@ManyToOne
	@JoinColumn(name="itemId")
	private Item item;*/
    private Long itemId;
	public EmployeeAsset() {
	}

	public Long getEmployeeAssetsId() {
		return this.employeeAssetsId;
	}

	public void setEmployeeAssetsId(Long employeeAssetsId) {
		this.employeeAssetsId = employeeAssetsId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getIssueDescription() {
		return this.issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	
}