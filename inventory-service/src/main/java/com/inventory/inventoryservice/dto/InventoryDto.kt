package com.inventory.inventoryservice.dto;

data class InventoryDto @JvmOverloads constructor(
    val id: String,
    val userItemList: List<ItemDto>? = ArrayList()
) {

}