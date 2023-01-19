package com.inventory.itemsupplyservice.dto

data class ItemSupplyIdDto @JvmOverloads constructor(
    val itemSupplyId: String? = "",
    val name: String
){

    companion object {
        @JvmStatic
        fun convert(id: String, name: String): ItemSupplyIdDto {
            return ItemSupplyIdDto(id, name)
        }
    }
}