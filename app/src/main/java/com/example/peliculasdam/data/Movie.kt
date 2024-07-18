package com.example.peliculasdam.data

import com.google.gson.annotations.SerializedName


data class MovieSearchResponse(
    @SerializedName("Search") val Search: List<Movie>,
    @SerializedName("totalResults") val totalResults: String,
    @SerializedName("Response") val Response: String
)
data class Movie(
    @SerializedName("Title") val Title: String,
    @SerializedName("Year") val Year: String,
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Poster") val Poster: String
)

data class MovieDetailResponse(
    @SerializedName("Title") val Title: String,
    @SerializedName("Year") val Year: String,
    @SerializedName("Poster") val Poster: String,
    @SerializedName("Runtime") val Runtime: String,
    @SerializedName("Genre") val Genre: String,
    @SerializedName("Director") val Director: String,
    @SerializedName("Year") val Country: String,

    /*@SerializedName("Year") val Rated: String,
    @SerializedName("Year") val Released: String,
    @SerializedName("Year") val Writer: String,
    @SerializedName("Year") val Actors: String,
    @SerializedName("Year") val Plot: String,
    @SerializedName("Year") val Language: String,
    @SerializedName("Year") val Awards: String,
    @SerializedName("Year") val Ratings: List<Rating>,
    @SerializedName("Year") val Metascore: String,
    @SerializedName("Year") val imdbRating: String,
    @SerializedName("Year") val imdbVotes: String,
    @SerializedName("Year") val imdbID: String,
    @SerializedName("Year") val Type: String,
    @SerializedName("Year") val DVD: String,
    @SerializedName("Year") val BoxOffice: String,
    @SerializedName("Year") val Production: String,
    @SerializedName("Year") val Website: String,
    @SerializedName("Year") val Response: String */
)

data class Rating(
    @SerializedName("Year") val Source: String,
    @SerializedName("Year") val Value: String
)