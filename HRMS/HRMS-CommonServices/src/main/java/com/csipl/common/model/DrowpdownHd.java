package com.csipl.common.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DrowpdownHd database table.
 * 
 */
@Entity
//@NamedQuery(name="DrowpdownHd.findAll", query="SELECT d FROM DrowpdownHd d")
public class DrowpdownHd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long drowpdownId;

	private String allowModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String drowpdownName;

	private int groupId;

	private int userId;

	private int userIdUpdate;

	//bi-directional many-to-one association to Company
/*	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;
*/
	//bi-directional many-to-one association to DrowpdownList
	@OneToMany(mappedBy="drowpdownHd", fetch=FetchType.EAGER)
	private List<DrowpdownList> drowpdownLists;

	public DrowpdownHd() {
	}

	public Long getDrowpdownId() {
		return this.drowpdownId;
	}

	public void setDrowpdownId(Long drowpdownId) {
		this.drowpdownId = drowpdownId;
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

	public String getDrowpdownName() {
		return this.drowpdownName;
	}

	public void setDrowpdownName(String drowpdownName) {
		this.drowpdownName = drowpdownName;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(int userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

/*	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}*/

	public List<DrowpdownList> getDrowpdownLists() {
		return this.drowpdownLists;
	}

	public void setDrowpdownLists(List<DrowpdownList> drowpdownLists) {
		this.drowpdownLists = drowpdownLists;
	}

	public DrowpdownList addDrowpdownList(DrowpdownList drowpdownList) {
		getDrowpdownLists().add(drowpdownList);
		drowpdownList.setDrowpdownHd(this);

		return drowpdownList;
	}

	public DrowpdownList removeDrowpdownList(DrowpdownList drowpdownList) {
		getDrowpdownLists().remove(drowpdownList);
		drowpdownList.setDrowpdownHd(null);

		return drowpdownList;
	}

}