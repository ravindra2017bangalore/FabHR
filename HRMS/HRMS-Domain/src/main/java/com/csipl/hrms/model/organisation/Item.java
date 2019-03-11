package com.csipl.hrms.model.organisation;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.EmployeeAsset;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long itemId;

	private String activeStatus;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	

	private BigDecimal gstRate;

	private String hsnCode;

	private String itemName;

	private String itemUnit;

	
	/*//bi-directional many-to-one association to EmployeeAsset
	@OneToMany(mappedBy="item")
	private List<EmployeeAsset> employeeAssets;*/

	//bi-directional many-to-one association to Company
	

	public Item() {
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	

	public BigDecimal getGstRate() {
		return this.gstRate;
	}

	public void setGstRate(BigDecimal gstRate) {
		this.gstRate = gstRate;
	}

	public String getHsnCode() {
		return this.hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return this.itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	

	/*public EmployeeAsset addEmployeeAsset(EmployeeAsset employeeAsset) {
		getEmployeeAssets().add(employeeAsset);
		employeeAsset.setItem(this);

		return employeeAsset;
	}

	public EmployeeAsset removeEmployeeAsset(EmployeeAsset employeeAsset) {
		getEmployeeAssets().remove(employeeAsset);
		employeeAsset.setItem(null);

		return employeeAsset;
	}
*/
	

}