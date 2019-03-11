package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PayRollLock database table.
 * 
 */
@Embeddable
public class PayRollLockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Long departmentId;

	private String processMonth;

	public PayRollLockPK() {
	}
	public Long getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getProcessMonth() {
		return this.processMonth;
	}
	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PayRollLockPK)) {
			return false;
		}
		PayRollLockPK castOther = (PayRollLockPK)other;
		return 
			(this.departmentId == castOther.departmentId)
			&& this.processMonth.equals(castOther.processMonth);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = (int)(hash * prime + this.departmentId);
		hash = hash * prime + this.processMonth.hashCode();
		
		return hash;
	}
}