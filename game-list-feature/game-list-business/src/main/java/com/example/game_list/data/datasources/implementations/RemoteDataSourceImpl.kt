package com.example.game_list.data.datasources.implementations

import android.util.Log
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.data.services.RawgService
import com.example.game_list.data.services.models.ApiResponse
import com.example.game_list.domain.models.Game


class RemoteDataSourceImpl(private val service: RawgService) : RemoteDataSource {
    override suspend fun getGames(page: Int, pageSize: Int): List<Game> {
        return try {
            val response = service.getGames(page, pageSize)
            Log.d("RemoteDataSourceImpl", "Emitting $response games")
            ApiResponse.ApiReponseMapper.map(response)
        } catch (e: Exception) {
            Log.e("RemoteDataSourceImpl", "Error fetching games: ${e.message}", e)
            emptyList()
        }
    }
}