package com.csipl.tms.model.weekofpattern;

import java.io.Serializable;
import javax.persistence.*;

//import com.csipl.hrms.common.model.Company;

import java.util.Date;

/**
 * The persistent class for the `WeekOffPattern` database table.
 * 
 */
@Entity
@Table(name = "TMSWeekOffPattern")
@NamedQuery(name = "WeekOffPattern.findAll", query = "SELECT w FROM WeekOffPattern w")
public class WeekOffPattern implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patternId;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private String day;

	private String patternName;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private Long updateUserId;

	private Long userId;
	private String activeStatus;
	// bi-directional many-to-one association to Company

/*	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
*/
	private Long companyId;
	
	public WeekOffPattern() {
	}

	public Long getPatternId() {
		return this.patternId;
	}

	public void setPatternId(Long patternId) {
		this.patternId = patternId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPatternName() {
		return this.patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Long getUserId() {
		return this.userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "WeekOffPattern [patternId=" + patternId + ", createdDate=" + createdDate + ", day=" + day
				+ ", patternName=" + patternName + ", updatedDate=" + updatedDate + ", updateUserId=" + updateUserId
				+ ", userId=" + userId + ", companyId=" + companyId + "]";
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

/*	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

}