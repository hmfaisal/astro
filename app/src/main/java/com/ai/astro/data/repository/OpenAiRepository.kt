package com.ai.astro.data.repository

import com.ai.astro.data.remote.OpenAiApi
import com.ai.astro.data.remote.openai.OpenAiRequestBody
import com.ai.astro.data.remote.openai.OpenAiResponse
import com.ai.astro.model.openai.Message
import com.ai.astro.ui.AstroApp

class OpenAiRepository(
    private val OpenAiApiService: OpenAiApi = AstroApp.openAiApiService,
) {
    suspend fun generateResponse(message: List<Message>): OpenAiResponse {
        return OpenAiApiService.generateResponse(OpenAiRequestBody(messages = message))
    }
}