package com.bmohan.dnd_demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.bmohan.dnd_demo.ui.vm.StartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(viewModel: StartViewModel = hiltViewModel<StartViewModel>()) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "DND App")
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val lazyPagingItems = viewModel.itemPagingFlow.collectAsLazyPagingItems()
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lazyPagingItems.itemCount, key = lazyPagingItems.itemKey { it.key!! }) { index ->
                    val item = lazyPagingItems[index]
                    item?.let {
                        Column {
                            Text(text = item.name!!)
                            Text(text = item.cost!!)
                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}