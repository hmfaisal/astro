package com.ai.astro.ui.core

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ai.astro.ui.features.astronauts.AstronautListScreen
import com.ai.astro.ui.features.astronauts.AstronautListViewModel
import com.ai.astro.ui.features.chatbot.ChatBotScreen
import com.ai.astro.ui.features.details.AstronautDetailScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainView() {
    val navController = rememberNavController()
    val viewModel: AstronautListViewModel = viewModel()
    val chatScreenVisible = remember { mutableStateOf(false) }

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController,
                startDestination = Navigation.Astronauts.route
            ) {
                composable(route = Navigation.Astronauts.route) {
                    AstronautListScreen(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                composable("${Navigation.Astronaut.route}/{astronautId}") { backStackEntry ->
                    AstronautDetailScreen(
                        astronautId = backStackEntry.arguments?.getString("astronautId")?.toInt()
                            ?: 1,
                        navController = navController
                    )
                }
            }

            if (chatScreenVisible.value) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.3f)
                        .align(Alignment.BottomCenter)
                ) {
                    ChatBotScreen()
                }
            }

            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.surface,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(8.dp, 8.dp),
                modifier = Modifier
                    .padding(all = 16.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = if (chatScreenVisible.value) -(LocalConfiguration.current.screenHeightDp * 0.3).dp else 0.dp),
                onClick = { chatScreenVisible.value = !chatScreenVisible.value }
            ) {
                Icon(
                    tint = MaterialTheme.colors.onSurface,
                    imageVector = if (chatScreenVisible.value) Icons.Default.Close else Icons.Default.ChatBubble,
                    contentDescription = if (chatScreenVisible.value) "Close" else "Chat"
                )
            }
        }
    }
}
