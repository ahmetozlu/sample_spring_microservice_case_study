package com.inventory.inventoryservice.dto;

data class ItemIdDto @JvmOverloads constructor(
    val itemId: String? = "",
    val name: String? = ""
) {
    companion object {
        @JvmStatic
        fun convert(id: String, name: String): ItemIdDto {
            return ItemIdDto(id, name)

        }
    }

}
