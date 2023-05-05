package com.ai.astro.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ai.astro.R

@Composable
fun ChipView(text: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource)
    ) {
        Text(
            text = text, modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource(id = R.color.card)
        )
    }
}