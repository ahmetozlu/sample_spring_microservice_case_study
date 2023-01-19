package com.inventory.itemsupplyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemSupplyNotFoundException extends RuntimeException {
    public ItemSupplyNotFoundException(String s) {
        super(s);
    }
}
