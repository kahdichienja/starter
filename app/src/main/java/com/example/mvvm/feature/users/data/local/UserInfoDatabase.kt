package com.example.jetmap.featur_typicode_users.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvm.feature.users.data.local.Converters
import com.example.mvvm.feature.users.data.local.UserInfoDao
import com.example.mvvm.feature.users.data.local.entity.UserInfoEntity

@Database(
    entities = [UserInfoEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class UserInfoDatabase: RoomDatabase() {
    abstract val dao: UserInfoDao

}