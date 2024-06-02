package com.example.mvvm.feature.users.data.remote.dto

import com.example.mvvm.feature.users.domain.model.Geo


data class GeoDto(
    val lat: String,
    val lng: String
){
    fun toGeo(): Geo {
        return Geo(
            lat = lat,
            lng= lng
        )
    }
}