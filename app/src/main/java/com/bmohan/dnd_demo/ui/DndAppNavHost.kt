package com.bmohan.dnd_demo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bmohan.dnd_demo.ui.screens.HomeScreen
import com.bmohan.dnd_demo.ui.screens.ItemListScreen
import com.bmohan.dnd_demo.ui.screens.SpellListScreen

@Composable
fun DndAppNavHost(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    NavHost(modifier = modifier, navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen { destination ->
                navController.navigate(destination)
            }
        }
        composable<HomeScreenNavDestinations.ItemList> {
            ItemListScreen(onBackPressed = {
                navController.popBackStack()
            })
        }
        composable<HomeScreenNavDestinations.SpellList> {
            SpellListScreen(onBackPressed = {
                navController.popBackStack()
            })
        }
    }
}