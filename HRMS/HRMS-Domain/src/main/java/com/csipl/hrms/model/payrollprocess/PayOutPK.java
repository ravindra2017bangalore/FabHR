package com.csipl.hrms.model.payrollprocess;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PayOut database table.
 * 
 */
@Embeddable
public class PayOutPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String processMonth;

	@Column(insertable=false, updatable=false)
	private Long employeeId;
	
	private long payHeadId;

	public PayOutPK() {
	}
	public String getProcessMonth() {
		return this.processMonth;
	}
	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}
	public Long getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public long getPayHeadId() {
		return this.payHeadId;
	}
	public void setPayHeadId(long payHeadId) {
		this.payHeadId = payHeadId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PayOutPK)) {
			return false;
		}
		PayOutPK castOther = (PayOutPK)other;
		return 
				this.processMonth.equals(castOther.processMonth)
				&& (this.employeeId == castOther.employeeId)
				&& (this.payHeadId == castOther.payHeadId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.processMonth.hashCode();
		hash = (int) (hash * prime + this.employeeId);
		hash = (int) (hash * prime + this.payHeadId);
		
		return hash;
	}
}