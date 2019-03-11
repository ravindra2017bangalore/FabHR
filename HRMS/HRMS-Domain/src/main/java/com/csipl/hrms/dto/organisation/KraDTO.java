package com.csipl.hrms.dto.organisation;
public class KraDTO {
	private Long kraId;
	private Long designationId;
	private Long departmentId;
	private String kraName;
	private String designationName;
	private String departmentName;
	
	public Long getKraId() {
		return kraId;
	}
	public void setKraId(Long kraId) {
		this.kraId = kraId;
	}
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getKraName() {
		return kraName;
	}
	public void setKraName(String kraName) {
		this.kraName = kraName;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}

