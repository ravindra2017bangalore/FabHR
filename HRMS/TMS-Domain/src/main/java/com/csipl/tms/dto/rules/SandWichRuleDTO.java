package com.csipl.tms.dto.rules;

import java.util.Date;

public class SandWichRuleDTO {
	private static final long serialVersionUID = 1L;
	private Long sandWichId;
 	private byte holidayBeforeAfterWeekOffs;
	private byte holidayBetweenTwoAbsent;
	private Date dateUpdate;
 	private Long userId;
	private byte weekOffBeforeAfterWeekOffs;
	private byte weekOffBetweenTwoAbsent;
	private Long companyId;
 	private Date dateCreated;
	private Long userIdUpdate;

	public SandWichRuleDTO() {
	}

	public Long getSandWichId() {
		return sandWichId;
	}

	public void setSandWichId(Long sandWichId) {
		this.sandWichId = sandWichId;
	}
 

	public byte getHolidayBeforeAfterWeekOffs() {
		return holidayBeforeAfterWeekOffs;
	}

	public void setHolidayBeforeAfterWeekOffs(byte holidayBeforeAfterWeekOffs) {
		this.holidayBeforeAfterWeekOffs = holidayBeforeAfterWeekOffs;
	}

	public byte getHolidayBetweenTwoAbsent() {
		return holidayBetweenTwoAbsent;
	}

	public void setHolidayBetweenTwoAbsent(byte holidayBetweenTwoAbsent) {
		this.holidayBetweenTwoAbsent = holidayBetweenTwoAbsent;
	}

 
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public byte getWeekOffBeforeAfterWeekOffs() {
		return weekOffBeforeAfterWeekOffs;
	}

	public void setWeekOffBeforeAfterWeekOffs(byte weekOffBeforeAfterWeekOffs) {
		this.weekOffBeforeAfterWeekOffs = weekOffBeforeAfterWeekOffs;
	}

	public byte getWeekOffBetweenTwoAbsent() {
		return weekOffBetweenTwoAbsent;
	}

	public void setWeekOffBetweenTwoAbsent(byte weekOffBetweenTwoAbsent) {
		this.weekOffBetweenTwoAbsent = weekOffBetweenTwoAbsent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	@Override
	public String toString() {
		return "SandWichRuleDTO [sandWichId=" + sandWichId + ", holidayBeforeAfterWeekOffs="
				+ holidayBeforeAfterWeekOffs + ", holidayBetweenTwoAbsent=" + holidayBetweenTwoAbsent + ", dateUpdate="
				+ dateUpdate + ", userId=" + userId + ", weekOffBeforeAfterWeekOffs=" + weekOffBeforeAfterWeekOffs
				+ ", weekOffBetweenTwoAbsent=" + weekOffBetweenTwoAbsent + ", companyId=" + companyId + ", dateCreated="
				+ dateCreated + ", userIdUpdate=" + userIdUpdate + "]";
	}

 

}