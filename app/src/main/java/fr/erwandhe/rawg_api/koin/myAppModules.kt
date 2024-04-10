package fr.erwandhe.rawg_api.koin

import androidx.room.Room
import com.example.game_list.GameListViewModel
import com.example.game_list.data.datasources.LocalDataSource
import com.example.game_list.data.datasources.RemoteDataSource
import com.example.game_list.data.datasources.implementations.LocalDataSourceImpl
import com.example.game_list.data.datasources.implementations.RemoteDataSourceImpl
import com.example.game_list.data.local.AppDatabase
import com.example.game_list.data.repositories.implementations.GameRepositoryImpl
import com.example.game_list.data.services.networkModule
import com.example.game_list.domain.repositories.GameRepository
import com.example.game_list.domain.usecases.GetGamesUseCase
import com.example.game_list.domain.usecases.implementations.GetGamesUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<GameRepository>(named("GameRepository")) {
        GameRepositoryImpl(get(named("LocalDataSource")), get(named("RemoteDataSource")))
    }
}

val useCaseModule = module {
    single<GetGamesUseCase>(named("GetGamesUseCase")) {
        GetGamesUseCaseImpl(get(named("GameRepository")))
    }
}

val viewModelModule = module {
    viewModel { GameListViewModel(get(named("GetGamesUseCase"))) }
}

val dataSourceModule = module {
    single<RemoteDataSource>(named("RemoteDataSource")) { RemoteDataSourceImpl(get(named("RawgService"))) }
    single<LocalDataSource>(named("LocalDataSource")) { LocalDataSourceImpl(get(named("GameDao"))) }
}

val databaseModule = module {
    single(named("RoomDatabase")) {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "game_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    single(named("GameDao")) { get<AppDatabase>(named("RoomDatabase")).gameDao() }
}

val appModule = listOf(networkModule, repositoryModule, useCaseModule, viewModelModule, dataSourceModule, databaseModule)