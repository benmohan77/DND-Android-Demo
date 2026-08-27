package com.bmohan.dnd_demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.bmohan.dnd_demo.ui.model.Item
import com.bmohan.dnd_demo.ui.vm.ItemListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(viewModel: ItemListViewModel = hiltViewModel<ItemListViewModel>()) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Items")
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val lazyPagingItems = viewModel.itemPagingFlow.collectAsLazyPagingItems()
            val state = lazyPagingItems.loadState.refresh
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(
                    lazyPagingItems.itemCount, key = lazyPagingItems.itemKey { it.key }) { index ->
                    val item = lazyPagingItems[index]
                    item?.let {
                        ItemListElement(it)
                    }
                }
                if (state is LoadState.Loading) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemListElement(item: Item, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = item.name)
            Text(text = item.cost + " gp", modifier = Modifier.padding(top = 4.dp))
            Text(text = item.description, modifier = Modifier.padding(top = 4.dp))
        }
        HorizontalDivider()
    }

}