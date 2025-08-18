package com.example.appAsamblea.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun VotacionScreen(navController: NavController) {
    var yaVoto by remember { mutableStateOf(false) }
    var resumen by remember { mutableStateOf("Sí: 10, No: 5, Blanco: 2, Abstención: 1") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!yaVoto) {
            Text("Elige tu voto:", style = MaterialTheme.typography.headlineSmall)
            Row {
                Button(onClick = { yaVoto = true }) { Text("Sí") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { yaVoto = true }) { Text("No") }
            }
            Row {
                Button(onClick = { yaVoto = true }) { Text("Blanco") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { yaVoto = true }) { Text("Abstención") }
            }
        } else {
            Text("Ya votaste. Espera instrucciones.")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text("Resumen: $resumen")
    }
}
