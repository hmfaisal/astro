package com.ai.astro.model.openai

data class Message(
    val content: String,
    val role: String
    ) {
    val isUser: Boolean
        get() = role == "user"
}
