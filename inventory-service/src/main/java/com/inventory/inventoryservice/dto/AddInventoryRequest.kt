package com.inventory.inventoryservice.dto

data class AddInventoryRequest (
    val userItemList: List<String>? = ArrayList()
)