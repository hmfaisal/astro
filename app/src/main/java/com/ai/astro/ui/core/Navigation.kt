package com.ai.astro.ui.core

import androidx.annotation.StringRes
import com.ai.astro.R

sealed class Navigation(val route: String, @StringRes val resourceId: Int) {
    object Astronauts : Navigation("astronauts", R.string.home_navigation)
    object Astronaut : Navigation("astronaut", R.string.details_navigation)
    object Chatbot : Navigation("chatbot", R.string.chatbot_navigation)
}