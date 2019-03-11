package com.csipl.hrms.common.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	
	private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private int code;
	   private String message;
	   private String debugMessage;
		  
	   private List<String> errors;
	   private List<ApiSubError> subErrors;

	   private ApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	       this.timestamp = timestamp.now();
	   }
	   
	   ApiError(String message,int code) {
	       this();
	       this.code = code;
	       this.message = message;
	       this.timestamp = timestamp.now();
	   }

	   ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.timestamp = timestamp.now();
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   ApiError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.timestamp = timestamp.now();
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	   
	   
	   public ApiError(List<String> errors) {
		    this();
	        this.errors = errors;
	    }

	    public ApiError(String message) {
	    	 this(Collections.singletonList(message));
	    	//this.message = message;
	    }

	    public ApiError(String ... errors) {
	        this(Arrays.asList(errors));
	    }
	   
	   public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}

}
