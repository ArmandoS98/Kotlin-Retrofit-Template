package com.example.animeapi.api

import com.example.animeapi.model.Anime
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/available/anime")
    suspend fun getAnimes(): Response<List<String>>
}