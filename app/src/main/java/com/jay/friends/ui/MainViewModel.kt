package com.jay.friends.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.jay.friends.base.BaseViewModel
import com.jay.friends.data.RandomUserRepository
import com.jay.friends.model.UserModel
import com.jay.friends.model.mapper.asUiModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(
    private val randomUserRepository: RandomUserRepository
) : BaseViewModel() {

    private var lastRequestedPage = STARTING_PAGE_INDEX

    private val _userItems = MutableLiveData<List<UserModel>>()
    val userItems: LiveData<List<UserModel>> get() = _userItems

    val isRefreshing: LiveData<Boolean> = userItems.map { false }

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _userItems.value =
                randomUserRepository.fetchRandomUser(lastRequestedPage++).asUiModel()
        }
    }

    fun refresh() {
        fetchUsers()
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}