package com.jay.friends.ext

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun View.bindVisible(condition: Boolean) {
    isVisible = condition
}