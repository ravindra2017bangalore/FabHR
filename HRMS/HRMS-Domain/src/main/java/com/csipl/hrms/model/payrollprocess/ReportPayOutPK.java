package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ReportPayOut database table.
 * 
 */
@Embeddable
public class ReportPayOutPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String processMonth;

	@Column(insertable=false, updatable=false)
	private Long employeeId;

	public ReportPayOutPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReportPayOutPK)) {
			return false;
		}
		ReportPayOutPK castOther = (ReportPayOutPK)other;
		return 
			this.processMonth.equals(castOther.processMonth)
			&& (this.employeeId == castOther.employeeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.processMonth.hashCode();
		hash = (int) (hash * prime + this.employeeId);
		
		return hash;
	}
}