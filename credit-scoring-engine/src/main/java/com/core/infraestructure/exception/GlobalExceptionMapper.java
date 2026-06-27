package com.core.infraestructure.exception;


public class GlobalExceptionMapper extends RuntimeException {
    public GlobalExceptionMapper(String message) {
        super(message);
    }
}
