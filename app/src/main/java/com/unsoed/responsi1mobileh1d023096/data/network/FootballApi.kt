package com.unsoed.responsi1mobileh1d023096.data.network

import com.unsoed.responsi1mobileh1d023096.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET

interface FootballApi {
    @GET("teams/78")
    suspend fun getTeamDetails(): Response<TeamResponse>
}