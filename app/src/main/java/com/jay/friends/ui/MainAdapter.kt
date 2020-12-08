package com.jay.friends.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.friends.R
import com.jay.friends.api.UserResponse
import com.jay.friends.databinding.ItemUserBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val userItems = mutableListOf<UserResponse>()

    fun setUserItems(userItems: List<UserResponse>) {
        this.userItems.clear()
        this.userItems.addAll(userItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = DataBindingUtil.inflate<ItemUserBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = userItems.size

}