package com.example.game_list.di

import com.example.game_list.data.datasources.profiles.dataSourceModule
import com.example.game_list.data.local.profiles.databaseModule
import com.example.game_list.data.repositories.profiles.repositoryModule
import com.example.game_list.data.services.di.retrofitModule
import com.example.game_list.domain.usecases.profiles.useCaseModule

val appModuleBusiness = listOf(
    retrofitModule,
    dataSourceModule,
    databaseModule,
    repositoryModule,
    useCaseModule
)