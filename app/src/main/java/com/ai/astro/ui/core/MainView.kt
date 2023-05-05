package com.ai.astro.ui.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ai.astro.ui.features.astronauts.AstronautListScreen
import com.ai.astro.ui.features.details.AstronautDetailScreen

@Composable
fun MainView() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "astronaut") {
        composable("astronaut") {
            AstronautListScreen(navController = navController)
        }
        composable("astronaut/{astronautId}") { backStackEntry ->
            AstronautDetailScreen(
                astronautId = backStackEntry.arguments?.getString("astronautId")?.toInt() ?: 1,
                navController = navController
            )
        }
    }
}