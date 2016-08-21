package info.kapable.app.ComptesPerso.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import info.kapable.app.ComptesPerso.pojo.ErrorResource;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger logger = Logger.getLogger(AppExceptionHandler.class);
	
    @ExceptionHandler({ TransactionSystemException.class })
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {
    	logger.info("Error in request : (" + e.getClass().toString() + ") :" + e.getMessage());
        ErrorResource error = new ErrorResource("InvalidRequest", e.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
