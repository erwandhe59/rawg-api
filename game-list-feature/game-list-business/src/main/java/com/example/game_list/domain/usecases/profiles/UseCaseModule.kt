package com.example.game_list.domain.usecases.profiles

import com.example.game_list.domain.usecases.GetGamesUseCase
import com.example.game_list.domain.usecases.implementations.GetGamesUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetGamesUseCase>(named("GetGamesUseCase")) {
        GetGamesUseCaseImpl(get(named("GameRepository")))
    }
}