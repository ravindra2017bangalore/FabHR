package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.common.Company;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TicketRaisingHD database table.
 * 
 */
@Entity
@NamedQuery(name="TicketRaisingHD.findAll", query="SELECT t FROM TicketRaisingHD t")
public class TicketRaisingHD extends BaseModelWithoutGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ticketRaisingHDId;

	private Long createdBy;

/*	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;*/

	private String status;

	private String ticketNo;

	//bi-directional many-to-one association to TicketType
	@ManyToOne
	@JoinColumn(name="ticketTypeId")
	private TicketType ticketType;

	
	private String title;
/*
	private Long userId;

	private Long userIdUpdate;*/

	//bi-directional many-to-one association to TicketDesc
	@OneToMany(mappedBy="ticketRaisingHd" , cascade = CascadeType.ALL)
	private List<TicketDesc> ticketDescs;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	//bi-directional many-to-one association to Company
	/*@ManyToOne
	@JoinColumn(name="companyID")
	private Company company;*/

	public TicketRaisingHD() {
	}

	public Long getTicketRaisingHDId() {
		return this.ticketRaisingHDId;
	}

	public void setTicketRaisingHDId(Long ticketRaisingHDId) {
		this.ticketRaisingHDId = ticketRaisingHDId;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/*public Date getDateCreated() {
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
*/
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTicketNo() {
		return this.ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {rr
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}*/

	public List<TicketDesc> getTicketDescs() {
		return this.ticketDescs;
	}

	public void setTicketDescs(List<TicketDesc> ticketDescs) {
		this.ticketDescs = ticketDescs;
	}

	public TicketDesc addTicketDesc(TicketDesc ticketDesc) {
		getTicketDescs().add(ticketDesc);
		ticketDesc.setTicketRaisingHd(this);

		return ticketDesc;
	}

	public TicketDesc removeTicketDesc(TicketDesc ticketDesc) {
		getTicketDescs().remove(ticketDesc);
		ticketDesc.setTicketRaisingHd(null);

		return ticketDesc;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "TicketRaisingHD [ticketRaisingHDId=" + ticketRaisingHDId + ", createdBy=" + createdBy + ", status="
				+ status + ", ticketNo=" + ticketNo + ", ticketType=" + ticketType + ", title=" + title
				+ ", ticketDescs=" + ticketDescs + ", employee=" + employee + "]";
	}

/*	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
*/
}