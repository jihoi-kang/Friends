package com.jay.friends.api

import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {

    @GET("/api/")
    suspend fun fetchFriends(
        @Query("page") page: Int,
        @Query("results") results: Int,
    ): RandomUserResponse

}