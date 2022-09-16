package com.example.moviebasics.repository

import android.os.Message
import com.example.moviebasics.model.Genre
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.security.MessageDigestSpi

class GenreDataSource(
    private val messageApi: MessageApi,
    private val refreshIntervalMs : Long = 5000
) {
    val latestMessages: Flow<List<Genre>> = flow {
        while (true) {
            val latestMessage = messageApi.fetchLatestNews()
            this.emit(latestMessage)
            delay(refreshIntervalMs)
        }
    }
}

interface MessageApi {
    suspend fun fetchLatestNews(): List<Genre>
}