package com.csipl.hrms.model.employee;
 
import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.Company;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MasterBook database table.
 * 
 */
@Entity
@NamedQuery(name="MasterBook.findAll", query="SELECT m FROM MasterBook m")
public class MasterBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long bookId;

	private String activeStatus;

	private String allowModi;

	private String bookCode;

	private String bookName;

	private String bookType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String defaultBook;

	private Long groupId;

	private BigDecimal lastNo;

	private String prefixBook;

	private BigDecimal startFrom;

	private Long userId;

	private Long userIdUpdate;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public MasterBook() {
	}

	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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

	public String getBookCode() {
		return this.bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
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

	public String getDefaultBook() {
		return this.defaultBook;
	}

	public void setDefaultBook(String defaultBook) {
		this.defaultBook = defaultBook;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public BigDecimal getLastNo() {
		return this.lastNo;
	}

	public void setLastNo(BigDecimal lastNo) {
		this.lastNo = lastNo;
	}

	public String getPrefixBook() {
		return this.prefixBook;
	}

	public void setPrefixBook(String prefixBook) {
		this.prefixBook = prefixBook;
	}

	public BigDecimal getStartFrom() {
		return this.startFrom;
	}

	public void setStartFrom(BigDecimal startFrom) {
		this.startFrom = startFrom;
	}

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

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}