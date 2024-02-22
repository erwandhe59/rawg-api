package com.example.game_list.domain.repositories

import com.example.game_list.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getGames(page: Int, pageSize: Int): Flow<List<Game>>
}