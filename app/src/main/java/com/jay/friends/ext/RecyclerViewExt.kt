package com.jay.friends.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jay.friends.model.UserModel
import com.jay.friends.ui.MainAdapter

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<Any>?) {
    val items = items ?: return

    when (val adapter = adapter) {
        is MainAdapter -> adapter.setUserItems(items as List<UserModel>)
    }
}

private const val DEFAULT_VISIBLE_THRESHOLD = 5

@BindingAdapter("load", "threshold", requireAll = false)
fun RecyclerView.bindLoad(
    load: () -> Unit,
    threshold: Int = DEFAULT_VISIBLE_THRESHOLD
) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            layoutManager?.let {
                val totalItemCount = it.itemCount
                val visibleItemCount = it.childCount
                val lastVisibleItem = (it as LinearLayoutManager).findLastVisibleItemPosition()

                if (visibleItemCount + lastVisibleItem + threshold >= totalItemCount) {
                    load.invoke()
                }
            }
        }
    })
}

@BindingAdapter("isRefreshing")
fun SwipeRefreshLayout.bindIsRefreshing(isRefreshing: Boolean) {
    this.isRefreshing = isRefreshing
}

@BindingAdapter("refresh")
fun SwipeRefreshLayout.bindRefresh(listener: SwipeRefreshLayout.OnRefreshListener) {
    setOnRefreshListener(listener)
}