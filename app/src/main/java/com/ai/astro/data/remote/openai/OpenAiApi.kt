package com.ai.astro.data.remote

import com.ai.astro.data.remote.openai.OpenAiRequestBody
import com.ai.astro.data.remote.openai.OpenAiResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiApi {
    @Headers("Content-Type: application/json", "Authorization: Bearer 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")
    @POST("v1/chat/completions")
    suspend fun generateResponse(@Body requestBody: OpenAiRequestBody): OpenAiResponse
}