package com.csipl.hrms.model.organisation;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.common.Address;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Clients database table.
 * 
 */

@Entity
@Table(name="Clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clientId;

	private String allowModi;

	private String clientName;

	private String concernPerson;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String gstNo;

	//bi-directional many-to-one association to Address
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="client")
	private List<Project> projects;

	public Client() {
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getConcernPerson() {
		return this.concernPerson;
	}

	public void setConcernPerson(String concernPerson) {
		this.concernPerson = concernPerson;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	

	public String getGstNo() {
		return this.gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setClient(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setClient(null);

		return project;
	}

}