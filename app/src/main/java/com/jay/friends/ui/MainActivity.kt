package com.jay.friends.ui

import android.os.Bundle
import com.jay.friends.R
import com.jay.friends.base.BaseActivity
import com.jay.friends.databinding.ActivityMainBinding
import com.jay.friends.ui.detail.UserDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private val mainAdapter by lazy {
        MainAdapter(viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        binding.rvUserList.adapter = mainAdapter
    }

    private fun setupObserve() {
        viewModel.showUserDetail.observe(this) {
            startActivity(UserDetailActivity.getIntent(this, it))
        }
    }

}