package com.example.peliculasdam.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/")
    suspend fun searchMovies(@Query("s") query: String, @Query("apikey") apiKey: String): MovieSearchResponse

    @GET("/")
    suspend fun getMovieDetails(@Query("i") imdbID: String, @Query("apikey") apiKey: String): MovieDetailResponse
}