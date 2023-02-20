package com.inventory.inventoryservice.repository;


import com.inventory.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
