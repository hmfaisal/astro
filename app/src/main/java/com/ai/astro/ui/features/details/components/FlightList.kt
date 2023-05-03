package com.ai.astro.ui.features.details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ai.astro.R
import com.ai.astro.data.remote.response.Flight

@Composable
fun FlightList(flights:List<Flight>){
    Text(
        text = stringResource(R.string.flight_card_holder),
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
    Divider(color=Color.Gray, thickness = 1.dp)
    LazyColumn(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        itemsIndexed(flights) {index,flight ->
            Text(
                text = flight.name,
                style = MaterialTheme.typography.body1,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            if (index != flights.lastIndex) {
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}