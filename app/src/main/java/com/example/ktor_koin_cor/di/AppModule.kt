package com.example.ktor_koin_cor.di

import com.example.ktor_koin_cor.data.repository.MyRepository
import com.example.ktor_koin_cor.presentation.viewModel.MyViewModel
import com.example.ktor_koin_cor.data.source.ApiService
import com.example.ktor_koin_cor.data.source.KtorClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { KtorClient.client }
    single { ApiService(get()) }
    single { MyRepository(get()) }
    viewModel { MyViewModel(get()) }
    //ok
}