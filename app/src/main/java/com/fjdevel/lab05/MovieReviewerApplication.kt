package com.fjdevel.lab05

import android.app.Application
import com.fjdevel.lab05.repositories.MovieRepository
import com.fjdevel.lab05.data.movies

class MovieReviewerApplication:Application() {
    val movieRepository:MovieRepository by lazy {
        MovieRepository(movies)
    }
}