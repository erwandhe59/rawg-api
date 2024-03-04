package com.example.game_list.data.services.models

import com.example.game_list.domain.models.Game


data class GameResponse(
    val results: List<Game>
)
