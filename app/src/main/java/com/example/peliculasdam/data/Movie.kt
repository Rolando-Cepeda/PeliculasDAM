package com.example.peliculasdam.data

import com.google.gson.annotations.SerializedName


data class MovieSearchResponse(
    @SerializedName("Search") val Search: List<Movie>,
    //@SerializedName("totalResults") val totalResults: String,
    //@SerializedName("Response") val Response: String
)
data class Movie(
    @SerializedName("Title") val Title: String,
    @SerializedName("Year") val Year: String,
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val Poster: String,
    @SerializedName("Runtime") val Runtime: String?,
    @SerializedName("Genre") val Genre: String?,
    @SerializedName("Director") val Director: String?,
    @SerializedName("Country") val Country: String?,
    @SerializedName("Plot") val Plot: String?,
)