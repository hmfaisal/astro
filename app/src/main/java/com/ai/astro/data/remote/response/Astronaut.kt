package com.ai.astro.data.remote.response

import com.google.gson.annotations.SerializedName

data class Astronaut(
    val id: Int,
    val name: String,
    val age: Int,
    @SerializedName("profile_image_thumbnail")
    val profileImageUrl: String
)
