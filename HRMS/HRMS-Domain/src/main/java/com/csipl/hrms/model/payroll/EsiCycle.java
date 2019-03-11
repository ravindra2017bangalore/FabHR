package com.csipl.hrms.model.payroll;



import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EsiCycle database table.
 * 
 */
@Entity
@NamedQuery(name="EsiCycle.findAll", query="SELECT e FROM EsiCycle e")
public class EsiCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int esiCycleId;

	private String fromperiod;

	private String toperiod;

	//bi-directional many-to-one association to Esi
	@ManyToOne
	@JoinColumn(name="esiId")
	private Esi esi;

	public EsiCycle() {
	}

	public int getEsiCycleId() {
		return this.esiCycleId;
	}

	public void setEsiCycleId(int esiCycleId) {
		this.esiCycleId = esiCycleId;
	}

	public String getFromperiod() {
		return this.fromperiod;
	}

	public void setFromperiod(String fromperiod) {
		this.fromperiod = fromperiod;
	}

	public String getToperiod() {
		return this.toperiod;
	}

	public void setToperiod(String toperiod) {
		this.toperiod = toperiod;
	}

	public Esi getEsi() {
		return this.esi;
	}

	public void setEsi(Esi esi) {
		this.esi = esi;
	}

}