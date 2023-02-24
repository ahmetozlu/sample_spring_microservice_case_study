package com.inventory.inventoryservice.controller;

import com.inventory.inventoryservice.service.InventoryService;
import com.inventory.inventoryservice.dto.InventoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {

    Logger logger = LoggerFactory.getLogger(InventoryController.class);

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    /*@RequestMapping("/")
    public String printHelloWorld() {

        logger.info("HELLO WORLD!");
        return "I just want to say hello -- Spring Boot!";
    }*/

    //@PostMapping
    @RequestMapping("/")
    public ResponseEntity<InventoryDto> createLibrary() {
        logger.info("HELLO WORLD2!");
        return ResponseEntity.ok(inventoryService.createLibrary());
    }
}
