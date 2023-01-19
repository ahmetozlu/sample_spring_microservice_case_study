package com.inventory.inventoryservice.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;
    private final InventoryServiceClient inventoryServiceClient;

	@GrpcClient("item-service")
    private ItemServiceGrpc.ItemServiceBlockingStub itemServiceBlockingStub;

    public InventoryService(InventoryRepository inventoryRepository,
                          InventoryServiceClient inventoryServiceClient) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    public ItemDto getAllItemsInInventoryById(String id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory could not found by id: " + id));

        InventoryDto inventoryDto = new InventoryDto(inventory.getId(),
                inventory.getUserBook()
                        .stream()
                        .map(item -> itemServiceClient.getItemById(item).getBody())
                        .collect(Collectors.toList()));
        return inventoryDto;
    }
}