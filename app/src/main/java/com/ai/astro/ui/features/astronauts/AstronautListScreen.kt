package com.ai.astro.ui.features.astronauts

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ai.astro.R
import com.ai.astro.ui.core.Navigation
import com.ai.astro.ui.features.astronauts.components.AstronautItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AstronautListScreen(
    navController: NavController,
    viewModel: AstronautListViewModel
) {
    val astronauts = viewModel.astronautListState
    val isLoading = viewModel.isLoading

    LaunchedEffect(key1 = Unit) {
        viewModel.getAstronautList()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.home_navigation)) },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = colorResource(id = R.color.text),
                elevation = 0.dp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.background))
        ) {
            itemsIndexed(astronauts) { index, astronaut ->
                AstronautItem(astronaut) {
                    navController.navigate("${Navigation.Astronaut.route}/${astronaut.id}")
                }
                if (index == astronauts.lastIndex && !isLoading) {
                    viewModel.getAstronautList()
                }
            }
            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

