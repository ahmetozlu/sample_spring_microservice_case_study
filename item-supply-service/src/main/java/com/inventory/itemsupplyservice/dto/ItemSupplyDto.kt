package com.inventory.itemsupplyservice.dto

import com.kitaplik.bookservice.model.ItemSupply

data class ItemSupplyDto @JvmOverloads constructor(
    val id: ItemSupplyIdDto? = null,
    val category: String,
    val itemSupplyYear: Int,
    val producer: String,
    val country: String
) {
    companion object {
        @JvmStatic
        fun convert(from: ItemSupply): ItemSupplyDto {
            return ItemSupplyDto(
                from.id?.let { ıtemSupplyIdDto.convert(it, from.name) },
                from.category,
                from.itemSupplyYear,
                from.producer,
                from.country
            )
        }
    }
}