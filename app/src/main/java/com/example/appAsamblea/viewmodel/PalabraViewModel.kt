package com.example.appAsamblea.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PalabraViewModel : ViewModel() {
    private val _enFila = MutableStateFlow(0)
    val enFila: StateFlow<Int> = _enFila
    // Lógica para solicitar/cancelar palabra y registrar asistencia
}
