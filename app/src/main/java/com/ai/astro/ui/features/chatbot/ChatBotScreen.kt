package com.ai.astro.ui.features.chatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.ai.astro.R
import com.ai.astro.ui.features.chatbot.component.MessageItem

@Composable
fun ChatBotScreen(
    viewModel: ChatBotViewModel = remember { ChatBotViewModel() }
) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = true
        ) {
            itemsIndexed(viewModel.messages.reversed()) { index, message ->
                if (message.isUser) {
                    MessageItem(message.content, Alignment.End)
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                } else {
                    MessageItem(message.content, Alignment.Start)
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.Bottom
        ) {
            var inputText by remember { mutableStateOf("") }
            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.textFieldColors(),
                label = { Text(stringResource(R.string.TYPE_A_MESSAGE)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = {
                    viewModel.sendMessage(inputText)
                    inputText = ""
                })
            )

            IconButton(
                onClick = {
                    viewModel.sendMessage(inputText)
                    inputText = ""
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.onSurface)
            ) {
                Icon(
                    Icons.Default.Send,
                    contentDescription = stringResource(R.string.SEND_BUTTON),
                    tint = MaterialTheme.colors.surface
                )
            }
        }
    }
}


