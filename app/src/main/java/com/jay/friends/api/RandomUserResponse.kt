package com.jay.friends.api


import com.google.gson.annotations.SerializedName

data class RandomUserResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<UserResponse>
) {
    data class Info(
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: Int,
        @SerializedName("seed")
        val seed: String,
        @SerializedName("version")
        val version: String
    )

}