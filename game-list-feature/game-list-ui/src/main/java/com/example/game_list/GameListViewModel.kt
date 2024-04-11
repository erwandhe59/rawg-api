package com.example.game_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_list.domain.models.Game
import com.example.game_list.domain.usecases.GetGamesUseCase
import kotlinx.coroutines.flow.catch
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
        viewModelScope.launch {
            useCase.execute(page, pageSize).catch { e ->
                errorMessage.postValue(e.message ?: "Unknown error")
                isLoading.postValue(false)
            }.collect { gamesList ->
                games.postValue(gamesList)
                isLoading.postValue(false)
            }
        }
    }
}
