package com.inventory.inventoryservice.service;

import com.inventory.inventoryservice.dto.AddInventoryRequest;
import com.inventory.inventoryservice.model.Inventory2;
import com.inventory.inventoryservice.repository.InventoryRepository;
import com.inventory.inventoryservice.dto.InventoryDto;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryDto createLibrary() {
        Inventory2 newInventory = inventoryRepository.save(new Inventory2());
        return new InventoryDto(newInventory.getId());
    }

    public InventoryDto createInventory(AddInventoryRequest addInventoryRequest) {
        Inventory2 newInventory = inventoryRepository.save(new Inventory2("",addInventoryRequest.getUserItemList()));
        return new InventoryDto(newInventory.getId(), newInventory.getUserItem());
    }

}
