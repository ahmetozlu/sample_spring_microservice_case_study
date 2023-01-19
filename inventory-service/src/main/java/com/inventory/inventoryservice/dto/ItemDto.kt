package com.inventory.inventoryservice.dto;


data class ItemDto @JvmOverloads constructor(val id: ItemIdDto? = null,
                                             val category: String? = "",
                                             val year: Int? = 0,
                                             val producer: String? = "",
                                             val country: String? = "") {



}