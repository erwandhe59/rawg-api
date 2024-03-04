package com.example.game_list.data.services

import com.example.game_list.data.services.models.GameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgService {
    @GET("games")
    suspend fun getGames(@Query("page") page: Int = 1): GameResponse
}
