package com.jay.friends.model

data class Gender(
    val gender: String,
    val emoji: String = getEmoji(gender)
)

private fun getEmoji(gender: String): String =
    when (gender) {
        "male" -> "\uD83D\uDE4B\u200D♂️"
        "female" -> "\uD83D\uDE4B\u200D♀️"
        else -> ""
    }
