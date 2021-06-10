package com.springrest.exceptions;


public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public EntityNotFoundException() {
        super();
    }

   
    public EntityNotFoundException(String message) {
        super(message);
    }

    
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    
    protected EntityNotFoundException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
