package com.inventory.inventoryservice.repository;


import com.inventory.inventoryservice.model.Inventory2;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory2, String> {
}
