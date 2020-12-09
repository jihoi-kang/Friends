package com.jay.friends.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.friends.R
import com.jay.friends.databinding.ItemUserBinding
import com.jay.friends.model.UserModel

class MainAdapter(
    private val viewModel: MainViewModel
) : RecyclerView.Adapter<MainViewHolder>() {

    private val userItems = mutableListOf<UserModel>()

    fun setUserItems(userItems: List<UserModel>) {
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
        return MainViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(userItems[position])
    }

    override fun getItemCount(): Int = userItems.size

}