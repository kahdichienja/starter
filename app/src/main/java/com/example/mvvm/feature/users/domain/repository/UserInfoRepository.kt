package com.example.mvvm.feature.users.domain.repository

import com.example.mvvm.core.util.Resource
import com.example.mvvm.feature.users.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {
    fun getUsersInfo(): Flow<Resource<List<UserInfo>>>
}