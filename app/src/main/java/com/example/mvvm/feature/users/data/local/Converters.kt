package com.example.mvvm.feature.users.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.mvvm.feature.users.data.util.JsonParser
import com.example.mvvm.feature.users.domain.model.UserInfo
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromUserInfoJson(json: String): List<UserInfo>{
        return jsonParser.fromJson<ArrayList<UserInfo>>(
            json,
            object : TypeToken<ArrayList<UserInfo>>(){}.type
        )?: emptyList()
    }
    @TypeConverter
    fun toUserInfoJson(userInfo: List<UserInfo>): String{
        return jsonParser.toJson(
            userInfo,
            object : TypeToken<ArrayList<UserInfo>>(){}.type
        )?: "[]"
    }
}