package com.csipl.hrms.dto.employee;

import java.util.List;


public class EmployeeCountDTO {

	private int count;
	private List<PageIndex> pageIndexs;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<PageIndex> getPageIndexs() {
		return pageIndexs;
	}

	public void setPageIndexs(List<PageIndex> pageIndexs) {
		this.pageIndexs = pageIndexs;
	}
}
