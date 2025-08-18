package com.example.appAsamblea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appAsamblea.ui.screens.LoginScreen
import com.example.appAsamblea.ui.screens.VideoScreen
import com.example.appAsamblea.ui.screens.PalabraScreen
import com.example.appAsamblea.ui.screens.VotacionScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Video : Screen("video")
    object Palabra : Screen("palabra")
    object Votacion : Screen("votacion")
}

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Video.route) { VideoScreen(navController) }
        composable(Screen.Palabra.route) { PalabraScreen(navController) }
        composable(Screen.Votacion.route) { VotacionScreen(navController) }
    }
}
