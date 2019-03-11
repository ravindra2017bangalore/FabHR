package com.csipl.hrms.common.exception;

public class PayRollProcessException extends BaseException{

	 private String message;
	 
	 public PayRollProcessException( String message ) {
		 this.message = message;
	 }

	public String getMessage() {
		return message;
	}
	 
}
