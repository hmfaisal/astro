package com.ai.astro.ui.features.astronauts

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ai.astro.R
import com.ai.astro.data.remote.response.Astronaut

@Composable
fun AstronautItem(
    astronaut: Astronaut,
    onItemClick: (astronautId: Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .padding(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(astronaut.profileImageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column (
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
            ){
                Text(
                    text = astronaut.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = stringResource(R.string.age_field_holder),
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = astronaut.age.toString(),
                        fontStyle = FontStyle.Italic,
                        color = Color.Gray
                    )
                }


            }
            Column (
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .weight(1f)
                    .clickable(onClick = { onItemClick(astronaut.id) })
                    .fillMaxHeight(),
            ){
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(36.dp)
                )
            }

        }
    }
}
