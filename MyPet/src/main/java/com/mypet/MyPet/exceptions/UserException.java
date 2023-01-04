package com.mypet.MyPet.exceptions;

public class UserException extends  RuntimeException{
    private static final long serialVersionUID = 847500838613349753L;

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

}
