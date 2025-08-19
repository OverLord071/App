
package com.example.appAsamblea.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VotacionScreen(navController: NavController) {
    var yaVoto by remember { mutableStateOf(false) }
    var resumen by remember { mutableStateOf("Sí: 10, No: 5, Blanco: 2, Abstención: 1") }
    var loading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Votación", style = MaterialTheme.typography.titleLarge) })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!yaVoto) {
                Text("Elige tu voto:", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(
                        onClick = { yaVoto = true },
                        enabled = !loading,
                        modifier = Modifier.weight(1f)
                    ) { Text("Sí") }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { yaVoto = true },
                        enabled = !loading,
                        modifier = Modifier.weight(1f)
                    ) { Text("No") }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(
                        onClick = { yaVoto = true },
                        enabled = !loading,
                        modifier = Modifier.weight(1f)
                    ) { Text("Blanco") }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { yaVoto = true },
                        enabled = !loading,
                        modifier = Modifier.weight(1f)
                    ) { Text("Abstención") }
                }
            } else {
                Text("Ya votaste. Espera instrucciones.", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text("Resumen: $resumen", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
