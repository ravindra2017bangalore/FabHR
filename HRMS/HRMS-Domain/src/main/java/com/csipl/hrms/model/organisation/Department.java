package com.csipl.hrms.model.organisation;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.employee.Employee;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Department database table.
 * 
 */
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long departmentId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String departmentName;

	//bi-directional many-to-one association to Company

	//bi-directional many-to-one association to Designation
	@OneToMany(mappedBy="department")
	private List<Designation> designations;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="department")
	private List<Project> projects;
	
	//bi-directional many-to-one association to Employee
    @OneToMany(mappedBy="department")
	private List<Employee> employees;

	public Department() {
	}

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	public List<Designation> getDesignations() {
		return this.designations;
	}

	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
	}

	public Designation addDesignation(Designation designation) {
		getDesignations().add(designation);
		designation.setDepartment(this);

		return designation;
	}

	public Designation removeDesignation(Designation designation) {
		getDesignations().remove(designation);
		designation.setDepartment(null);

		return designation;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setDepartment(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setDepartment(null);

		return project;
	}
	
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}


}