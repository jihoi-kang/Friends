package com.jay.friends.data

import com.jay.friends.api.RandomUserService
import com.jay.friends.api.UserResponse

class RandomUserRemoteDataSourceImpl(
    private val randomUserService: RandomUserService
) : RandomUserRemoteDataSource {

    override suspend fun fetchRandomUser(page: Int): List<UserResponse> =
        randomUserService.fetchFriends(page, DEFAULT_RESULT_COUNT).results

    companion object {
        private const val DEFAULT_RESULT_COUNT = 20
    }

}