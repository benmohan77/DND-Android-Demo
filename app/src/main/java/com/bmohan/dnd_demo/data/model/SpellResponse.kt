package com.bmohan.dnd_demo.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpellResponse(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("next")
    val next: String? = null,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<Spell?>? = null
) {
    @Serializable
    data class Spell(
        @SerialName("attack_roll")
        val attackRoll: Boolean? = null,
        @SerialName("casting_options")
        val castingOptions: List<CastingOption?>? = null,
        @SerialName("casting_time")
        val castingTime: String? = null,
        @SerialName("classes")
        val classes: List<CharacterClasses?>? = null,
        @SerialName("concentration")
        val concentration: Boolean? = null,
        @SerialName("damage_roll")
        val damageRoll: String? = null,
        @SerialName("damage_types")
        val damageTypes: List<String>? = null,
        @SerialName("desc")
        val desc: String? = null,
        @SerialName("document")
        val document: Document? = null,
        @SerialName("duration")
        val duration: String? = null,
        @SerialName("higher_level")
        val higherLevel: String? = null,
        @SerialName("key")
        val key: String? = null,
        @SerialName("level")
        val level: Int? = null,
        @SerialName("material")
        val material: Boolean? = null,
        @SerialName("material_consumed")
        val materialConsumed: Boolean? = null,
        @SerialName("material_cost")
        val materialCost: String? = null,
        @SerialName("material_specified")
        val materialSpecified: String? = null,
        @SerialName("name")
        val name: String? = null,
        @SerialName("range")
        val range: Int? = null,
        @SerialName("range_text")
        val rangeText: String? = null,
        @SerialName("range_unit")
        val rangeUnit: String? = null,
        @SerialName("reaction_condition")
        val reactionCondition: String? = null,
        @SerialName("ritual")
        val ritual: Boolean? = null,
        @SerialName("saving_throw_ability")
        val savingThrowAbility: String? = null,
        @SerialName("school")
        val school: School? = null,
        @SerialName("shape_size")
        val shapeSize: Int? = null,
        @SerialName("shape_size_unit")
        val shapeSizeUnit: String? = null,
        @SerialName("shape_type")
        val shapeType: String? = null,
        @SerialName("somatic")
        val somatic: Boolean? = null,
        @SerialName("target_count")
        val targetCount: Int? = null,
        @SerialName("target_type")
        val targetType: String? = null,
        @SerialName("verbal")
        val verbal: Boolean? = null
    ) {
        @Serializable
        data class CastingOption(
            @SerialName("concentration")
            val concentration: Boolean? = null,
            @SerialName("damage_roll")
            val damageRoll: String? = null,
            @SerialName("desc")
            val desc: String? = null,
            @SerialName("duration")
            val duration: String? = null,
            @SerialName("range")
            val range: String? = null,
            @SerialName("shape_size")
            val shapeSize: Int? = null,
            @SerialName("target_count")
            val targetCount: Int? = null,
            @SerialName("type")
            val type: String? = null
        )

        @Serializable
        data class CharacterClasses(
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
            val gamesystem: Gamesystem? = null,
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
            data class Gamesystem(
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
        data class School(
            @SerialName("key")
            val key: String? = null,
            @SerialName("name")
            val name: String? = null
        )
    }
}