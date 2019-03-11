package com.csipl.hrms.common.exception;

import com.csipl.hrms.common.exception.messages.error.ErrorCodes;

public class ServiceException extends BaseException {

	 private String message;
	 
	 public ServiceException() {
		 
	 }
	
    public ServiceException(String message) {
       this.message = message;
    }

	public String getMessage() {
		return message;
	}
}
