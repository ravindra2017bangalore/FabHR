package com.csipl.hrms.dto.employee;

import java.math.BigDecimal;
import java.util.Date;
 public class PayStructureDTO {
		private Long payStructureId;
		private Long payStructureHdId;
		private Long payHeadId;
		private String payHeadName;
		private BigDecimal amount;
		private Long userId;
		private Date dateCreated;
 		
	public Long getPayStructureId() {
		return payStructureId;
	}
	public Long getPayStructureHdId() {
		return payStructureHdId;
	}
	public Long getPayHeadId() {
		return payHeadId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setPayStructureId(Long payStructureId) {
		this.payStructureId = payStructureId;
	}
	public void setPayStructureHdId(Long payStructureHdId) {
		this.payStructureHdId = payStructureHdId;
	}
	public void setPayHeadId(Long payHeadId) {
		this.payHeadId = payHeadId;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPayHeadName() {
		return payHeadName;
	}
	public void setPayHeadName(String payHeadName) {
		this.payHeadName = payHeadName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
 
 
}



