package com.example.mvvm_countries.di

import com.example.mvvm_countries.data.*
import com.example.mvvm_countries.viewmodel.*
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}