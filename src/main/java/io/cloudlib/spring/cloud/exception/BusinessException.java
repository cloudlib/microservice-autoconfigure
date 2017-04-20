package io.cloudlib.spring.cloud.exception;

public class BusinessException extends ApiException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	public BusinessException (int code, String msg) {
		super(msg);
		this.code = code;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
}
