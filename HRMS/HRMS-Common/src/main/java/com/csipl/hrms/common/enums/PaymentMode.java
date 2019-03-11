package com.csipl.hrms.common.enums;

public enum PaymentMode {
	OnlineBanking("OB"),Cheque("CH"),Cash("CA"),Salary("SA"),Baddebts("BD");
	
	String paymentMode;
	PaymentMode( String paymentMode ){
		this.paymentMode = paymentMode;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	
	
}
