package com.example.game_list.data.repositories.implementations

import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.domain.models.Game
import com.example.game_list.domain.repositories.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepositoryImpl(private val remoteDataSource: RemoteDataSource) : GameRepository {
    override suspend fun getGames(page: Int, pageSize: Int): Flow<List<Game>> {
        return remoteDataSource.getGames(page, pageSize).map { gameRemotes ->
            gameRemotes.map { gameRemote ->
                Game(
                    title = gameRemote.title,
                    description = gameRemote.description ?: "",
                    imageUrl = gameRemote.backgroundImage ?: ""
                )
            }
        }
    }
}