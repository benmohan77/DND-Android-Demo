package com.bmohan.dnd_demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.bmohan.dnd_demo.R
import com.bmohan.dnd_demo.ui.components.DndTopAppBar
import com.bmohan.dnd_demo.ui.model.Item
import com.bmohan.dnd_demo.ui.vm.ItemListViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    onBackPressed: () -> Unit, viewModel: ItemListViewModel = hiltViewModel<ItemListViewModel>()
) {
    ItemListContent(itemPagingFlow = viewModel.itemPagingFlow, onBackPressed = onBackPressed)
}

@Composable
private fun ItemListContent(
    itemPagingFlow: Flow<PagingData<Item>>,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
) {
    Scaffold(topBar = {
        DndTopAppBar(title = stringResource(R.string.items), navigationIcon = {
            IconButton(onBackPressed) {
                Icon(painter = painterResource(R.drawable.arrow_back), contentDescription = null)
            }
        })
    }, modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val lazyPagingItems = itemPagingFlow.collectAsLazyPagingItems()
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
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
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = item.name, style = MaterialTheme.typography.titleLarge)
                Text(text = item.cost + " gp", modifier = Modifier.padding(top = 4.dp))
                Text(
                    text = item.weight + " " + item.weightUnit,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(text = item.description, modifier = Modifier.padding(top = 4.dp))
            }
        }
        HorizontalDivider()
    }
}

/**
 * weapon
 * armor
 * wondrous-item
 * tools
 * potion
 * adventuring-gear
 * ammunition
 * equipment-pack
 * mount
 * land-vehicle
 * scroll
 */

@Preview
@Composable
private fun ItemListPreview() {
    ItemListContent(flowOf(PagingData.empty())) { }
}