package com.jay.friends.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jay.friends.api.UserResponse
import com.jay.friends.model.UserModel
import com.jay.friends.ui.MainAdapter

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<Any>?) {
    val items = items ?: return

    when(val adapter = adapter) {
        is MainAdapter -> adapter.setUserItems(items as List<UserModel>)
    }
}

@BindingAdapter("isRefreshing")
fun SwipeRefreshLayout.bindIsRefreshing(isRefreshing: Boolean) {
    this.isRefreshing = isRefreshing
}

@BindingAdapter("refresh")
fun SwipeRefreshLayout.bindRefresh(listener: SwipeRefreshLayout.OnRefreshListener) {
    setOnRefreshListener(listener)
}