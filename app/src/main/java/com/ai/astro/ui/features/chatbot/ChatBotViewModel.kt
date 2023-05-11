package com.ai.astro.ui.features.chatbot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.astro.data.repository.OpenAiRepository
import com.ai.astro.model.openai.Message
import kotlinx.coroutines.launch

class ChatBotViewModel(
    private val repository: OpenAiRepository = OpenAiRepository()
): ViewModel()  {
    val messages = mutableStateListOf<Message>()

    fun sendMessage(text: String, isUser: Boolean = true) {
        messages.add(Message(text, role = "user"))
        if (isUser) {
            viewModelScope.launch {
                val response = repository.generateResponse(messages)
                messages.add(response.choices.first().message)
            }
        }
    }
}