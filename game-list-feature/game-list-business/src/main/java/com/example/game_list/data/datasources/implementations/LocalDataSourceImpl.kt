package com.example.game_list.data.datasources.implementations

import android.util.Log
import com.example.game_list.data.datasources.LocalDataSource
import com.example.game_list.data.local.GameDao
import com.example.game_list.data.local.models.GameEntity
import com.example.game_list.domain.models.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(private val gameDao: GameDao) : LocalDataSource {
    override suspend fun getAllGames(): List<Game> {

        Log.e("CYRIL", gameDao.toString())
        var reponse = gameDao.getAllGames()
        Log.e("LocalDataSourceImpl", reponse.toString())

        Log.e("RoomDB", "Fetching all games from DB")
        return GameEntity.GameEntityMapper.mapperEntitytoUI(reponse)
    }

    override suspend fun saveGames(games: List<Game>) {
        Log.e("RoomDB", "Saving games to DB: ${games.size}")
        gameDao.insertAll(GameEntity.GameEntityMapper.mapperUItoEntity(games))
        Log.e("RoomDB", "Games saved to DB")
    }

    override suspend fun deleteAllGames() {
        gameDao.deleteAll()
    }
}
