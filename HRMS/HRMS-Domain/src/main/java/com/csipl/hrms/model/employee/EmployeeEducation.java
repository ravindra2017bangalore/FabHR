package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.math.BigDecimal;


/**
 * The persistent class for the EmployeeEducation database table.
 * 
 */
@Entity
@NamedQuery(name="EmployeeEducation.findAll", query="SELECT e FROM EmployeeEducation e")
public class EmployeeEducation extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long educationId;

	private String allowModi;

    @Transient
    private Long docIndex;
//	private int companyId;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date dateCreated;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date dateUpdate;

	private String degreeName;

	//private int groupId;

	private BigDecimal marksPer;

	private String nameOfBoard;

	private String nameOfInstitution;

	private Long passingYear;

	private String qualificationId;

	private String regularCorrespondance;
    private String documentName;
    private String employeeEducationDoc;
    

    
//	private int userId;

//	private int userIdUpdate;

	//bi-directional many-to-one association to Employee
	/*@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;*/

	
	private Long employeeId;
	
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public EmployeeEducation() {
	}

	public Long getEducationId() {
		return this.educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	/*public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
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
*/
	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	/*public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}*/

	public BigDecimal getMarksPer() {
		return this.marksPer;
	}

	public void setMarksPer(BigDecimal marksPer) {
		this.marksPer = marksPer;
	}

	public String getNameOfBoard() {
		return this.nameOfBoard;
	}

	public void setNameOfBoard(String nameOfBoard) {
		this.nameOfBoard = nameOfBoard;
	}

	public String getNameOfInstitution() {
		return this.nameOfInstitution;
	}

	public void setNameOfInstitution(String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
	}

	public Long getPassingYear() {
		return this.passingYear;
	}

	public void setPassingYear(Long passingYear) {
		this.passingYear = passingYear;
	}

	public String getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getRegularCorrespondance() {
		return this.regularCorrespondance;
	}

	public void setRegularCorrespondance(String regularCorrespondance) {
		this.regularCorrespondance = regularCorrespondance;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getEmployeeEducationDoc() {
		return employeeEducationDoc;
	}

	public void setEmployeeEducationDoc(String employeeEducationDoc) {
		this.employeeEducationDoc = employeeEducationDoc;
	}

	public Long getDocIndex() {
		return docIndex;
	}

	public void setDocIndex(Long docIndex) {
		this.docIndex = docIndex;
	}

	/*public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(int userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}*/

	/*public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/

}