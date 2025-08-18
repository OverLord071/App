package com.example.appAsamblea.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VotacionViewModel : ViewModel() {
    private val _yaVoto = MutableStateFlow(false)
    val yaVoto: StateFlow<Boolean> = _yaVoto
    // Lógica para votar y mostrar resumen
}
