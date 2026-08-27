package com.bmohan.dnd_demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
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
            when(val state = viewModel.state.collectAsState().value) {
                is StartViewModel.StartState.Error -> {

                }
                StartViewModel.StartState.Loading -> {
                    CircularProgressIndicator()
                }
                is StartViewModel.StartState.Success -> {
                    Text(text = state.directories.skills ?: "Skills?")
                    Text(text = state.directories.weaponProperties ?: "Weapon Properties")
                    Text(text = state.directories.spells ?: "Spells?")
                }
            }
        }
    }
}