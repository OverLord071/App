package com.example.appAsamblea.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appAsamblea.navigation.Screen
import com.example.appAsamblea.ui.components.OTPInput

@Composable
fun LoginScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var curul by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    val reunionId = "123456" // Simulado
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo circular (reemplaza con tu recurso)
        // Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
        Text("Logo Aquí", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = curul, onValueChange = { curul = it }, label = { Text("Curul") })
        OTPInput(code = codigo, onCodeChange = { codigo = it })
        Text("ID de reunión: $reunionId")
        if (error.isNotEmpty()) Text(error, color = MaterialTheme.colorScheme.error)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Aquí iría la validación con backend
            if (nombre.isNotBlank() && curul.isNotBlank() && codigo.length == 6) {
                navController.navigate(Screen.Video.route)
            } else {
                error = "Datos inválidos"
            }
        }) {
            Text("Unirse")
        }
    }
}
