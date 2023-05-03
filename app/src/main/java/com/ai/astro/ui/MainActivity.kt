package com.ai.astro.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ai.astro.ui.features.astronauts.AstronautListScreen
import com.ai.astro.ui.features.details.AstronautDetailScreen
import com.ai.astro.ui.theme.AstroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AstroTheme {
                AstronautApp()
            }
        }
    }
}

@Composable
private fun AstronautApp() {
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