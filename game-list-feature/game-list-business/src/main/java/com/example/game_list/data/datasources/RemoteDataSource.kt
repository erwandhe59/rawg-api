package com.example.game_list.data.datasources

import com.example.game_list.data.services.models.GameRemote
import com.example.game_list.domain.models.Game
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getGames(page: Int, pageSize: Int): Flow<List<Game>>
}