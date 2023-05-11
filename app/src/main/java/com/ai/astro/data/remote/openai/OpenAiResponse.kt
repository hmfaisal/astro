package com.ai.astro.data.remote.openai

import com.ai.astro.model.openai.Message

data class OpenAiResponse(
    val choices: List<MessageResponse>
)

data class MessageResponse(
    val message: Message
)
