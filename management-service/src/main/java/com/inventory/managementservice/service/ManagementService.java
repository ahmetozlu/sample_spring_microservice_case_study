package com.inventory.managementservice.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagementService {

	private final ManagementRepository managementRepository;

	public ManagementService(ManagementRepository managementRepository,
                          ItemSupplyServiceClient itemSupplyServiceClient) {
        this.managementRepository = managementRepository;
        this.itemSupplyServiceClient = itemSupplyServiceClient;
    }

    public InventoryDto getAllItemsInInventoryById(String id) {
        Inventory inventory = managementRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory could not found by id: " + id));

        InventoryDto inventoryDto = new LibraryDto(inventory.getId(),
                inventory.getUserBook()
                        .stream()
                        .map(item -> itemSupplyServiceClient.getItemById(item).getBody())
                        .collect(Collectors.toList()));
        return inventoryDto;
    }

}