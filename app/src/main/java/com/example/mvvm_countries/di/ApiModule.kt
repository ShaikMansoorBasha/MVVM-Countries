package com.example.mvvm_countries.di

import com.example.mvvm_countries.data.*
import dagger.Module
import dagger.Provides
import retrofit2.*
import retrofit2.adapter.rxjava2.*
import retrofit2.converter.gson.*
@Module
class ApiModule {
    private val BASE_URL = "https://raw.githubusercontent.com"
    @Provides
    fun provideCountriesAPI(): CountriesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)

    }
    @Provides
    fun provideCountriesService(): CountriesService {
        return CountriesService()
    }
}