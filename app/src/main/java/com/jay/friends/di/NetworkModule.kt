package com.jay.friends.di

import com.jay.friends.Const
import com.jay.friends.api.RandomUserService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Reusable
    fun provideRandomUserService(
        retrofit: Retrofit
    ): RandomUserService = retrofit.create(RandomUserService::class.java)

}