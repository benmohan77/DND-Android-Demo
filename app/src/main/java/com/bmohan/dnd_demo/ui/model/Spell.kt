package com.bmohan.dnd_demo.ui.model

import com.bmohan.dnd_demo.data.model.SpellResponse

data class Spell(val name: String, val key: String, val level: Int)

fun SpellResponse.Spell.toSpell(): Spell {
    return Spell(
        name = name!!,
        key = key!!,
        level = level!!
    )
}