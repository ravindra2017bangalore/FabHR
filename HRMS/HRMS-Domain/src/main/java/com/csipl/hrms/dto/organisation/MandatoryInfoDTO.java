package com.csipl.hrms.dto.organisation;

import java.util.Date;

public class MandatoryInfoDTO {

	private long mandatoryInfoId;

	private Date dateCreated;

	private Date dateUpdate;

	private String docCode;

	private String docName;

	private String status;

	private long userId;

	private long userIdUpdate;
	
	private Long companyId;
	

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public long getMandatoryInfoId() {
		return mandatoryInfoId;
	}

	public void setMandatoryInfoId(long mandatoryInfoId) {
		this.mandatoryInfoId = mandatoryInfoId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	/*
	 * public List<DropDownListDTO> getDrowpdownDtoLists() { return
	 * drowpdownDtoLists; }
	 * 
	 * public void setDrowpdownDtoLists(List<DropDownListDTO> drowpdownDtoLists) {
	 * this.drowpdownDtoLists = drowpdownDtoLists; }
	 */

}
