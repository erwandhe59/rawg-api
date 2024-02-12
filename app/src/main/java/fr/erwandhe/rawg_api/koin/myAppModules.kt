package fr.erwandhe.rawg_api.koin

import com.example.game_list.GameListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GameListViewModel() }
}
