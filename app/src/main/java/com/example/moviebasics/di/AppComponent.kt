package com.example.moviebasics.di

import retrofit2.Retrofit
import javax.inject.Inject

class AppComponent @Inject constructor(private val retrofit: Retrofit) {
}