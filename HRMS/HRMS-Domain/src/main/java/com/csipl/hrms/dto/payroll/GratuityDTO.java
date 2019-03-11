package com.csipl.hrms.dto.payroll;

import java.util.Date;

public class GratuityDTO {
	
		private Long gratuityId;
		private Date effectiveDate;
		private Long noOfDays;
		private Long noOfDaysDevide;
		private Long noOfMonths;
		private String activeStatus;
		private Long userId;
		private Long userIdUpdate;
		private Long companyId;

		
		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		public Long getUserIdUpdate() {
			return userIdUpdate;
		}
		public void setUserIdUpdate(Long userIdUpdate) {
			this.userIdUpdate = userIdUpdate;
		}
		private Date dateCreated;
		public String getActiveStatus() {
			return activeStatus;
		}
		public void setActiveStatus(String activeStatus) {
			this.activeStatus = activeStatus;
		}
		public Long getGratuityId() {
			return gratuityId;
		}
		public void setGratuityId(Long gratuityId) {
			this.gratuityId = gratuityId;
		}
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		public void setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
		}
		public Long getNoOfDays() {
			return noOfDays;
		}
		public void setNoOfDays(Long noOfDays) {
			this.noOfDays = noOfDays;
		}
		public Long getNoOfDaysDevide() {
			return noOfDaysDevide;
		}
		public void setNoOfDaysDevide(Long noOfDaysDevide) {
			this.noOfDaysDevide = noOfDaysDevide;
		}
		public Long getNoOfMonths() {
			return noOfMonths;
		}
		public void setNoOfMonths(Long noOfMonths) {
			this.noOfMonths = noOfMonths;
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