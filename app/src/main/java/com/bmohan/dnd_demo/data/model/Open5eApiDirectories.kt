package com.bmohan.dnd_demo.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Open5eApiDirectories(
    @SerialName("ability-scores")
    val abilityScores: String? = null,
    @SerialName("alignments")
    val alignments: String? = null,
    @SerialName("backgrounds")
    val backgrounds: String? = null,
    @SerialName("classes")
    val classes: String? = null,
    @SerialName("conditions")
    val conditions: String? = null,
    @SerialName("damage-types")
    val damageTypes: String? = null,
    @SerialName("equipment")
    val equipment: String? = null,
    @SerialName("equipment-categories")
    val equipmentCategories: String? = null,
    @SerialName("feats")
    val feats: String? = null,
    @SerialName("features")
    val features: String? = null,
    @SerialName("languages")
    val languages: String? = null,
    @SerialName("magic-items")
    val magicItems: String? = null,
    @SerialName("magic-schools")
    val magicSchools: String? = null,
    @SerialName("monsters")
    val monsters: String? = null,
    @SerialName("proficiencies")
    val proficiencies: String? = null,
    @SerialName("races")
    val races: String? = null,
    @SerialName("rule-sections")
    val ruleSections: String? = null,
    @SerialName("rules")
    val rules: String? = null,
    @SerialName("skills")
    val skills: String? = null,
    @SerialName("spells")
    val spells: String? = null,
    @SerialName("subclasses")
    val subclasses: String? = null,
    @SerialName("subraces")
    val subraces: String? = null,
    @SerialName("traits")
    val traits: String? = null,
    @SerialName("weapon-properties")
    val weaponProperties: String? = null
)