package com.ai.astro.data.remote.astronaut

import com.ai.astro.data.remote.astronaut.dto.AstronautDto

data class AstronautApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<AstronautDto>
)
