package com.bmohan.dnd_demo.ui

import kotlinx.serialization.Serializable

sealed class HomeScreenNavDestinations {
    @Serializable
    object ItemList: HomeScreenNavDestinations()
}

@Serializable
object Home