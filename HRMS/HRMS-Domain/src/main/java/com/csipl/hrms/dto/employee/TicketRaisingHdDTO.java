package com.csipl.hrms.dto.employee;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.TicketType;

public class TicketRaisingHdDTO {
	private Long ticketRaisingHDId;
	private String title;
	private Long createdBy;
	private Long userId;
	private String dateCreated;
	private Long ticketTypeId;
	private String category;
	private String description;
	private String comment;
	private String status;
	private String ticketNo;
	private List<TicketDescDTO> ticketDescs;
	private Long employeeId;
	private String employeeCode;
	private String employeeName;
	private String user;
	private Long tat;
	private Long companyId;
	private Long userIdUpdate;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getTicketRaisingHDId() {
		return ticketRaisingHDId;
	}
	public void setTicketRaisingHDId(Long ticketRaisingHDId) {
		this.ticketRaisingHDId = ticketRaisingHDId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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
	public List<TicketDescDTO> getTicketDescs() {
		return ticketDescs;
	}
	public void setTicketDescs(List<TicketDescDTO> ticketDescs) {
		this.ticketDescs = ticketDescs;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public Long getTat() {
		return tat;
	}
	public void setTat(Long tat) {
		this.tat = tat;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
