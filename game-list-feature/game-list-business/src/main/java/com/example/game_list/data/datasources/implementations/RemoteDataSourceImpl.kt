package com.example.game_list.data.datasources.implementations

import android.util.Log
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.data.services.RawgService
import com.example.game_list.data.services.mappers.GameRemoteMapper
import com.example.game_list.data.services.models.ApiResponse
import com.example.game_list.data.services.models.GameRemote
import com.example.game_list.domain.models.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(private val service: RawgService) : RemoteDataSource {
    override suspend fun getGames(page: Int, pageSize: Int): Flow<List<Game>> = flow {
        try {
            val response = service.getGames(page, pageSize)
            Log.d("RemoteDataSourceImpl", "Emitting $response games")
            emit(ApiResponse.ApiReponseMapper.map(response))
        } catch (e: Exception) {
            Log.e("RemoteDataSourceImpl", "Error fetching games", e)
            emit(emptyList<Game>())
        }
    }
}