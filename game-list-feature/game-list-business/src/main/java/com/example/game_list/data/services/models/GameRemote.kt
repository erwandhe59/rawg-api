package com.example.game_list.data.services.models


import com.example.game_list.domain.models.Game
import com.google.gson.annotations.SerializedName


data class GameRemote(
    val id: Int,
    val name: String,
    @SerializedName("background_image")
    val backgroundImage: String?,
)