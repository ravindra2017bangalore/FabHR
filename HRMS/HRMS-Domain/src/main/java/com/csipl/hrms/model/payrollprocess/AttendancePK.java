package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Attendance database table.
 * 
 */
@Embeddable
public class AttendancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String employeeCode;

	private String processMonth;

	public AttendancePK() {
	}
	public String getEmployeeCode() {
		return this.employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
		if (!(other instanceof AttendancePK)) {
			return false;
		}
		AttendancePK castOther = (AttendancePK)other;
		return 
			this.employeeCode.equals(castOther.employeeCode)
			&& this.processMonth.equals(castOther.processMonth);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.employeeCode.hashCode();
		hash = hash * prime + this.processMonth.hashCode();
		
		return hash;
	}
}