package com.example.game_list.di

import com.example.game_list.GameListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GameListViewModel(get(named("GetGamesUseCase"))) }
}