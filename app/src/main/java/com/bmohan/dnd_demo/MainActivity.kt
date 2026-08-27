package com.bmohan.dnd_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bmohan.dnd_demo.ui.DndAppNavHost
import com.bmohan.dnd_demo.ui.theme.DDDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DDDemoAppTheme {
                DndAppNavHost()
            }
        }
    }
}