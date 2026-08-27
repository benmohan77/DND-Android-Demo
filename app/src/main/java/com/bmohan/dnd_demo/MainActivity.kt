package com.bmohan.dnd_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bmohan.dnd_demo.ui.screens.DndAppNavHost
import com.bmohan.dnd_demo.ui.theme.DDDemoAppTheme

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