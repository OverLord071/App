
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
fun PalabraScreen(navController: NavController) {
    var enFila by remember { mutableStateOf(3) }
    var solicitando by remember { mutableStateOf(false) }
    var registroHabilitado by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Solicitar Palabra", style = MaterialTheme.typography.titleLarge) })
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
            if (!solicitando) {
                Button(
                    onClick = { solicitando = true },
                    enabled = !loading,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (loading) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                    } else {
                        Text("Solicitar uso de la palabra")
                    }
                }
            } else {
                Text("En fila: $enFila", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { solicitando = false },
                    enabled = !loading,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cancelar pedido")
                }
            }
            if (registroHabilitado) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Registrar asistencia */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Registrar asistencia")
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate("votacion") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir a votación")
            }
        }
    }
}
