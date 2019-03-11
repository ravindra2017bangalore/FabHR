package com.csipl.hrms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@MappedSuperclass
public class BaseModelWithoutCG  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long userIdUpdate;
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
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
	
	

}
