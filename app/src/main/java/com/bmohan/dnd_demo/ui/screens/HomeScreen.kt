package com.bmohan.dnd_demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bmohan.dnd_demo.R
import com.bmohan.dnd_demo.ui.HomeScreenNavDestinations
import com.bmohan.dnd_demo.ui.components.DndTopAppBar
import com.bmohan.dnd_demo.ui.theme.DDDemoAppTheme

@Composable
fun HomeScreen(navToScreen: (destination: HomeScreenNavDestinations) -> Unit) {
    HomeContent(
        navToScreen,
    )
}

@Composable
private fun HomeContent(
    navToScreen: (destination: HomeScreenNavDestinations) -> Unit, modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        DndTopAppBar(title = stringResource(R.string.open5e_browser))
    }, modifier = modifier) { paddingValues ->
        Column(modifier.padding(paddingValues)) {
            HomeNavigationButton(stringResource(R.string.items)) {
                navToScreen(HomeScreenNavDestinations.ItemList)
            }
        }
    }
}

@Composable
private fun HomeNavigationButton(title: String, onClick: () -> Unit) {
    Button(
        onClick, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(text = title)
    }
}

@Preview
@Composable
private fun HomePreview() {
    DDDemoAppTheme {
        HomeContent(navToScreen = {})
    }
}