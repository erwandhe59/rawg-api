package com.example.game_list.data.repositories.implementations

import android.util.Log
import com.example.game_list.data.datasources.LocalDataSource
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.domain.models.Game
import com.example.game_list.domain.repositories.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class GameRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : GameRepository {

    override suspend fun getGames(page: Int, pageSize: Int): Flow<List<Game>> = flow {
        try {

            val localGame = localDataSource.getAllGames()
            localGame?.let {
                emit(localGame)
            }

            val remoteGame = remoteDataSource.getGames(page, pageSize)

            if (remoteGame!=localGame) {
                localDataSource.saveGames(remoteGame)
                emit(remoteGame)}
        } catch (e: Exception) {
            Log.e("GameRepositoryImpl", "Failed to fetch from remote, attempting local data", e)
            emit(emptyList())
        }
    }.catch { e ->
        Log.e("GameRepositoryImpl", "Error in getting games: $e", e)
        emit(emptyList())
    }
}

//RemoteDataSource