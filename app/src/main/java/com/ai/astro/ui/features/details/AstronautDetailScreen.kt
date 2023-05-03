package com.ai.astro.ui.features.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import com.ai.astro.R
import com.ai.astro.ui.features.details.components.FlightList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AstronautDetailScreen(
    astronautId: Int,
    navController: NavController,
    viewModel: AstronautDetailViewModel = remember { AstronautDetailViewModel() }
) {

    val astronaut= viewModel.selectedAstronaut.value

    LaunchedEffect(astronautId) {
        viewModel.loadAstronautById(astronautId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = astronaut?.name ?: "") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back_navigation)
                        )
                    }
                }
            )
        }
    ) {
        astronaut?.let {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = it.imageUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    FlightList(it.flights)
                }
            }
        } ?: run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
