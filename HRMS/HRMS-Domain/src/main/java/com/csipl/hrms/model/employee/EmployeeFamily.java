package com.csipl.hrms.model.employee;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EmployeeFamily database table.
 * 
 */
@Entity
@NamedQuery(name="EmployeeFamily.findAll", query="SELECT e FROM EmployeeFamily e")
public class EmployeeFamily implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familyId;

	private String allowModi;

	private String captions;

	private String contactMobile;

	private String contactPhone;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String name;

	private String occupations;

	private String qualificationId;

	private String relation;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	//bi-directional many-to-one association to EmployeeNominee
	@OneToMany(mappedBy="employeeFamily")
	private List<EmployeeNominee> employeeNominees;

	public EmployeeFamily() {
	}

	public Long getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getCaptions() {
		return this.captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupations() {
		return this.occupations;
	}

	public void setOccupations(String occupations) {
		this.occupations = occupations;
	}

	public String getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<EmployeeNominee> getEmployeeNominees() {
		return this.employeeNominees;
	}

	public void setEmployeeNominees(List<EmployeeNominee> employeeNominees) {
		this.employeeNominees = employeeNominees;
	}

	public EmployeeNominee addEmployeeNominee(EmployeeNominee employeeNominee) {
		getEmployeeNominees().add(employeeNominee);
		employeeNominee.setEmployeeFamily(this);

		return employeeNominee;
	}

	public EmployeeNominee removeEmployeeNominee(EmployeeNominee employeeNominee) {
		getEmployeeNominees().remove(employeeNominee);
		employeeNominee.setEmployeeFamily(null);

		return employeeNominee;
	}

}