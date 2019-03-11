package com.csipl.hrms.dto.payroll;

public class TransactionApprovedHdDTO {

	private Long transactionApprovedHdId;
    private String financialYear;
    private String status;
	private String active;
	
	public Long getTransactionApprovedHdId() {
		return transactionApprovedHdId;
	}
	public void setTransactionApprovedHdId(Long transactionApprovedHdId) {
		this.transactionApprovedHdId = transactionApprovedHdId;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

}
