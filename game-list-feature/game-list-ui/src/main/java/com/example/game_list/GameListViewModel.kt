package com.example.game_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.game_list.R
import com.example.game_list.domain.models.Game

class GameListViewModel : ViewModel() {
    private val games = MutableLiveData<List<Game>>()

    init {
        loadGames()
    }

    private fun loadGames() {
        games.value = listOf(
            Game("Pokemon", "Description", 2002, R.drawable.pikachu),
            Game("Zelda", "Description", 2004, R.drawable.zelda),
            Game("Street Fighter", "Description", 2005, R.drawable.street_fighter)
        )
    }

    fun getGames(): MutableLiveData<List<Game>> {
        return games
    }
}