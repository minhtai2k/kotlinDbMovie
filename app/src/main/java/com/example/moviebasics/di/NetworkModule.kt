package com.example.moviebasics.di

import android.content.Context
import com.example.data.utils.Constants.BASE_URL
import com.example.data.utils.Constants.CACHE_SIZE_BYTES
import com.example.data.utils.Constants.CONNECTION_TIMEOUT
import com.example.data.utils.Constants.READ_TIMEOUT
import com.example.data.utils.Constants.WRITE_TIMEOUT
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())
        okHttpBuilder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        return okHttpBuilder.build()
    }

    @Provides
    internal fun provideCache(context: Context): Cache {
        val httpCacheDirectory = File(context.cacheDir.absolutePath, "HttpCache")
        return Cache(httpCacheDirectory, CACHE_SIZE_BYTES)
    }

//    @Provides
//    fun provideContext(application: GenreApplication): Context {
//        return application.applicationContext
//    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Named("auth_retrofit")
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
//            .addCallAdapterFactory()
            .client(okHttpClient)
            .build()
    }

//    fun retrofit(moshi: Moshi): Retrofit {
//        return Retrofit.Builder()
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .baseUrl(BASE_URL)
//            .build()
//    }

}