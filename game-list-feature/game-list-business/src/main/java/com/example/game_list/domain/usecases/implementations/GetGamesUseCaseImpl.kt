package com.example.game_list.domain.usecases.implementations

import com.example.game_list.domain.models.Game
import com.example.game_list.domain.repositories.GameRepository
import com.example.game_list.domain.usecases.GetGamesUseCase
import kotlinx.coroutines.flow.Flow

class GetGamesUseCaseImpl(private val gameRepository: GameRepository) : GetGamesUseCase {
    override suspend fun execute(page: Int, pageSize: Int): Flow<List<Game>> {
        return gameRepository.getGames(page, pageSize)
    }
}