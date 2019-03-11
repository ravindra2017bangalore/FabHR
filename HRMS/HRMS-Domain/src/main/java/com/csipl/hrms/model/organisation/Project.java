package com.csipl.hrms.model.organisation;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.util.Date;


/**
 * The persistent class for the Project database table.
 * 
 */

@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;

	private String allowModi;

	private Long branchId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;


	private String projectName;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;

	//bi-directional many-to-one association to Company
	/*@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;
*/
	public Project() {
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/*public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

}