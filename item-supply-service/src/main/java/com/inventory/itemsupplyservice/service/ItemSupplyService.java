package com.inventory.itemsupplyservice.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemSupplyService {
    private final ItemSupplyRepository repository;

    public ItemSupplyService(ItemSupplyRepository repository) {
        this.repository = repository;
    }
}