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

    private fun loadGames(page: Int = 1, pageSize: Int = 20) { // Ajout des valeurs par défaut
        isLoading.value = true
        viewModelScope.launch {
            try {
                useCase.execute(page, pageSize).collect { gamesList ->
                    games.postValue(gamesList)
                    Log.d("Games", gamesList.toString())
                    isLoading.postValue(false)
                }
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
                isLoading.postValue(false)
            }
        }
    }
}