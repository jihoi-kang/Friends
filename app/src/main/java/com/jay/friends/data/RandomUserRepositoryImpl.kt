package com.jay.friends.data

import com.jay.friends.api.UserResponse

class RandomUserRepositoryImpl(
    private val randomUserRemoteDataSource: RandomUserRemoteDataSource
) : RandomUserRepository {

    override suspend fun fetchRandomUser(page: Int): List<UserResponse> =
        randomUserRemoteDataSource.fetchRandomUser(page)

}