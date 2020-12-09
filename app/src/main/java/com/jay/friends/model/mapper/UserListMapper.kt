package com.jay.friends.model.mapper

import com.jay.friends.api.UserResponse
import com.jay.friends.model.Flag
import com.jay.friends.model.Gender
import com.jay.friends.model.Location
import com.jay.friends.model.UserModel

fun List<UserResponse>.asUiModel(): List<UserModel> {
    return this.map {
        UserModel(
            name = "${it.name.first} ${it.name.last}",
            profileUrl = it.picture.large,
            email = it.email,
            phone = it.phone,
            cell = it.cell,
            age = it.dob.age,
            gender = Gender(it.gender),
            flag = Flag(it.nat),
            location = Location(
                it.location.coordinates.latitude,
                it.location.coordinates.longitude
            ),
        )
    }
}