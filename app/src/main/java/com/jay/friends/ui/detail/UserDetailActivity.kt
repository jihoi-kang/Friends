package com.jay.friends.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jay.friends.R
import com.jay.friends.base.BaseActivity
import com.jay.friends.databinding.ActivityUserDetailBinding
import com.jay.friends.model.UserModel


class UserDetailActivity : BaseActivity<UserDetailViewModel, ActivityUserDetailBinding>(
    R.layout.activity_user_detail,
    UserDetailViewModel::class.java
), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.item = intent.getParcelableExtra(EXTRA_USER_MODEL)

        (supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)
            ?.getMapAsync(this@UserDetailActivity)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return
        val item = binding.item ?: return

        val location = LatLng(item.location.lat, item.location.lng)
        googleMap.addMarker(MarkerOptions().position(location).title("Location"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }

    companion object {

        private const val EXTRA_USER_MODEL = "android.intent.extra.EXTRA_USER_MODEL"

        fun getIntent(
            context: Context,
            userModel: UserModel,
        ) = Intent(context, UserDetailActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(EXTRA_USER_MODEL, userModel)
        }

    }

}