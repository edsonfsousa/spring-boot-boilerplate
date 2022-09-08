package com.springboot.boilerplate.springbootboilerplate.infrastructure.exception;

import javax.persistence.EntityNotFoundException;

public class IdFoundException extends EntityNotFoundException {

    public IdFoundException(Long id) {
        super(String.format("Id already registered", id));
    }
}
