package com.example.game_list.data.services

import com.example.game_list.data.services.models.ApiResponse
import com.example.game_list.domain.models.Game
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgService {
    @GET("games")
    suspend fun getGames(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 20
    ): ApiResponse
    }
