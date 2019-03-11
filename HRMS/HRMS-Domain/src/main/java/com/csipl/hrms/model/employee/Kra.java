package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;


import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;

import java.util.Date;


/**
 * The persistent class for the Kra database table.
 * 
 */
@Entity
@NamedQuery(name="Kra.findAll", query="SELECT k FROM Kra k")
public class Kra extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long kraId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	
	private String kraName;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	//bi-directional many-to-one association to Designation
	@ManyToOne
	@JoinColumn(name="designationId")
	private Designation designation;

	public Kra() {
	}

	public Long getKraId() {
		return this.kraId;
	}

	public void setKraId(Long kraId) {
		this.kraId = kraId;
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

	public String getKraName() {
		return this.kraName;
	}

	public void setKraName(String kraName) {
		this.kraName = kraName;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}