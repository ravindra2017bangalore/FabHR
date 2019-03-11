package com.csipl.hrms.common.exception;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.rest.webmvc.support.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.csipl.hrms.common.util.ErrorHandling;

@Controller
@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
	private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
	
	
	
	
	@ExceptionHandler(value = BaseException.class)
	@ResponseBody
	public String handleBaseException(BaseException e) {
		return e.getMessage();
	}
	
	
	@ExceptionHandler(value = PayRollProcessException.class)
	@ResponseBody
	public ResponseEntity<?>  handlePayRollProcessException(PayRollProcessException e) {
	//	return e.getMessage();
		
		///System.out.println("PayRollProcessException ==== "+e.getMessage());
		 return new ResponseEntity( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
	
	@ExceptionHandler(value = ErrorHandling.class)
	@ResponseBody
	public ResponseEntity<?>  handleErrorHandling(ErrorHandling e) {
	//	return e.getMessage();
	
		//System.out.println("handleErrorHandlingException ==== "+e.getMessage());
		//e.printStackTrace();
		 return new ResponseEntity( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
	
	/**
     * Catch all for any other exceptions...
     */
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ResponseEntity<?> handleAnyException(Exception e) {
    	//System.out.println("handleAnyException");
        return errorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle failures commonly thrown from code
     */
    @ExceptionHandler({ InvocationTargetException.class, IllegalArgumentException.class, ClassCastException.class,
            ConversionFailedException.class })
    @ResponseBody
    public ResponseEntity handleMiscFailures(Throwable t) {
        return errorResponse(t, HttpStatus.BAD_REQUEST);
    }

    /**
     * Send a 409 Conflict in case of concurrent modification
     */
    @ExceptionHandler({ ObjectOptimisticLockingFailureException.class, OptimisticLockingFailureException.class,
            DataIntegrityViolationException.class })
    @ResponseBody
    public ResponseEntity handleConflict(Exception ex) {
        return errorResponse(ex, HttpStatus.CONFLICT);
    }
    
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }
        ApiError errorMessage = new ApiError(errors);
        return new ResponseEntity(errorMessage, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String unsupported = "Unsupported content type: " + ex.getContentType();
        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
        ApiError errorMessage = new ApiError(unsupported, supported);
        return new ResponseEntity(errorMessage, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ApiError errorMessage;
        if (mostSpecificCause != null) {
            String exceptionName = mostSpecificCause.getClass().getName();
            String message = mostSpecificCause.getMessage();
            errorMessage = new ApiError(exceptionName, message);
        } else {
            errorMessage = new ApiError(ex.getMessage());
        }
        return new ResponseEntity(errorMessage, headers, status);
    }
    
    
    

    /*protected ResponseEntity<ExceptionMessage> errorResponse(Throwable throwable,
                                                                                HttpStatus status) {
    	 
    	System.out.println("errorResponse ==== ");
        if (null != throwable) {
        	System.out.println(throwable.getMessage());;
            log.error("error caught: " + throwable.getMessage(), throwable);
            return response(new ExceptionMessage(throwable), status);
        } else {
            log.error("unknown error caught in RESTController, {}", status);
            return response(null, status);
        }
    }*/
    
	protected ResponseEntity<ErrorHandling> errorResponse(Throwable throwable, HttpStatus status) {

	
		if (null != throwable) {
			log.error("error caught: " + throwable.getMessage(), throwable);
			//throwable.getStackTrace();
			//throwable.printStackTrace();
			return response(new ErrorHandling( status.getReasonPhrase()), status);
		} else {
			
			log.error("unknown error caught in RESTController, {}", status);
			return response(null, status);
		}
	}

    protected <T> ResponseEntity<T> response(T body, HttpStatus status) {
        log.debug("Responding with a status of {}", status);
        return new ResponseEntity<>(body, new HttpHeaders(), status);
    }
}