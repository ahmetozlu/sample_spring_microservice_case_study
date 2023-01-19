package com.inventory.inventoryservice.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	private final ItemSupplyServiceClient itemSupplyServiceClient;

	@GrpcClient("item-stock-service")
	private ItemStockServiceGrpc.ItemStockServiceBlockingStub itemStockServiceBlockingStub;

	public InventoryService(InventoryRepository inventoryRepository,
		ItemSupplyServiceClient itemSupplyServiceClient) {
		this.inventoryRepository = inventoryRepository;
		this.itemSupplyServiceClient = itemSupplyServiceClient;
	}

    public ItemDto getAllItemsInInventoryById(String id) { // TODO: getItemPriceById
	Inventory inventory = inventoryRepository.findById(id)
		.orElseThrow(() -> new InventoryNotFoundException("Inventory could not found by id: " + id));

	InventoryDto inventoryDto = new InventoryDto(inventory.getId(),
		inventory.getUserItem()
			.stream()
			.map(item -> itemSupplyServiceClient.getItemById(item).getBody())
			.collect(Collectors.toList()));
	return inventoryDto;
    }

    public void addItemToInventory(AddItemRequest request) {
        ItemId itemIdByName = itemStockServiceBlockingStub.getItemIdByName(Name.newBuilder().setName(request.getName()).build());
        String itemId = itemIdByName.getItemId();

        Inventory inventory = inventoryRepository.findById(request.getId())
                .orElseThrow(() -> new InventoryNotFoundException("Inventory could not found by id: " + request.getId()));

        inventory.getUserBook()
                .add(itemId);

        inventoryRepository.save(inventory);
    }

    public List<String> getAllInventories() {

        return inventoryRepository.findAll()
                .stream()
                .map(l -> l.getId())
                .collect(Collectors.toList());
    }
}