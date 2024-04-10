package com.example.game_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_list.domain.models.Game
import com.example.game_list.domain.usecases.GetGamesUseCase
import kotlinx.coroutines.launch

class GameListViewModel(private val useCase: GetGamesUseCase) : ViewModel() {
    val games = MutableLiveData<List<Game>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    init {
        loadGames()
    }

    private fun loadGames(page: Int = 1, pageSize: Int = 20) {
        isLoading.value = true
        Log.d("GameListViewModel", "Loading games: page=$page, pageSize=$pageSize")
        viewModelScope.launch {
            try {
                useCase.execute(page, pageSize).collect { gamesList ->
                    Log.d("GameListViewModel", gamesList.toString())
                    games.postValue(gamesList)
                    isLoading.postValue(false)
                    Log.d("GameListViewModel", "Games loaded: ${gamesList.size}")
                }
            } catch (e: Exception) {
                Log.e("GameListViewModel", "Error loading games", e)
                errorMessage.postValue(e.message ?: "Unknown error")
                isLoading.postValue(false)
            }
        }
    }
}