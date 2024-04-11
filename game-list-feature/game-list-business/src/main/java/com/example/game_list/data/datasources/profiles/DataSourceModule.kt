package com.example.game_list.data.datasources.profiles

import com.example.game_list.data.datasources.LocalDataSource
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.data.datasources.implementations.LocalDataSourceImpl
import com.example.game_list.data.datasources.implementations.RemoteDataSourceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource>(named("RemoteDataSource")) { RemoteDataSourceImpl(get(named("RawgService"))) }
    single<LocalDataSource>(named("LocalDataSource")) { LocalDataSourceImpl(get(named("GameDao"))) }
}