package com.example.appAsamblea.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository(private val api: ApiService) {
    suspend fun login(nombre: String, curul: String, codigo: String) =
        api.login(mapOf("nombre" to nombre, "curul" to curul, "codigo" to codigo))

    suspend fun getEstadoReunion(id: String) = api.getEstadoReunion(id)
    // Agrega aquí los métodos para otros endpoints

    companion object {
        // Ejemplo de inicialización de Retrofit y uso del ApiService
        fun create(): Repository {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://tuservidor.api/") // Cambia por tu URL base
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiService = retrofit.create(ApiService::class.java)
            return Repository(apiService)
        }
    }
}
