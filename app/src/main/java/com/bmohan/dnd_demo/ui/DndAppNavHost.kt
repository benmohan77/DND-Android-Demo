package com.bmohan.dnd_demo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bmohan.dnd_demo.ui.screens.StartScreen

@Composable
fun DndAppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    NavHost(modifier = modifier, navController = navController, startDestination = Start) {
        composable<Start> {
            StartScreen()
        }
    }
}