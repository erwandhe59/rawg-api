package com.example.game_list

data class Game(
    val title: String,
    val description: String,
    val releaseYear: Int,
    val imageResId: Int // Utilisez un identifiant de ressource d'image
)
