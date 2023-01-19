package com.inventory.inventoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {

    private ExceptionMessage exceptionMessage;
    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public ItemNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
