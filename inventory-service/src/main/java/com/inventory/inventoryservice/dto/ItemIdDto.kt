package com.inventory.inventoryservice.dto

data class ItemIdDto @JvmOverloads constructor(
    val itemId: String? = "",
    val productId: String? = ""
) {
    companion object {
        @JvmStatic
        fun convert(itemId: String, productId: String): ItemIdDto {
            return ItemIdDto(itemId, productId)

        }
    }
}