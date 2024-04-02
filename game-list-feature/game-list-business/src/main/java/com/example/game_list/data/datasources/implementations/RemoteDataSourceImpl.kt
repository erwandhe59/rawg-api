package com.example.game_list.data.datasources.implementations

import android.util.Log
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.data.services.RawgService
import com.example.game_list.data.services.models.GameRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class RemoteDataSourceImpl(private val service: RawgService) : RemoteDataSource {

    override suspend fun getGames(page: Int, pageSize: Int): Flow<List<GameRemote>> = flow {
        try {
            val response = service.getGames(page, pageSize)
            emit(response.results)
        } catch (e: IOException) {
            Log.e(RemoteDataSourceImpl::class.simpleName, e.toString())
            emit(emptyList<GameRemote>())
        }
    }
}