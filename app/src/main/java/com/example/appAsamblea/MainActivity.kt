package com.example.appAsamblea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appAsamblea.ui.theme.AppAsambleaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppAsambleaTheme {
                AppNavHost()
            }
        }
    }
}
