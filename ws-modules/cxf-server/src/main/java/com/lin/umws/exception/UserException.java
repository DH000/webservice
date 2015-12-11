package com.lin.umws.exception;

public class UserException extends Exception {

	/**
	 * desc: TODO
	 */
	private static final long serialVersionUID = 1796406216001776457L;
	
	public UserException(){
		super();
	}
	
	public UserException(String message){
		super(message);
	}
	
	public UserException(Throwable cause){
		super(cause);
	}
	
	public UserException(String message, Throwable cause){
		super(message, cause);
	}
	
}
