package com.example.animeapi.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/available/anime")
    suspend fun getAnimes(): Response<List<String>>
}