package com.bmohan.dnd_demo.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bmohan.dnd_demo.data.model.ItemResponse
import com.bmohan.dnd_demo.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {

    private val _state = MutableStateFlow<StartState>(StartState.Loading)
//    val state: StateFlow<StartState> = _state

    val itemPagingFlow: Flow<PagingData<ItemResponse.Item>> =
        itemRepository.getItemsPaged().flow.cachedIn(viewModelScope)

    sealed class StartState {
        object Loading : StartState()
        data class Error(val message: String) : StartState()
        data class Success(val items: List<ItemResponse.Item>) : StartState()
    }

}