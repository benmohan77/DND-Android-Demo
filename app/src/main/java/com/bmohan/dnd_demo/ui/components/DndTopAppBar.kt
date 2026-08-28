package com.bmohan.dnd_demo.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bmohan.dnd_demo.ui.theme.DDDemoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DndTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(text = title)
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ), navigationIcon = navigationIcon, actions = actions, modifier = modifier
    )
}

@Preview
@Composable
private fun DndTopAppBarPreview() {
    DDDemoAppTheme {
        DndTopAppBar(title = "Test")
    }
}