package com.example.weatherapp.data.remote

import com.example.weatherapp.R
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @GET("/v1/geo/cities")
    suspend fun getCities(@Query("key") key: Int = R.string.api_key)
}