package com.springboot.boilerplate.springbootboilerplate.infrastructure.exception;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public class IdFoundException extends EntityNotFoundException {

    public IdFoundException(UUID id) {
        super(String.format("Id already registered", id));
    }
}
