package com.saddy.helloapp.exception;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String message){
        super(message);
    }
}
