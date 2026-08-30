package com.bmohan.dnd_demo.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bmohan.dnd_demo.data.repository.SpellRepository
import com.bmohan.dnd_demo.ui.model.Spell
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SpellListViewModel @Inject constructor(spellRepository: SpellRepository) : ViewModel() {
    val spellPagingFlow: Flow<PagingData<Spell>> =
        spellRepository.getSpellsPaged().flow.cachedIn(viewModelScope)
}