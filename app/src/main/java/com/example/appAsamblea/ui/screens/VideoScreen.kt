package com.example.appAsamblea.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun VideoScreen(navController: NavController) {
    // Aquí deberías usar ExoPlayer Compose, pero se muestra un placeholder
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("[Video se reproduce aquí]")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("palabra") }) {
            Text("Continuar")
        }
    }
}
