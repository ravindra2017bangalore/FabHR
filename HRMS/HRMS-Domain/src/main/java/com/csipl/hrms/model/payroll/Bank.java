package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import java.util.Date;


/**
 * The persistent class for the Banks database table.
 * 
 */

@Entity
@Table(name="Banks")
@NamedQuery(name="Bank.findAll", query="SELECT b FROM Bank b")
public class Bank extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bankId;

	@Column(name="AccountHolder")
	private String accountHolder;

	@Column(name="AccountNo")
	private String accountNo;

	@Column(name="AccountType")
	private String accountType;

	private String allowModi;

	@Column(name="BankBranch")
	private String bankBranch;

	@Column(name="BankName")
	private String bankName;

	private Long branchId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;

	private String IFSCCode;

	public Bank() {
	}

	public Long getBankId() {
		return this.bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getAccountHolder() {
		return this.accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getBankBranch() {
		return this.bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getIFSCCode() {
		return this.IFSCCode;
	}

	public void setIFSCCode(String IFSCCode) {
		this.IFSCCode = IFSCCode;
	}

}
