package com.csipl.hrms.model.organisation;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.util.Date;


/**
 * The persistent class for the Designation database table.
 * 
 */
@Entity
@NamedQuery(name="Designation.findAll", query="SELECT d FROM Designation d")
public class Designation extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long designationId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String designationName;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;

	public Designation() {
	}

	public Long getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
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

	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}