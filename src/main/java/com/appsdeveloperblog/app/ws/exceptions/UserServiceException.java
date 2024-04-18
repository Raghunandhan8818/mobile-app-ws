package com.appsdeveloperblog.app.ws.exceptions;

public class UserServiceException extends RuntimeException {

    public static final long serialVersionUID = 8868850346214526900L;
    public UserServiceException(String message) {
        super(message);
    }
}
