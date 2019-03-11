package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModel;
 
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "TdsSlabHd.findAll", query = "SELECT t FROM TdsSlabHd t")
public class TdsSlabHd extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tdsSLabHdId;

	private String allowModi;

	@Temporal(TemporalType.DATE)
	private Date dateEffective;

	private String tdsCategory;

	// bi-directional many-to-one association to TdsSlab
	@OneToMany(mappedBy = "tdsSlabHd", cascade = CascadeType.ALL)
	private List<TdsSlab> tdsSlabs;

	public TdsSlabHd() {
	}

	public Long getTdsSLabHdId() {
		return this.tdsSLabHdId;
	}

	public void setTdsSLabHdId(Long tdsSLabHdId) {
		this.tdsSLabHdId = tdsSLabHdId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public Date getDateEffective() {
		return this.dateEffective;
	}

	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	public String getTdsCategory() {
		return this.tdsCategory;
	}

	public void setTdsCategory(String tdsCategory) {
		this.tdsCategory = tdsCategory;
	}

	public List<TdsSlab> getTdsSlabs() {
		return this.tdsSlabs;
	}

	public void setTdsSlabs(List<TdsSlab> tdsSlabs) {
		this.tdsSlabs = tdsSlabs;
	}

	public TdsSlab addTdsSlab(TdsSlab tdsSlab) {
		getTdsSlabs().add(tdsSlab);
		tdsSlab.setTdsSlabHd(this);

		return tdsSlab;
	}

	public TdsSlab removeTdsSlab(TdsSlab tdsSlab) {
		getTdsSlabs().remove(tdsSlab);
		tdsSlab.setTdsSlabHd(null);

		return tdsSlab;
	}
 }