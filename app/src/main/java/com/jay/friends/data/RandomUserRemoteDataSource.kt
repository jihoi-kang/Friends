package com.jay.friends.data

import com.jay.friends.api.UserResponse

interface RandomUserRemoteDataSource {

    suspend fun fetchRandomUser(page: Int) : List<UserResponse>

}