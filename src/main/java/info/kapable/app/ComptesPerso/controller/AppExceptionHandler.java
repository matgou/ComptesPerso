package info.kapable.app.ComptesPerso.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import info.kapable.app.ComptesPerso.pojo.ErrorResource;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger logger = Logger.getLogger(AppExceptionHandler.class);
	
	private Throwable getCause(Throwable e) {
	    Throwable cause = null; 
	    Throwable result = e;

	    while(null != (cause = result.getCause())  && (result != cause) ) {
	        result = cause;
	    }
	    return result;
	}
	
    @ExceptionHandler(TransactionSystemException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
    protected ErrorResource handleInvalidRequest(TransactionSystemException ex) {
        Throwable t = this.getCause(ex);
        logger.error("Server error", ex);
        if(t instanceof ConstraintViolationException){
        	ConstraintViolationException cve = (ConstraintViolationException) t;
           Set<ConstraintViolation<?>> constraints = cve.getConstraintViolations();
           Map<String,List<String>> constraintList = new HashMap<String,List<String>>(); 
           for(ConstraintViolation<?> constraint: constraints) {
        	   String message = constraint.getMessage();
        	   String property = constraint.getPropertyPath().toString();
        	   if(!constraintList.containsKey(property)) {
        		   constraintList.put(property, new ArrayList<String>());
        	   }
        	   constraintList.get(property).add(message);
           }
           return new ErrorResource("InvalidEntity", t.getMessage(), constraintList);    
        }else {
           return new ErrorResource("Unknow server error", t.getMessage());
        }
    }
} 
