package com.inventory.inventoryservice.dto

data class ItemDto @JvmOverloads constructor(val id: ItemIdDto? = null,
                                             val title: String? = "",
                                             val year: Int? = 0,
                                             val producer: String? = "") {



}