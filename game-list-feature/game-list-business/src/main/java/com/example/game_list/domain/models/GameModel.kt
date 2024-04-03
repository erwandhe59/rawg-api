package com.example.game_list.domain.models

import com.google.gson.annotations.SerializedName

data class Game(
    val name: String,
    @SerializedName("background_image")
    val backgroundImage: String?, // Remplacez par une URL de l'image
)