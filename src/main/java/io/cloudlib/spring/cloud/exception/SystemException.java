package io.cloudlib.spring.cloud.exception;

/**
 * 
 * 
 *
 */
public class SystemException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	public SystemException (int code, String msg) {
		super(msg);
		this.code = code;
	}
}
