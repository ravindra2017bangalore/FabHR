package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModelWithoutCG;
import java.util.Date;


/**
 * The persistent class for the EmployeeDocuments database table.
 * 
 */
@Entity
@Table(name="EmployeeDocuments")
@NamedQuery(name="EmployeeDocument.findAll", query="SELECT e FROM EmployeeDocument e")
public class EmployeeDocument extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeDocumentsId;

	private String activeStatus;

	private String allowModi;

	private String fileLocation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String description;

	@Column(name="DocumentsId")
	private String documentsId;

	private Long employeeId;


	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeDocument() {
	}

	public Long getEmployeeDocumentsId() {
		return this.employeeDocumentsId;
	}

	public void setEmployeeDocumentsId(Long employeeDocumentsId) {
		this.employeeDocumentsId = employeeDocumentsId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentsId() {
		return this.documentsId;
	}

	public void setDocumentsId(String documentsId) {
		this.documentsId = documentsId;
	}

	
}
