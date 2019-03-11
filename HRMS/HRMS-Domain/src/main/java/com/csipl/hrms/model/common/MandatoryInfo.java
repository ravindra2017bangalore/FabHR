package com.csipl.hrms.model.common;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutGroup;

import java.util.Date;


/**
 * The persistent class for the MandatoryInfo database table.
 * 
 */
@Entity
@NamedQuery(name="MandatoryInfo.findAll", query="SELECT m FROM MandatoryInfo m")
public class MandatoryInfo extends BaseModelWithoutGroup  implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mandatoryInfoId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String docCode;

	private String docName;

	private String status;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public MandatoryInfo() {
	}

	public Long getMandatoryInfoId() {
		return this.mandatoryInfoId;
	}

	public void setMandatoryInfoId(Long mandatoryInfoId) {
		this.mandatoryInfoId = mandatoryInfoId;
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

	public String getDocCode() {
		return this.docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "MandatoryInfo [mandatoryInfoId=" + mandatoryInfoId + ", dateCreated=" + dateCreated + ", dateUpdate="
				+ dateUpdate + ", docCode=" + docCode + ", docName=" + docName + ", status=" + status + ", userId="
				+ userId + ", userIdUpdate=" + userIdUpdate + ", company=" + company + "]";
	}

}