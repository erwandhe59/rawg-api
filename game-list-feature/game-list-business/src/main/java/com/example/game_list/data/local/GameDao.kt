package com.example.game_list.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.game_list.data.local.models.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    // Récupérer tous les jeux
    @Query("SELECT * FROM GameEntity")
    fun getAllGames(): List<GameEntity>

    // Insérer un ensemble de jeux, en remplaçant les entrées existantes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(games: List<GameEntity>)

    // Supprimer tous les jeux
    @Query("DELETE FROM GameEntity")
    suspend fun deleteAll()
}
