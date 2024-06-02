package com.example.mvvm.feature.users.data.remote

import com.example.mvvm.feature.users.data.remote.dto.UserInfoDto
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): List<UserInfoDto>


    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}