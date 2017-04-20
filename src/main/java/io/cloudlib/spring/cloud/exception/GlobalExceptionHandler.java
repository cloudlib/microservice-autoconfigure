package io.cloudlib.spring.cloud.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  
public class GlobalExceptionHandler {  
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
  
	@ExceptionHandler(value = ApiException.class)  
    public ResponseEntity<Error> handleBaseException(ApiException apiException){
		LOGGER.error("handleBaseException. Handling Exception... Caught exception: {}", apiException);
		logApiException(apiException);
		Error error = new Error().code(apiException.getStatusCode().value())
				.message(apiException.getMessage());
		
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);  
    }  

    
    @ExceptionHandler(value = BusinessException.class)  
    public ResponseEntity<Error> handleBusinessException(BusinessException e){
    	Error error = new Error();
    	error.setCode(e.getCode());
    	error.setDetails(e.toString());
    	error.setMessage(e.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.OK);  
    }  
  

    @ExceptionHandler(value = SystemException.class)  
    public ResponseEntity<Error> handleSystemException(SystemException e){
    	Error error = new Error();
    	error.setCode(99999); //TODO - Check if it is fine
    	error.setDetails(e.toString()); 
    	error.setMessage(e.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.NOT_ACCEPTABLE);  
    }  
    
    @ExceptionHandler(value = Exception.class)  
    public ResponseEntity<Error> handleException(Exception ex){
    	LOGGER.error("handleException. Handling Exception... Caught exception: {}", ex);
    	Error error = null;
    	if (ex.getCause() instanceof ApiException) {
			ApiException apiException = (ApiException) ex.getCause();
			logApiException(apiException);
			error = new Error().code(apiException.getStatusCode().value())
					.message(apiException.getMessage()).details(ex.toString());
    	}  else {
			logException(ex);
			error = new Error().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message(ex.getMessage()).details(ex.toString());
		}
    	return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);  
    }  
    
    /**
	 * Logs the <code>ApiException</code> occurred.
	 * 
	 * @param ex <code>ApiException</code> occurred.
	 */
	private void logApiException(final ApiException ex) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(
					"Caught exception in method: [ {} ] with arguments: {}. \n The exception is: {}",
					ex.getThrownByMethod(), ex.getThrownByMethodArgs(), ex.getMessage(), ex);
		}
//		metricRegistry
//				.meter(MetricRegistry.name(ex.getThrownByMethod(), ExtendedMetricRegistry.FAILURE))
//				.mark();
	}
	
	/**
	 * Logs the <code>Exception</code> occurred.
	 * 
	 * @param ex <code>Exception</code> occurred.
	 */
	private void logException(Exception e) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Handling Exception... Caught exception: {}", e);
		}
	}

}
