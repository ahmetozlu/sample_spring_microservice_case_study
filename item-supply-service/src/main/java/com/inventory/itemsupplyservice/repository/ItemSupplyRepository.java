package com.inventory.itemsupplyservice.repository;

import com.inventory.itemsupplyservice.model.ItemSupply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemSupplyRepository extends JpaRepository<ItemSupply, String> {

    Optional<ItemSupply> getItemSupplyByName(String name);
}
