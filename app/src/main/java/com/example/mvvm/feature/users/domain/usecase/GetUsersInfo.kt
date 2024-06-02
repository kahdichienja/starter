package com.example.mvvm.feature.users.domain.usecase


import com.example.mvvm.core.util.Resource
import com.example.mvvm.feature.users.domain.model.UserInfo
import com.example.mvvm.feature.users.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow

class GetUsersInfo(private val repository: UserInfoRepository) {
    operator fun invoke(): Flow<Resource<List<UserInfo>>> = repository.getUsersInfo()

}