package com.jay.friends.di

import com.jay.friends.api.RandomUserService
import com.jay.friends.data.RandomUserRemoteDataSource
import com.jay.friends.data.RandomUserRemoteDataSourceImpl
import com.jay.friends.data.RandomUserRepository
import com.jay.friends.data.RandomUserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Reusable
    @ExperimentalCoroutinesApi
    fun provideRandomUserRepository(
        randomUserRemoteDataSource: RandomUserRemoteDataSource
    ): RandomUserRepository =
        RandomUserRepositoryImpl(randomUserRemoteDataSource)

    @Provides
    @Reusable
    @ExperimentalCoroutinesApi
    fun provideRandomUserDataSource(
        service: RandomUserService
    ): RandomUserRemoteDataSource =
        RandomUserRemoteDataSourceImpl(service)

}