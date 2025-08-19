package com.example.appAsamblea

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appAsamblea.ui.components.OTPInput
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

sealed class Destination(val route: String) {
    object Login : Destination("login")
    object Video : Destination("video")
    object Palabra : Destination("palabra")
    object Votacion : Destination("votacion")
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Destination.Login.route, modifier = modifier) {
        composable(Destination.Login.route) { LoginScreen { navController.navigate(Destination.Video.route) } }
        composable(Destination.Video.route) { VideoScreen { navController.navigate(Destination.Palabra.route) } }
        composable(Destination.Palabra.route) { PalabraScreen(
            onVotacion = { navController.navigate(Destination.Votacion.route) }
        ) }
        composable(Destination.Votacion.route) { VotacionScreen() }
    }
}

@Composable
fun LoginScreen(onJoin: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var curul by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    val reunionId = "123456"
    var error by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Logo Aquí", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = curul, onValueChange = { curul = it }, label = { Text("Curul") })
        OTPInput(code = codigo, onCodeChange = { codigo = it })
        Text("ID de reunión: $reunionId")
        if (error.isNotEmpty()) Text(error, color = MaterialTheme.colorScheme.error)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (nombre.isNotBlank() && curul.isNotBlank() && codigo.length == 6) {
                onJoin()
            } else {
                error = "Datos inválidos"
            }
        }) {
            Text("Unirse")
        }
    }
}

@Composable
fun VideoScreen(onContinue: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("[Video se reproduce aquí]")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onContinue) {
            Text("Continuar")
        }
    }
}

@Composable
fun PalabraScreen(onVotacion: () -> Unit) {
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
        Button(onClick = onVotacion) {
            Text("Ir a votación")
        }
    }
}

@Composable
fun VotacionScreen() {
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
