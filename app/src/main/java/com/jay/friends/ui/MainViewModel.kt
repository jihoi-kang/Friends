package com.jay.friends.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.friends.api.UserResponse
import com.jay.friends.base.BaseViewModel

class MainViewModel() : BaseViewModel() {

    private val _userItems = MutableLiveData<List<UserResponse>>()
    val userItems: LiveData<List<UserResponse>> get() = _userItems

}