package com.example.game_list.data.datasources

import com.example.game_list.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getAllGames(): List<Game>?
    suspend fun saveGames(games: List<Game>)
    suspend fun deleteAllGames()
}
