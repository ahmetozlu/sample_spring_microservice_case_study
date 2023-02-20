package com.inventory.inventoryservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {

    Logger logger = LoggerFactory.getLogger(InventoryController.class);
    @RequestMapping("/")
    public String printHelloWorld() {

        logger.info("HELLO WORLD!");
        return "I just want to say hello -- Spring Boot!";
    }
}
