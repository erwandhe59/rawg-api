package com.example.game_list.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.game_list.domain.models.Game

@Entity
data class GameEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "background_image") val backgroundImage: String?
) {
    object GameEntityMapper {
        fun mapperEntitytoUI(from: List<GameEntity>): List<Game> {
                    return from.map {
                        Game (
                        id = it.id,
                        name = it.name,
                        backgroundImage = it.backgroundImage
                        )
                    }
        }


    fun mapperUItoEntity(from: List<Game>): List<GameEntity> {
        return from.map {
            GameEntity (
                id = it.id,
                name = it.name,
                backgroundImage = it.backgroundImage
            )
        }
    }
    }
}

//récupérer l'id des jeux