package com.unsoed.responsi1mobileh1d023096.data.model

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val teamName: String,
    @SerializedName("crest")
    val crest: String,
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("squad")
    val squad: List<Player>


)
