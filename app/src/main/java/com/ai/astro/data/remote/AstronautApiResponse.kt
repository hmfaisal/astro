package com.ai.astro.data.remote

import com.ai.astro.data.remote.dto.AstronautDto

data class AstronautApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<AstronautDto>
)
