package com.example.appAsamblea.data

import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionBuilder

class SignalRManager(hubUrl: String) {
    private val hubConnection: HubConnection = HubConnectionBuilder.create(hubUrl).build()

    fun startConnection(onConnected: (() -> Unit)? = null, onError: ((Throwable) -> Unit)? = null) {
        hubConnection.start().doOnComplete {
            onConnected?.invoke()
        }.doOnError {
            onError?.invoke(it)
        }.subscribe()
    }

    fun stopConnection() {
        hubConnection.stop()
    }

    fun onEvento(nombreEvento: String, handler: (String) -> Unit) {
        hubConnection.on(nombreEvento, handler, String::class.java)
    }

    fun send(nombreMetodo: String, vararg args: Any) {
        hubConnection.send(nombreMetodo, *args)
    }
}
