package com.example.ktor_koin_cor.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktor_koin_cor.data.model.ApiResponse
import com.example.ktor_koin_cor.data.repository.MyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository) : ViewModel() {
    private val _response = MutableStateFlow<ApiResponse?>(null)
    val Response: StateFlow<ApiResponse?> get() = _response
    init {
        loadData()
    }
    fun loadData() {
        viewModelScope.launch {
            try {
              val data =  repository.getData()
                _response.value=repository.getData()
               Log.d("First Name",data.data?.lastName!!)

            } catch (e: Exception) {
                // Handle error
                Log.e("MyViewModel", "error there is no api data:", e) // Add this line to log the error
                println("error there is no api data ")
                _response.value = null
            }
        }
    }
}