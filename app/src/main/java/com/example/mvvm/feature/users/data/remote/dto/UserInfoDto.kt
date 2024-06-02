package com.example.mvvm.feature.users.data.remote.dto

import com.example.mvvm.feature.users.data.local.entity.UserInfoEntity


data class UserInfoDto(
//    val address: AddressDto,
//    val company: CompanyDto,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
){
    fun toUserInfoEntity(): UserInfoEntity {
        return UserInfoEntity(
//            address= address.toAddress(),
//            company = company.toCompany(),
            email = email,
            id =id,
            name=name,
            phone = phone,
            username = username,
            website = website
        )
    }
}