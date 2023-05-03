package com.ai.astro.ui.features.astronauts

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.astro.data.remote.repository.AstronautRepository
import com.ai.astro.data.remote.response.Astronaut
import kotlinx.coroutines.launch

class AstronautListViewModel : ViewModel() {

    private val repository = AstronautRepository()

    private val _astronauts = mutableStateOf<List<Astronaut>>(emptyList())
    val astronauts: State<List<Astronaut>> = _astronauts

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private var currentPage = 1

    fun loadAstronauts() {
        if (_isLoading.value) {
            return
        }
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val pageSize = 10
                val results = repository.getAstronauts(currentPage, pageSize)
                _astronauts.value = _astronauts.value + results
                currentPage += 1
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load results", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}
