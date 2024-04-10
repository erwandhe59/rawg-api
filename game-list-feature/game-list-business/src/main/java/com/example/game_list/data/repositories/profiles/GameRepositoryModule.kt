package com.example.game_list.data.repositories.profiles

import com.example.game_list.data.repositories.implementations.GameRepositoryImpl
import org.koin.dsl.module
import com.example.game_list.domain.repositories.GameRepository
import org.koin.core.qualifier.named

val repositoryModule = module {
    single<GameRepository>(named("GameRepository")) {
        GameRepositoryImpl(get(named("RemoteDataSource")), get())
    }
}