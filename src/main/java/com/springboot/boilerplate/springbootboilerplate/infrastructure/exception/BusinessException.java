package com.springboot.boilerplate.springbootboilerplate.infrastructure.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }

}
