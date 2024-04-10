package com.example.game_list.data.local.profiles

import androidx.room.Room
import com.example.game_list.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val databaseModule = module {
    single(named("RoomDatabase")) {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "game_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>(named("RoomDatabase")).gameDao() }
}