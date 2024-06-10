package com.example.ktor_koin_cor.data.repository

import com.example.ktor_koin_cor.data.model.ApiResponse
import com.example.ktor_koin_cor.data.source.ApiService

class MyRepository(private val apiService: ApiService) {
    suspend fun getData(): ApiResponse {
        return apiService.fetchData()
    }
}
