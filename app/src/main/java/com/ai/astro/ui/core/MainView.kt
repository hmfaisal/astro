package com.ai.astro.ui.core

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ai.astro.ui.features.astronauts.AstronautListScreen
import com.ai.astro.ui.features.astronauts.AstronautListViewModel
import com.ai.astro.ui.features.details.AstronautDetailScreen

@Composable
fun MainView() {
    val navController = rememberNavController()
    val viewModel: AstronautListViewModel = viewModel()
    NavHost(
        navController,
        startDestination = Navigation.Astronauts.route
    ) {
        composable(
            route = Navigation.Astronauts.route,

        ) {
            AstronautListScreen(navController = navController, viewModel = viewModel)
        }
        composable("${Navigation.Astronaut.route}/{astronautId}") { backStackEntry ->
            AstronautDetailScreen(
                astronautId = backStackEntry.arguments?.getString("astronautId")?.toInt() ?: 1,
                navController = navController
            )
        }
    }
}
