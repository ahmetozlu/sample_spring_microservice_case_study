package com.inventory.inventoryservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-supply-service", path = "/v1/supply")
public interface ItemSupplyServiceClient {

    Logger logger = LoggerFactory.getLogger(ItemSupplyServiceClient.class);

    @GetMapping("/name/{name}")
    @CircuitBreaker(name = "getItemByNameCircuitBreaker", fallbackMethod = "getItemFallback")
    ResponseEntity<ItemIdDto> getItemByName(@PathVariable(value = "name") String name);

    default ResponseEntity<ItemIdDto> getItemFallback(String name, Exception exception) {
        logger.info("Item not found by name " + item + ", returning default ItemDto object");
        return ResponseEntity.ok(new ItemIdDto("default-item", "default-name"));
    }

    @GetMapping("/item/{itemId}")
    @CircuitBreaker(name = "getItemByIdCircuitBreaker", fallbackMethod = "getItemByIdFallback")
    ResponseEntity<BookDto> getItemById(@PathVariable(value = "itemId") String itemId);

    default ResponseEntity<ItemDto> getItemByIdFallback(String itemId, Exception exception) {
        logger.info("Item not found by id " + itemId + ", returning default ItemDto object");
        return ResponseEntity.ok(new ItemDto(new ItemIdDto("default-item", "name")));
    }

}