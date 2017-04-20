package io.cloudlib.spring.cloud.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception{

//	private int code;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;

	private String thrownByMethod;

	private String[] thrownByMethodArgs;
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getThrownByMethod() {
		return this.thrownByMethod;
	}

	public String[] getThrownByMethodArgs() {
		return this.thrownByMethodArgs;
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String statusMessage) {
		super(statusMessage);
	}
	public ApiException(String statusMessage, Exception e) {
		super(statusMessage, e);
	}
	
	public ApiException(HttpStatus statusCode, String statusMessage) {
		super(statusMessage);
		this.statusCode = statusCode;
	}

	public ApiException(HttpStatus statusCode, String statusMessage, Exception e) {
		super(statusMessage, e);
		this.statusCode = statusCode;
	}

	public ApiException(final HttpStatus statusCode, final String statusMessage, final String thrownByMethod,
			final String[] thrownByMethodArgs) {
		super(statusMessage);
		this.statusCode = statusCode;
		this.thrownByMethod = thrownByMethod;
		this.thrownByMethodArgs = thrownByMethodArgs;
	}

	public ApiException(final HttpStatus statusCode, final String statusMessage, final String thrownByMethod,
			final String[] thrownByMethodArgs, final Exception e) {
		super(statusMessage, e);
		this.statusCode = statusCode;
		this.thrownByMethod = thrownByMethod;
		this.thrownByMethodArgs = thrownByMethodArgs;
	}
}
