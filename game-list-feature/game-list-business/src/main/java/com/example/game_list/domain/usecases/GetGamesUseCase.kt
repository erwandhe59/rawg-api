package com.example.game_list.domain.usecases

import com.example.game_list.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface GetGamesUseCase {
    fun execute(page: Int, pageSize: Int): Flow<List<Game>>
}