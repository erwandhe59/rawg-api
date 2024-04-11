package com.example.game_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.game_list.data.local.models.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}
