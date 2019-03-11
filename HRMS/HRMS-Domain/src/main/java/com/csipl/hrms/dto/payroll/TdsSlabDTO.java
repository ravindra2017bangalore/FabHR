package com.csipl.hrms.dto.payroll;

import java.math.BigDecimal;
import java.util.Date;
 
public class TdsSlabDTO {

	private Long tdsSLabId;
	private BigDecimal limitFrom;
	private BigDecimal limitTo;
	private BigDecimal tdsPercentage;
	private Long userId;
	private Date dateCreated;
	private Long userIdUpdate;
	 
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
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

	public Long getTdsSLabId() {
		return tdsSLabId;
	}

	public void setTdsSLabId(Long tdsSLabId) {
		this.tdsSLabId = tdsSLabId;
	}

	public BigDecimal getLimitFrom() {
		return limitFrom;
	}

	public void setLimitFrom(BigDecimal limitFrom) {
		this.limitFrom = limitFrom;
	}

	public BigDecimal getLimitTo() {
		return limitTo;
	}

	public void setLimitTo(BigDecimal limitTo) {
		this.limitTo = limitTo;
	}

	public BigDecimal getTdsPercentage() {
		return tdsPercentage;
	}

	public void setTdsPercentage(BigDecimal tdsPercentage) {
		this.tdsPercentage = tdsPercentage;
	}

	@Override
	public String toString() {
		return "TdsSlabDTO [tdsSLabId=" + tdsSLabId + ", limitFrom=" + limitFrom + ", limitTo=" + limitTo
				+ ", tdsPercentage=" + tdsPercentage + "]";
	}

}
