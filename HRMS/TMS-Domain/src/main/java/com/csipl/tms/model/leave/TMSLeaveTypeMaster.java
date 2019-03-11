package com.csipl.tms.model.leave;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TMSLeaveTypeMaster database table.
 * 
 */
@Entity
@NamedQuery(name="TMSLeaveTypeMaster.findAll", query="SELECT t FROM TMSLeaveTypeMaster t")
public class TMSLeaveTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveId;

	private String activeStatus;

	private Long companyId;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private String leaveName;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to TMSLeaveType
	@OneToMany(mappedBy="tmsleaveTypeMaster")
	private List<TMSLeaveType> tmsleaveTypes;

	public TMSLeaveTypeMaster() {
	}

	public Long getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
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

	public String getLeaveName() {
		return this.leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
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

	public List<TMSLeaveType> getTmsleaveTypes() {
		return this.tmsleaveTypes;
	}

	public void setTmsleaveTypes(List<TMSLeaveType> tmsleaveTypes) {
		this.tmsleaveTypes = tmsleaveTypes;
	}

	public TMSLeaveType addTmsleaveType(TMSLeaveType tmsleaveType) {
		getTmsleaveTypes().add(tmsleaveType);
		tmsleaveType.setTmsleaveTypeMaster(this);

		return tmsleaveType;
	}

	public TMSLeaveType removeTmsleaveType(TMSLeaveType tmsleaveType) {
		getTmsleaveTypes().remove(tmsleaveType);
		tmsleaveType.setTmsleaveTypeMaster(null);

		return tmsleaveType;
	}
	}
