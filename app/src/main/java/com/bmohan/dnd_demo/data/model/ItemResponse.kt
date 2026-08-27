package com.bmohan.dnd_demo.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("next")
    val next: String? = null,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<Item>? = null
) {
    @Serializable
    data class Item(
        @SerialName("category")
        val category: Category? = null,
        @SerialName("cost")
        val cost: String? = null,
        @SerialName("desc")
        val desc: String? = null,
        @SerialName("document")
        val document: Document? = null,
        @SerialName("key")
        val key: String? = null,
        @SerialName("name")
        val name: String? = null,
        @SerialName("size")
        val size: Size? = null,
        @SerialName("weight")
        val weight: String? = null,
        @SerialName("weight_unit")
        val weightUnit: String? = null
    ) {
        @Serializable
        data class Category(
            @SerialName("key")
            val key: String? = null,
            @SerialName("name")
            val name: String? = null
        )

        @Serializable
        data class Document(
            @SerialName("display_name")
            val displayName: String? = null,
            @SerialName("gamesystem")
            val gamesystem: GameSystem? = null,
            @SerialName("key")
            val key: String? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("permalink")
            val permalink: String? = null,
            @SerialName("publisher")
            val publisher: Publisher? = null,
            @SerialName("type")
            val type: String? = null
        ) {
            @Serializable
            data class GameSystem(
                @SerialName("key")
                val key: String? = null,
                @SerialName("name")
                val name: String? = null
            )

            @Serializable
            data class Publisher(
                @SerialName("key")
                val key: String? = null,
                @SerialName("name")
                val name: String? = null
            )
        }

        @Serializable
        data class Size(
            @SerialName("key")
            val key: String? = null,
            @SerialName("name")
            val name: String? = null
        )
    }
}