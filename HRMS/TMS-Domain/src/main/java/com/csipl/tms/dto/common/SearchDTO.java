package com.csipl.tms.dto.common;

public class SearchDTO {
	
	int offset;
	int limit;
	String filter;
	String sortDirection;
	String active;
	String activeStaus;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getSortDirection() {
		return sortDirection;
	}
	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getActiveStaus() {
		return activeStaus;
	}
	public void setActiveStaus(String activeStaus) {
		this.activeStaus = activeStaus;
	}
	@Override
	public String toString() {
		return "SearchDTO [offset=" + offset + ", limit=" + limit + ", filter=" + filter + ", sortDirection="
				+ sortDirection + ", active=" + active + ", activeStaus=" + activeStaus + "]";
	}
	
}

