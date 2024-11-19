package com.example.mvvm_countries.data

import io.reactivex.*
import retrofit2.http.*

interface CountriesApi {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<List<Country>>
}