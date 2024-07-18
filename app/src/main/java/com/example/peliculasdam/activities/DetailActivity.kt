package com.example.peliculasdam.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.peliculasdam.data.MovieApiService
import com.example.peliculasdam.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imdbID = intent.getStringExtra("imdbID")
        getMovieDetails(imdbID!!)
    }

    private fun getMovieDetails(imdbID: String) {
        val apiService = getRetrofit().create(MovieApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getMovieDetails(imdbID, "68056634")
                withContext(Dispatchers.Main) {
                    binding.detailTitleTextView.text = response.Title
                    binding.detailYearTextView.text = response.Year
                    binding.detailSynopsisTextView.text = response.Plot
                    binding.detailDurationTextView.text = response.Runtime
                    binding.detailDirectorTextView.text = response.Director
                    binding.detailGenreTextView.text = response.Genre
                    binding.detailCountryTextView.text = response.Country
                    Picasso.get().load(response.Poster).into(binding.detailPosterImageView)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}