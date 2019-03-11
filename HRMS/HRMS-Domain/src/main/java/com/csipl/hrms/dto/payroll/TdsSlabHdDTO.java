package com.csipl.hrms.dto.payroll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdsSlabHdDTO {
	private Long tdsSLabHdId;
	private Date dateEffective;
	private String tdsCategory;
	private Long userId;
	private String tdsCategoryValue;
	private Date dateCreated;
	private Long companyId;
	private Long userIdUpdate;
	private Date dateUpdate;
	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	private List<TdsSlabDTO> tdsSlabs = new ArrayList<TdsSlabDTO>();
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Date getDateEffective() {
		return dateEffective;
	}

	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	public String getTdsCategory() {
		return tdsCategory;
	}

	public void setTdsCategory(String tdsCategory) {
		this.tdsCategory = tdsCategory;
	}

	public List<TdsSlabDTO> getTdsSlabs() {
		return tdsSlabs;
	}

	public void setTdsSlabs(List<TdsSlabDTO> tdsSlabs) {
		this.tdsSlabs = tdsSlabs;
	}

	public Long getTdsSLabHdId() {
		return tdsSLabHdId;
	}

	public void setTdsSLabHdId(Long tdsSLabHdId) {
		this.tdsSLabHdId = tdsSLabHdId;
	}

	public String getTdsCategoryValue() {
		return tdsCategoryValue;
	}

	public void setTdsCategoryValue(String tdsCategoryValue) {
		this.tdsCategoryValue = tdsCategoryValue;
	}

}
