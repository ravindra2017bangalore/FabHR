package com.csipl.hrms.dto.employee;

import java.util.List;

public class EmpHierarchyDTO {
	
	private String text;
	private String url;
	private Long employeeId;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
 	List<EmpHierarchyDTO> items;

	public List<EmpHierarchyDTO> getItems() {
		return items;
	}
	public void setItems(List<EmpHierarchyDTO> items) {
		this.items = items;
	}
 	 
}
