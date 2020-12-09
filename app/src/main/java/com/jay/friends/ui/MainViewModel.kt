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

    private var lastRequestedPage = START_PAGE_INDEX

    private val _userItems = MutableLiveData<MutableList<UserModel>>()
    val userItems: LiveData<MutableList<UserModel>> get() = _userItems

    val isRefreshing: LiveData<Boolean> = userItems.map { false }

    private var isRequestInProgress = false

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        if (isRequestInProgress) return

        viewModelScope.launch {
            isRequestInProgress = true
            showLoading()
            val result =
                randomUserRepository.fetchRandomUser(lastRequestedPage).asUiModel()
            hideLoading()

            val newItems = if (lastRequestedPage == START_PAGE_INDEX) {
                result.toMutableList()
            } else {
                _userItems.value?.apply { addAll(result) }
            }

            _userItems.value = newItems
            isRequestInProgress = false
            lastRequestedPage++
        }
    }

    fun refresh() {
        lastRequestedPage = START_PAGE_INDEX
        fetchUsers()
    }

    fun loadMore() {
        fetchUsers()
    }

    companion object {
        private const val START_PAGE_INDEX = 1
    }

}