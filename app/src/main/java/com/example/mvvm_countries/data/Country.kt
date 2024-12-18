package com.example.mvvm_countries.data

import com.google.gson.annotations.SerializedName

data class Country(
        @SerializedName("name")
        val countryName: String?,
        @SerializedName("capital")
        val capital: String?,
        @SerializedName("flagPNG")
        val flag: String?)