package com.csipl.hrms.model.employee;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.util.Date;


/**
 * The persistent class for the EmployeeIdProofs database table.
 * 
 */
@Entity
@Table(name="EmployeeIdProofs")
@NamedQuery(name="EmployeeIdProof.findAll", query="SELECT e FROM EmployeeIdProof e")
public class EmployeeIdProof extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeIdProofsId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	private Date dateIssue;

	@Temporal(TemporalType.DATE)
	private Date dateTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String idNumber;

	private String idTypeId;


	private String idProofDoc;
	
	private String documentName;
	
	@Transient
	private int docIndex;
	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;
	//private Long employeeId;

	/*public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}*/

	public EmployeeIdProof() {
	}

	public Long getEmployeeIdProofsId() {
		return this.employeeIdProofsId;
	}

	public void setEmployeeIdProofsId(Long employeeIdProofsId) {
		this.employeeIdProofsId = employeeIdProofsId;
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

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateIssue() {
		return this.dateIssue;
	}

	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdTypeId() {
		return this.idTypeId;
	}

	public void setIdTypeId(String idTypeId) {
		this.idTypeId = idTypeId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getIdProofDoc() {
		return idProofDoc;
	}

	public void setIdProofDoc(String idProofDoc) {
		this.idProofDoc = idProofDoc;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public int getDocIndex() {
		return docIndex;
	}

	public void setDocIndex(int docIndex) {
		this.docIndex = docIndex;
	}
}