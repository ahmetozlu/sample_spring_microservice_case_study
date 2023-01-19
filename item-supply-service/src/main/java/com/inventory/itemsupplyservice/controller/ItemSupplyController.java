package com.inventory.itemsupplyservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/item")
@Validated
public class ItemSupplyController {

	Logger logger = LoggerFactory.getLogger(ItemController.class);
	private final ItemSupplyService itemSupplyService;

    public ItemSupplyController(ItemSupplyService itemSupplyService) {
        this.itemSupplyService = itemSupplyService;
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable @NotEmpty String id) {
        return ResponseEntity.ok(itemSupplyService.findItemDetailsById(id));
    }


}