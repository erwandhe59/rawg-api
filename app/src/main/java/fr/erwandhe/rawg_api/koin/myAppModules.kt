package  fr.erwandhe.rawg_api.koin

import com.example.game_list.GameListViewModel
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.data.datasources.implementations.RemoteDataSourceImpl
import com.example.game_list.data.repositories.implementations.GameRepositoryImpl
import com.example.game_list.data.services.networkModule
import com.example.game_list.domain.repositories.GameRepository
import com.example.game_list.domain.usecases.GetGamesUseCase
import com.example.game_list.domain.usecases.implementations.GetGamesUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<GameRepository> { GameRepositoryImpl(get()) }
}

val useCaseModule = module {
    single<GetGamesUseCase> { GetGamesUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { GameListViewModel(get()) }
}

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
}

val appModule = listOf(networkModule, repositoryModule, useCaseModule, viewModelModule, dataSourceModule)
