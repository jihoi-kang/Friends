package com.jay.friends.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jay.friends.api.UserResponse
import com.jay.friends.ui.MainAdapter

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<Any>?) {
    val items = items ?: return

    when(val adapter = adapter) {
        is MainAdapter -> adapter.setUserItems(items as List<UserResponse>)
    }
}