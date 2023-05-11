package com.ai.astro.data.remote

import com.ai.astro.common.Constants.OPENAI_TOKEN
import com.ai.astro.data.remote.openai.OpenAiRequestBody
import com.ai.astro.data.remote.openai.OpenAiResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiApi {
    @Headers("Content-Type: application/json", "Authorization: Bearer $OPENAI_TOKEN")
    @POST("v1/chat/completions")
    suspend fun generateResponse(@Body requestBody: OpenAiRequestBody): OpenAiResponse
}