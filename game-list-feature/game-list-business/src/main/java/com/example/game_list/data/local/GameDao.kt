package com.example.game_list.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.game_list.data.local.models.GameEntity

@Dao
interface GameDao {
    @Query("SELECT * FROM GameEntity")
    suspend fun getAllGames(): List<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(games: List<GameEntity>)

    @Query("DELETE FROM GameEntity")
    suspend fun deleteAll()
}
