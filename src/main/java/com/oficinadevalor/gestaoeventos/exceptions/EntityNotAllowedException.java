package com.oficinadevalor.gestaoeventos.exceptions;

public class EntityNotAllowedException extends RuntimeException {
    public EntityNotAllowedException(String message) {
        super(message);
    }
}
