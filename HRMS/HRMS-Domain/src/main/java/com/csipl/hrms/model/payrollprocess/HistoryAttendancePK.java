package com.csipl.hrms.model.payrollprocess;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HistoryAttendance database table.
 * 
 */
@Embeddable
public class HistoryAttendancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String processMonth;

	private int employeeId;

	public HistoryAttendancePK() {
	}
	public String getProcessMonth() {
		return this.processMonth;
	}
	public void setProcessMonth(String processMonth) {
		this.processMonth = processMonth;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HistoryAttendancePK)) {
			return false;
		}
		HistoryAttendancePK castOther = (HistoryAttendancePK)other;
		return 
			this.processMonth.equals(castOther.processMonth)
			&& (this.employeeId == castOther.employeeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.processMonth.hashCode();
		hash = hash * prime + this.employeeId;
		
		return hash;
	}
}