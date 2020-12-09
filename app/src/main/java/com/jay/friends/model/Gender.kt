package com.jay.friends.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gender(
    val gender: String,
    val emoji: String = getEmoji(gender)
) : Parcelable

private fun getEmoji(gender: String): String =
    when (gender) {
        "male" -> "\uD83D\uDE4B\u200D♂️"
        "female" -> "\uD83D\uDE4B\u200D♀️"
        else -> ""
    }
