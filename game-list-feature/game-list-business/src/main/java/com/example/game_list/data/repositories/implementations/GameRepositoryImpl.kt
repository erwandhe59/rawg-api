package com.example.game_list.data.repositories.implementations

import android.util.Log
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.domain.models.Game
import com.example.game_list.domain.repositories.GameRepository
import kotlinx.coroutines.flow.Flow

class GameRepositoryImpl(private val remoteDataSource: RemoteDataSource) : GameRepository {

    override suspend fun getGames(page: Int, pageSize: Int): Flow<List<Game>> {

        Log.d("GameRepositoryImpl", "Converting GameRemote to Game")
        return remoteDataSource.getGames(page, pageSize)
    }
}