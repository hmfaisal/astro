package com.ai.astro.ui.features.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ai.astro.R
import com.ai.astro.data.remote.dto.FlightDto

@Composable
fun FlightList(flights:List<FlightDto>){
    Column {
        for ((index, flight) in flights.withIndex()) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(id = R.color.card))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = flight.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    color = colorResource(id = R.color.text),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}