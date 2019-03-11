package com.csipl.common.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DrowpdownList database table.
 * 
 */
@Entity
//@NamedQuery(name="DrowpdownList.findAll", query="SELECT d FROM DrowpdownList d")
public class DrowpdownList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short drowpdownListId;

	private String activeStatus;

	private String listCode;

	private String listValue;

	//bi-directional many-to-one association to DrowpdownHd
	@ManyToOne
	@JoinColumn(name="drowpdownId")
	private DrowpdownHd drowpdownHd;

	public DrowpdownList() {
	}

	public short getDrowpdownListId() {
		return this.drowpdownListId;
	}

	public void setDrowpdownListId(short drowpdownListId) {
		this.drowpdownListId = drowpdownListId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getListCode() {
		return this.listCode;
	}

	public void setListCode(String listCode) {
		this.listCode = listCode;
	}

	public String getListValue() {
		return this.listValue;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

	public DrowpdownHd getDrowpdownHd() {
		return this.drowpdownHd;
	}

	public void setDrowpdownHd(DrowpdownHd drowpdownHd) {
		this.drowpdownHd = drowpdownHd;
	}

}