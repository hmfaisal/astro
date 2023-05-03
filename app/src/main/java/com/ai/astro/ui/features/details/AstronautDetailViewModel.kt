package com.ai.astro.ui.features.details

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.astro.data.remote.repository.AstronautRepository
import com.ai.astro.data.remote.response.AstronautDetail
import kotlinx.coroutines.launch

class AstronautDetailViewModel: ViewModel() {

    private val repository = AstronautRepository()

    private val _selectedAstronaut = mutableStateOf<AstronautDetail?>(null)
    val selectedAstronaut: State<AstronautDetail?> = _selectedAstronaut

    private val _isLoading = mutableStateOf(false)

    // Function to get an astronaut by ID
    fun loadAstronautById(id: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val result = repository.getAstronautById(id)
                _selectedAstronaut.value = result
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load result with ID $id", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}