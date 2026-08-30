package com.bmohan.dnd_demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.bmohan.dnd_demo.R
import com.bmohan.dnd_demo.ui.components.DndTopAppBar
import com.bmohan.dnd_demo.ui.model.Spell
import com.bmohan.dnd_demo.ui.vm.SpellListViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun SpellListScreen(onBackPressed: () -> Unit, viewModel: SpellListViewModel = hiltViewModel()) {
    SpellListContent(spellPagingFlow = viewModel.spellPagingFlow, onBackPressed = onBackPressed)
}

@Composable
private fun SpellListContent(
    spellPagingFlow: Flow<PagingData<Spell>>,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
) {
    Scaffold(topBar = {
        DndTopAppBar(title = stringResource(R.string.spells), navigationIcon = {
            IconButton(onBackPressed) {
                Icon(painter = painterResource(R.drawable.arrow_back), contentDescription = null)
            }
        })
    }, modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            val lazyPagingSpells = spellPagingFlow.collectAsLazyPagingItems()
            val state = lazyPagingSpells.loadState.refresh
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(
                    lazyPagingSpells.itemCount,
                    key = lazyPagingSpells.itemKey { it.key }) { index ->
                    val item = lazyPagingSpells[index]
                    item?.let {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(it.name)
                            HorizontalDivider()
                        }
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