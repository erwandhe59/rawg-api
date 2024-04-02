package com.example.game_list.data.services

import com.example.game_list.data.services.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgService {
    @GET("games")
    suspend fun getGames(
        @Query("page") page: Int = 1, // Valeur par défaut pour la page
        @Query("page_size") pageSize: Int = 20 // Valeur par défaut pour la taille de la page
    ): ApiResponse
}