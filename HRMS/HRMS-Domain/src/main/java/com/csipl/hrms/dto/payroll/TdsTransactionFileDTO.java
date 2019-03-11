package com.csipl.hrms.dto.payroll;

import java.util.Date;

public class TdsTransactionFileDTO {
	
	private Long tdsTransactionFileId;
	private String fileName;
	private String filePath;
	private String title;
	private Long employeeId;
	private Long userId;
	private Long userIdUpdate;
	private Date dateCreated;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserIdUpdate() {
		return userIdUpdate;
	}
	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getTdsTransactionFileId() {
		return tdsTransactionFileId;
	}
	public void setTdsTransactionFileId(Long tdsTransactionFileId) {
		this.tdsTransactionFileId = tdsTransactionFileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
