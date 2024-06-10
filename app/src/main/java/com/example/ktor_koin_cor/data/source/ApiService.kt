package com.example.ktor_koin_cor.data.source

import com.example.ktor_koin_cor.data.model.ApiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiService(private val client: HttpClient) {
    suspend fun fetchData() = client.get("https://reqres.in/api/users/2").body<ApiResponse>()
}