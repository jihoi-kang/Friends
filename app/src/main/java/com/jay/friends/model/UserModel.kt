package com.jay.friends.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    val name: String,
    val profileUrl: String,
    val email: String,
    val phone: String,
    val cell: String,
    val age: Int,
    val gender: Gender,
    val flag: Flag,
    val location: Location,
) : Parcelable