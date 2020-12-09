package com.jay.friends.ui

import androidx.recyclerview.widget.RecyclerView
import com.jay.friends.databinding.ItemUserBinding
import com.jay.friends.model.UserModel

class MainViewHolder(
    private val binding: ItemUserBinding,
    private val viewModel: MainViewModel
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userModel: UserModel) {
        binding.item = userModel
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

}