package com.csipl.tms.dto.leave;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeNominee;
import com.csipl.tms.model.leave.TMSLeaveEntry;
import com.csipl.tms.model.leave.TMSLeavePeriod;
import com.csipl.tms.model.leave.TMSLeaveTypeMaster;

import io.swagger.annotations.ApiModelProperty;

public class LeaveBalanceSummryDTO {

	private Long leaveId;
	private String activeStatus;

	private Long carryForwardLimit;

	private Long companyId;

	private Long indexDays;

	private String isLeaveInProbation;

	private byte isWeekOffAsPL;

	private Long leaveFrequencyInMonth;

	private String leaveMode;

	private String leaveName;

	private Long maxLeaveInMonth;
	private String nature;

	private Long notice;

	private Long weekOffAsPLCount;

	private Long yearlyLimit;
	private BigDecimal leaveConsumedCount;
	private Long carryForwordLeave;
	private BigDecimal leaveBalancedCount;
	private Long totalLeave;
	private Long sumTotalLeave;
	private Long sumLeaveConsumed;
	private Long sumBalancedCount;
	private Long tmsleavePeriodId;
	private String tmsleavePeriodName;

	private Long tmsleaveTypeMasterId;
	private String tmsleaveTypeMasterName;
	private Date fromDate;
	private Date toDate;
	private Long userId;
	private Long leaveAppliedDays;

	private Long approvalId;
	private String approvalRemark;
	private BigDecimal days;
	private Long employeeId;
	private String employeeRemark;
	private String half_fullDay;
	private String halfDayFor;
	private String leaveType;
	private String status;
	private String statusValue;
	private int leaveCount;
	private String cancleRemark;
	private Long leaveTypeId;
	private Date dateCreated;
	private String employeeCode;
	private Long userIdUpdate;
	private List<Employee> notifyEmployeeList;
	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCarryForwardLimit() {
		return carryForwardLimit;
	}

	public Long getSumBalancedCount() {
		return sumBalancedCount;
	}

	public void setSumBalancedCount(Long sumBalancedCount) {
		this.sumBalancedCount = sumBalancedCount;
	}

	public void setCarryForwardLimit(Long carryForwardLimit) {
		this.carryForwardLimit = carryForwardLimit;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getIndexDays() {
		return indexDays;
	}

	public void setIndexDays(Long indexDays) {
		this.indexDays = indexDays;
	}

	public String getIsLeaveInProbation() {
		return isLeaveInProbation;
	}

	public void setIsLeaveInProbation(String isLeaveInProbation) {
		this.isLeaveInProbation = isLeaveInProbation;
	}

	public byte getIsWeekOffAsPL() {
		return isWeekOffAsPL;
	}

	public void setIsWeekOffAsPL(byte isWeekOffAsPL) {
		this.isWeekOffAsPL = isWeekOffAsPL;
	}

	public Long getLeaveFrequencyInMonth() {
		return leaveFrequencyInMonth;
	}

	public BigDecimal getLeaveConsumedCount() {
		return leaveConsumedCount;
	}

	public void setLeaveConsumedCount(BigDecimal leaveConsumedCount) {
		this.leaveConsumedCount = leaveConsumedCount;
	}

	public BigDecimal getLeaveBalancedCount() {
		return leaveBalancedCount;
	}

	public void setLeaveBalancedCount(BigDecimal leaveBalancedCount) {
		this.leaveBalancedCount = leaveBalancedCount;
	}

	public void setLeaveFrequencyInMonth(Long leaveFrequencyInMonth) {
		this.leaveFrequencyInMonth = leaveFrequencyInMonth;
	}

	public String getLeaveMode() {
		return leaveMode;
	}

	public void setLeaveMode(String leaveMode) {
		this.leaveMode = leaveMode;
	}

	public Long getMaxLeaveInMonth() {
		return maxLeaveInMonth;
	}

	public void setMaxLeaveInMonth(Long maxLeaveInMonth) {
		this.maxLeaveInMonth = maxLeaveInMonth;
	}

	public Long getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(Long yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	public Long getTmsleavePeriodId() {
		return tmsleavePeriodId;
	}

	public void setTmsleavePeriodId(Long tmsleavePeriodId) {
		this.tmsleavePeriodId = tmsleavePeriodId;
	}

	public String getTmsleavePeriodName() {
		return tmsleavePeriodName;
	}

	public void setTmsleavePeriodName(String tmsleavePeriodName) {
		this.tmsleavePeriodName = tmsleavePeriodName;
	}

	public Long getTmsleaveTypeMasterId() {
		return tmsleaveTypeMasterId;
	}

	public void setTmsleaveTypeMasterId(Long tmsleaveTypeMasterId) {
		this.tmsleaveTypeMasterId = tmsleaveTypeMasterId;
	}

	public String getTmsleaveTypeMasterName() {
		return tmsleaveTypeMasterName;
	}

	public void setTmsleaveTypeMasterName(String tmsleaveTypeMasterName) {
		this.tmsleaveTypeMasterName = tmsleaveTypeMasterName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLeaveAppliedDays() {
		return leaveAppliedDays;
	}

	public void setLeaveAppliedDays(Long leaveAppliedDays) {
		this.leaveAppliedDays = leaveAppliedDays;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public Long getCarryForwordLeave() {
		return carryForwordLeave;
	}

	public void setCarryForwordLeave(Long carryForwordLeave) {
		this.carryForwordLeave = carryForwordLeave;
	}

	public Long getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(Long totalLeave) {
		this.totalLeave = totalLeave;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	public BigDecimal getDays() {
		return days;
	}

	public void setDays(BigDecimal days) {
		this.days = days;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeRemark() {
		return employeeRemark;
	}

	public void setEmployeeRemark(String employeeRemark) {
		this.employeeRemark = employeeRemark;
	}

	public String getHalf_fullDay() {
		return half_fullDay;
	}

	public void setHalf_fullDay(String half_fullDay) {
		this.half_fullDay = half_fullDay;
	}

	public String getHalfDayFor() {
		return halfDayFor;
	}

	public void setHalfDayFor(String halfDayFor) {
		this.halfDayFor = halfDayFor;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getCancleRemark() {
		return cancleRemark;
	}

	public void setCancleRemark(String cancleRemark) {
		this.cancleRemark = cancleRemark;
	}



	@Override
	public String toString() {
		return "LeaveBalanceSummryDTO [leaveId=" + leaveId + ", activeStatus=" + activeStatus + ", carryForwardLimit="
				+ carryForwardLimit + ", companyId=" + companyId + ", indexDays=" + indexDays + ", isLeaveInProbation="
				+ isLeaveInProbation + ", isWeekOffAsPL=" + isWeekOffAsPL + ", leaveFrequencyInMonth="
				+ leaveFrequencyInMonth + ", leaveMode=" + leaveMode + ", leaveName=" + leaveName + ", maxLeaveInMonth="
				+ maxLeaveInMonth + ", nature=" + nature + ", notice=" + notice + ", weekOffAsPLCount="
				+ weekOffAsPLCount + ", yearlyLimit=" + yearlyLimit + ", leaveConsumedCount=" + leaveConsumedCount
				+ ", carryForwordLeave=" + carryForwordLeave + ", leaveBalancedCount=" + leaveBalancedCount
				+ ", totalLeave=" + totalLeave + ", tmsleavePeriodId=" + tmsleavePeriodId + ", tmsleavePeriodName="
				+ tmsleavePeriodName + ", tmsleaveTypeMasterId=" + tmsleaveTypeMasterId + ", tmsleaveTypeMasterName="
				+ tmsleaveTypeMasterName + ", fromDate=" + fromDate + ", toDate=" + toDate + ", userId=" + userId
				+ ", leaveAppliedDays=" + leaveAppliedDays + ", approvalId=" + approvalId + ", approvalRemark="
				+ approvalRemark + ", days=" + days + ", employeeId=" + employeeId + ", employeeRemark="
				+ employeeRemark + ", half_fullDay=" + half_fullDay + ", halfDayFor=" + halfDayFor + ", leaveType="
				+ leaveType + ", status=" + status + ", statusValue=" + statusValue + ", leaveCount=" + leaveCount
				+ ", cancleRemark=" + cancleRemark + ", leaveTypeId=" + leaveTypeId + ", dateCreated=" + dateCreated
				+ ", employeeCode=" + employeeCode + ", userIdUpdate=" + userIdUpdate + ", notifyEmployeeList="
				+ notifyEmployeeList + "]";
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Long getNotice() {
		return notice;
	}

	public void setNotice(Long notice) {
		this.notice = notice;
	}

	public Long getWeekOffAsPLCount() {
		return weekOffAsPLCount;
	}

	public void setWeekOffAsPLCount(Long weekOffAsPLCount) {
		this.weekOffAsPLCount = weekOffAsPLCount;
	}

	public List<Employee> getNotifyEmployeeList() {
		return notifyEmployeeList;
	}

	public void setNotifyEmployeeList(List<Employee> notifyEmployeeList) {
		this.notifyEmployeeList = notifyEmployeeList;
	}

	public Long getSumTotalLeave() {
		return sumTotalLeave;
	}

	public void setSumTotalLeave(Long sumTotalLeave) {
		this.sumTotalLeave = sumTotalLeave;
	}

	public Long getSumLeaveConsumed() {
		return sumLeaveConsumed;
	}

	public void setSumLeaveConsumed(Long sumLeaveConsumed) {
		this.sumLeaveConsumed = sumLeaveConsumed;
	}
	
	

}
