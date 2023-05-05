package com.ai.astro.ui.features.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.ai.astro.R
import com.ai.astro.ui.common.Title
import com.ai.astro.ui.features.details.components.AstronautInfoCard
import com.ai.astro.ui.features.details.components.BioCard
import com.ai.astro.ui.features.details.components.FlightList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AstronautDetailScreen(
    astronautId: Int,
    navController: NavController,
    viewModel: AstronautDetailViewModel = remember { AstronautDetailViewModel() }
) {

    val astronaut= viewModel.astronautDetailState.value

    LaunchedEffect(astronautId) {
        viewModel.getAstronautDetails(astronautId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.details_navigation)) },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = colorResource(id = R.color.text),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = colorResource(id = R.color.text)
                    )
                }
            )
        },

        content = {
            astronaut?.let {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.background))
                ) {
                    item {
                        astronaut.apply {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(346.dp),
                                painter = rememberAsyncImagePainter(model = it.profileImageUrl),
                                alignment = Alignment.CenterStart,
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            AstronautInfoCard(it.name, it.age, it.nationality, it.status.name, it.flightsCount)
                        }
                    }
                    item{
                        astronaut.apply {
                            Spacer(modifier = Modifier.height(24.dp))
                            Title(title = stringResource(R.string.bio_card_holder))
                            Spacer(modifier = Modifier.height(16.dp))
                            BioCard(it.bio)
                        }
                    }
                    item{
                        astronaut.apply {
                            Spacer(modifier = Modifier.height(24.dp))
                            Title(title = stringResource(R.string.flight_card_holder))
                            Spacer(modifier = Modifier.height(16.dp))
                            it.flights?.let { it1 -> FlightList(it1) }
                        }
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
    )
}
