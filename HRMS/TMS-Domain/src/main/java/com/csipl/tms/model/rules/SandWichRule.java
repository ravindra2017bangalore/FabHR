package com.csipl.tms.model.rules;
import java.io.Serializable;
import javax.persistence.*;

//import com.csipl.hrms.common.model.Company;

import java.util.Date;


/**
 * The persistent class for the SandWichRules database table.
 * 
 */
@Entity
@Table(name="TMSSandWichRules")
@NamedQuery(name="SandWichRule.findAll", query="SELECT s FROM SandWichRule s")
public class SandWichRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sandWichId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private byte holidayBeforeAfterWeekOffs;

	private byte holidayBetweenTwoAbsent;

	private Long userId;

	private Long userIdUpdate;

	private byte weekOffBeforeAfterWeekOffs;

	private byte weekOffBetweenTwoAbsent;

	//bi-directional many-to-one association to Company
	/* @ManyToOne
	@JoinColumn(name="companyId")
	private Company company; */

	private Long companyId;
	
	public SandWichRule() {
	}

	public Long getSandWichId() {
		return this.sandWichId;
	}

	public void setSandWichId(Long sandWichId) {
		this.sandWichId = sandWichId;
	}

 

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public byte getHolidayBeforeAfterWeekOffs() {
		return this.holidayBeforeAfterWeekOffs;
	}

	public void setHolidayBeforeAfterWeekOffs(byte holidayBeforeAfterWeekOffs) {
		this.holidayBeforeAfterWeekOffs = holidayBeforeAfterWeekOffs;
	}

	public byte getHolidayBetweenTwoAbsent() {
		return this.holidayBetweenTwoAbsent;
	}

	public void setHolidayBetweenTwoAbsent(byte holidayBetweenTwoAbsent) {
		this.holidayBetweenTwoAbsent = holidayBetweenTwoAbsent;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public byte getWeekOffBeforeAfterWeekOffs() {
		return this.weekOffBeforeAfterWeekOffs;
	}

	public void setWeekOffBeforeAfterWeekOffs(byte weekOffBeforeAfterWeekOffs) {
		this.weekOffBeforeAfterWeekOffs = weekOffBeforeAfterWeekOffs;
	}

	public byte getWeekOffBetweenTwoAbsent() {
		return this.weekOffBetweenTwoAbsent;
	}

	public void setWeekOffBetweenTwoAbsent(byte weekOffBetweenTwoAbsent) {
		this.weekOffBetweenTwoAbsent = weekOffBetweenTwoAbsent;
	}

	/*public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

	@Override
	public String toString() {
		return "SandWichRule [sandWichId=" + sandWichId + ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate
				+ ", holidayBeforeAfterWeekOffs=" + holidayBeforeAfterWeekOffs + ", holidayBetweenTwoAbsent="
				+ holidayBetweenTwoAbsent + ", userId=" + userId + ", userIdUpdate=" + userIdUpdate
				+ ", weekOffBeforeAfterWeekOffs=" + weekOffBeforeAfterWeekOffs + ", weekOffBetweenTwoAbsent="
				+ weekOffBetweenTwoAbsent + ", company=]";
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}