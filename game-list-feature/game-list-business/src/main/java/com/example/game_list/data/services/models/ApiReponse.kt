package com.example.game_list.data.services.models

import com.example.game_list.domain.models.Game

data class ApiResponse(
    val results: List<GameRemote>,
) {
    object ApiReponseMapper {
        fun map(from: ApiResponse): List<Game> {
            return from.results.map {
                Game(
                    id = it.id,
                    name = it.name,
                    backgroundImage = it.backgroundImage
                )
            }
        }
    }
}