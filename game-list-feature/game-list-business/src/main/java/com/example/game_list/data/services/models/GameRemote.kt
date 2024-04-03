package com.example.game_list.data.services.models


import com.google.gson.annotations.SerializedName


data class GameRemote(
    val name: String,
    @SerializedName("background_image")
    val backgroundImage: String?,
)
//objet que je vais recevoir depuis le serveur (JSON)