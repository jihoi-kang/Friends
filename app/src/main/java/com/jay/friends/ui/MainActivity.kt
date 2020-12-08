package com.jay.friends.ui

import android.os.Bundle
import com.jay.friends.R
import com.jay.friends.base.BaseActivity
import com.jay.friends.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}