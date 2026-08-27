package com.bmohan.dnd_demo.ui.model

import com.bmohan.dnd_demo.data.model.ItemResponse

data class Item(
    val category: String,
    val cost: String,
    val description: String,
    val source: String,
    val key: String,
    val name: String,
    val size: String,
    val weight: String,
    val weightUnit: String
)

fun ItemResponse.Item.toItem() : Item {
    return Item(
        category = category!!.name!!,
        cost = cost!!,
        description = desc!!,
        source = document!!.name!!,
        key = key!!,
        name = name!!,
        size = size?.name!!,
        weight = weight!!,
        weightUnit = weightUnit!!
    )
}