package com.bmohan.dnd_demo.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bmohan.dnd_demo.data.repository.ItemRepository
import com.bmohan.dnd_demo.ui.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(itemRepository: ItemRepository) : ViewModel() {

    val itemPagingFlow: Flow<PagingData<Item>> =
        itemRepository.getItemsPaged().flow.cachedIn(viewModelScope)
}