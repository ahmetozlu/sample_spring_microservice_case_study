package com.inventory.inventoryservice.exception;

public class InventoryNotFoundException extends RuntimeException{

    public InventoryNotFoundException(String message) {
        super(message);
    }
}
