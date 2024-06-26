package com.example.game_list.data.repositories.profiles

import com.example.game_list.data.repositories.implementations.GameRepositoryImpl
import org.koin.dsl.module
import com.example.game_list.domain.repositories.GameRepository
import org.koin.core.qualifier.named

val gameRepositoryModule = module {
    single<GameRepository> {
        GameRepositoryImpl(remoteDataSource = get())
    }
}