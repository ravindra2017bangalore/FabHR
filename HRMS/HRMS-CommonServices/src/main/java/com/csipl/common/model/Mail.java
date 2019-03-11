package com.csipl.common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the Mail database table.
 * 
 */
@Entity
//@NamedQuery(name = "Mail.findAll", query = "SELECT m FROM Mail m")
public class Mail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mailId;

	private String bcc;

	private String cc;

	private Long companyId;

	private Long userId;

	private Long userIdUpdate;

	public Long getUserIdUpdate() {
		return userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	private String footerBody;

	private String fromMail;

	private String functionName;

	private String headerBody;

	private String mailBody;

	private String subject;

	private String title;

	private String toMail;

	public Mail() {
	}

	public Long getMailId() {
		return this.mailId;
	}

	public void setMailId(Long mailId) {
		this.mailId = mailId;
	}

	public String getBcc() {
		return this.bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getFooterBody() {
		return this.footerBody;
	}

	public void setFooterBody(String footerBody) {
		this.footerBody = footerBody;
	}

	public String getFromMail() {
		return this.fromMail;
	}

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getHeaderBody() {
		return this.headerBody;
	}

	public void setHeaderBody(String headerBody) {
		this.headerBody = headerBody;
	}

	public String getMailBody() {
		return this.mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getToMail() {
		return this.toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

}