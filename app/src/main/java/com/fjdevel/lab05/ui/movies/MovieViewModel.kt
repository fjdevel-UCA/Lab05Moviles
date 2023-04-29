package com.fjdevel.lab05.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.fjdevel.lab05.MovieReviewerApplication
import com.fjdevel.lab05.data.model.MovieModel
import com.fjdevel.lab05.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository):ViewModel(){

    fun getMovies() = repository.getMovies()
    fun addMovies(movie:MovieModel) = repository.addMovies(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app= this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}