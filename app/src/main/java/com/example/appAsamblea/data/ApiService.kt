package com.example.appAsamblea.data

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Query

interface ApiService {
    @POST("/login")
    suspend fun login(@Body body: Map<String, String>): ApiResponse

    @GET("/estado-reunion")
    suspend fun getEstadoReunion(@Query("id") id: String): EstadoReunionResponse

    // Agrega aquí los demás endpoints según tu backend
}

data class ApiResponse(val success: Boolean, val message: String)
data class EstadoReunionResponse(val estado: String)
