package com.example.mvvm.feature.users.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvm.feature.users.domain.model.UserInfo

@Entity
data class UserInfoEntity(
    val email: String,
    @PrimaryKey val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
){
    fun toUserInfo(): UserInfo {
        return UserInfo(
            id = id,
            name = name,
            email = email,
            username = username,
            website = website,
            phone = phone,
        )
    }
}
