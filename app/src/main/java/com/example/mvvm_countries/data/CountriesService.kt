package com.example.mvvm_countries.data

import com.example.mvvm_countries.di.*
import io.reactivex.*
import javax.inject.*

class CountriesService {

    @Inject
    lateinit var api: CountriesApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }

}