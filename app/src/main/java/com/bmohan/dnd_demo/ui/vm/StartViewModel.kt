package com.bmohan.dnd_demo.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bmohan.dnd_demo.data.model.SRDApiDirectories
import com.bmohan.dnd_demo.data.service.SrdAPIService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val srdAPIService: SrdAPIService): ViewModel() {

    private val _state = MutableStateFlow<StartState>(StartState.Loading)
    val state: StateFlow<StartState> = _state

    init {
        viewModelScope.launch {
            val directoriesResponse = srdAPIService.get2014Directories()
            _state.value = if(directoriesResponse.isSuccessful && directoriesResponse.body() != null) {
                StartState.Success(directoriesResponse.body()!!)
            } else {
                StartState.Error(directoriesResponse.message())
            }
        }
    }


    sealed class StartState {
        object Loading: StartState()
        data class Error(val message: String): StartState()
        data class Success(val directories: SRDApiDirectories): StartState()
    }

}