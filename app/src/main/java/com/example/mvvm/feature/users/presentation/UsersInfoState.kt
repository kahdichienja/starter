package com.example.mvvm.feature.users.presentation

import com.example.mvvm.feature.users.domain.model.UserInfo

data class UsersInfoState(val usersInfo: List<UserInfo> = emptyList(), val isLoading: Boolean = false)