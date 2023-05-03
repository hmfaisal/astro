package com.ai.astro.ui.features.astronauts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ai.astro.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AstronautListScreen(
    navController: NavController,
    viewModel: AstronautListViewModel = remember { AstronautListViewModel() }
) {
    val astronauts = viewModel.astronauts.value
    val isLoading = viewModel.isLoading.value

    LaunchedEffect(key1 = Unit) {
        viewModel.loadAstronauts()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.home_navigation)) },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            )
        }
    ) {
        LazyColumn {
            itemsIndexed(astronauts) { index, astronaut ->
                AstronautItem(astronaut) {
                    navController.navigate("astronaut/${astronaut.id}")
                }
                if (index == astronauts.lastIndex && !isLoading) {
                    viewModel.loadAstronauts()
                }
            }
            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
