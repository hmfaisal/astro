package com.ai.astro.data.remote.openai

import com.ai.astro.common.Constants.OPENAI_MODEL
import com.ai.astro.model.openai.Message

data class OpenAiRequestBody(
    val model: String = OPENAI_MODEL,
    val messages: List<Message>,
    val max_tokens: Int = 50,
    val n: Int = 1,
    val temperature: Double = 1.0
)
