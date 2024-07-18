package com.example.peliculasdam.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peliculasdam.adapter.MovieAdapter
import com.example.peliculasdam.data.Movie
import com.example.peliculasdam.data.MovieApiService
import com.example.peliculasdam.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieList: List<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            searchMovies(query)
        }
    }

    private fun searchMovies(query: String) {
        val apiService = getRetrofit().create(MovieApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.searchMovies(query, "68056634")
                withContext(Dispatchers.Main) {
                    movieList = response.Search
                    movieAdapter = MovieAdapter(movieList) { position ->
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("imdbID", movieList[position].imdbID)
                        startActivity(intent)
                    }
                    binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.recyclerView.adapter = movieAdapter
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