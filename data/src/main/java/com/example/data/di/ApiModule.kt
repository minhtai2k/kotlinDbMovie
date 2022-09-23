package com.example.data.di

import com.example.data.apiservice.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [NetworkModule::class])
class ApiModule {
    @Provides
    fun bindApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}