package com.example.appAsamblea.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PalabraScreen(navController: NavController) {
    var enFila by remember { mutableStateOf(3) }
    var solicitando by remember { mutableStateOf(false) }
    var registroHabilitado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!solicitando) {
            Button(onClick = { solicitando = true }) {
                Text("Solicitar uso de la palabra")
            }
        } else {
            Text("En fila: $enFila")
            Button(onClick = { solicitando = false }) {
                Text("Cancelar pedido")
            }
        }
        if (registroHabilitado) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Registrar asistencia */ }) {
                Text("Registrar asistencia")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("votacion") }) {
            Text("Ir a votación")
        }
    }
}
