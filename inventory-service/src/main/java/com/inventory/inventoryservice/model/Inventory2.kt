package com.inventory.inventoryservice.model

import com.inventory.inventoryservice.dto.ItemDto
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Inventory2 @JvmOverloads constructor(
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    @ElementCollection
    val userItem: List<String> = ArrayList()

)