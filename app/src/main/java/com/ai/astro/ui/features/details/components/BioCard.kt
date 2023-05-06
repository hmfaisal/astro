package com.ai.astro.ui.features.details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ai.astro.R

@Composable
fun BioCard(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        color = colorResource(id = R.color.text),
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Start
    )
}