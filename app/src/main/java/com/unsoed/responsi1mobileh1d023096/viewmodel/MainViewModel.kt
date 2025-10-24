package com.unsoed.responsi1mobileh1d023096.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.unsoed.responsi1mobileh1d023096.data.model.Player
import com.unsoed.responsi1mobileh1d023096.data.model.TeamResponse
import com.unsoed.responsi1mobileh1d023096.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _teamData = MutableLiveData<TeamResponse>()
    val teamData: LiveData<TeamResponse> = _teamData
    private val _squad = MutableLiveData<List<Player>>()
    val squad: LiveData<List<Player>> = _squad
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    init {
        fetchTeamDetails()
    }
    fun fetchTeamDetails() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamDetails()
                if (response.isSuccessful) {
                    val result = response.body()
                    _teamData.value = result
                    val squadList = result?.squad ?: emptyList()
                    val sortedSquad = squadList.sortedBy { player ->
                        getPositionOrder(player.position)
                    }
                    _squad.value = sortedSquad
                    isLoading.value = false
                    Log.d("SUCCESS_GET_DATA", "$result")
                } else {
                    isLoading.value = false
                    error.value = "${response.code()} ${response.message()}"
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                isLoading.value = false
                error.value = e.localizedMessage ?: "Unknown error"
                Log.e("API_EXCEPTION", e.localizedMessage ?: "unknown error")
            }
        }
    }
    private fun getPositionOrder(position: String?): Int {
        return when (position) {
            "Goalkeeper" -> 1
            "Defender", "Centre-Back", "Right-Back", "Left-Back" -> 2
            "Midfielder", "Defensive Midfield", "Central Midfield", "Attacking Midfield" -> 3
            "Forward", "Centre-Forward", "Second Striker", "Left Winger", "Right Winger" -> 4
            else -> 5
        }
    }
}

