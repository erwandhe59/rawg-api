package com.example.game_list.data.datasources

import com.example.game_list.data.services.models.GameRemote
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getGames(page: Int, pageSize: Int): Flow<List<GameRemote>>
}