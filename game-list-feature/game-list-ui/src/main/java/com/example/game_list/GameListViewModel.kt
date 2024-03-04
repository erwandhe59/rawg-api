package com.example.game_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_list.data.services.RawgService
import com.example.game_list.domain.models.Game
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class GameListViewModel : ViewModel() {
    private val games = MutableLiveData<List<Game>>()

    init {
        loadGames()
    }

    private fun loadGames() = viewModelScope.launch {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RawgService::class.java)

        try {
            val response = service.getGames()
            games.postValue(response.results.map {
                // Utilisez directement l'URL de l'image fournie par l'API pour chaque jeu
                Game(it.title, it.description ?: "No description", it.imageUrl ?: "")
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getGames(): MutableLiveData<List<Game>> {
        return games
    }
}

