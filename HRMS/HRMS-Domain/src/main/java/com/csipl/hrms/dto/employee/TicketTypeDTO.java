package com.csipl.hrms.dto.employee;

import java.util.Date;
import java.util.List;

import com.csipl.hrms.model.employee.TicketRaisingHD;

public class TicketTypeDTO {

	private String email;

	private Long tat;

	private Long userId;
	
	private Long ticketTypeId;

	private String category;
	private Date dateCreated;
	private Long CompanyId;
	private long userIdUpdate;
	
	
	//List<TicketRaisingHD> ticketRaisingHds;

	
	

		public long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

		public Long getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(Long companyId) {
		CompanyId = companyId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTat() {
		return tat;
	}

	public void setTat(Long tat) {
		this.tat = tat;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(Long ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
