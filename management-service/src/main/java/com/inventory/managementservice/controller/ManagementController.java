package com.inventory.managementservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/v1/management")
public class ManagementController {

	Logger logger = LoggerFactory.getLogger(ManagementController.class);
	private final ManagementService managementService;


	public ManagementController(ManagementService managementService) {
        this.managementService = managementService;        
    }

    @GetMapping("{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable String id) {
        return ResponseEntity.ok(managementService.getAllItemsInInventoryById(id));
    }

}
