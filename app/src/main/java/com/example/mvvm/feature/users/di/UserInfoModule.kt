package com.example.mvvm.feature.users.di

import android.app.Application
import androidx.room.Room
import com.example.jetmap.featur_typicode_users.data.local.UserInfoDatabase
import com.example.mvvm.feature.users.data.remote.UserApi
import com.example.mvvm.feature.users.data.repository.UserInfoRepositoryImplementation
import com.example.mvvm.feature.users.domain.repository.UserInfoRepository
import com.example.mvvm.feature.users.domain.usecase.GetUsersInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UserInfoModule {
    @Provides
    @Singleton
    fun provideGetUsersInfoUseCase(repository: UserInfoRepository): GetUsersInfo {
        return GetUsersInfo(repository = repository)
    }

    @Provides
    @Singleton
    fun provideUserInfoRepository(db: UserInfoDatabase, api: UserApi): UserInfoRepository{
        return UserInfoRepositoryImplementation(api = api, dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideUserInfoDatabase(app: Application): UserInfoDatabase {
        return Room.databaseBuilder(
            app, UserInfoDatabase::class.java, "users"
        )
//            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideUserInfoApi(): UserApi{
        return Retrofit.Builder()
            .baseUrl(UserApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
}






