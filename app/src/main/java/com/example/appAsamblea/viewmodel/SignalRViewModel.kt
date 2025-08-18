package com.example.appAsamblea.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appAsamblea.data.SignalRManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignalRViewModel : ViewModel() {
    private val _mensaje = MutableStateFlow("")
    val mensaje: StateFlow<String> = _mensaje

    // Cambia la URL por la de tu hub real
    private val signalR = SignalRManager("https://TU_API_URL/hubNOMBRE")

    fun conectar() {
        signalR.startConnection(
            onConnected = {
                // Suscribirse a un evento llamado "RecibirMensaje"
                signalR.onEvento("RecibirMensaje") { data ->
                    _mensaje.value = data
                }
            },
            onError = {
                _mensaje.value = "Error de conexión: ${it.message}"
            }
        )
    }

    fun enviarMensaje(mensaje: String) {
        // Llama al método del hub, por ejemplo "EnviarMensaje"
        signalR.send("EnviarMensaje", mensaje)
    }

    fun desconectar() {
        signalR.stopConnection()
    }
}
