package com.example.randomusergenerator.data.network

import com.example.randomusergenerator.data.model.UsersResponse

class UsersRepo {
    suspend fun getUsers(gender: String = ""): UsersResponse {
        return RetrofitHelper.getInstance().create(UsersApiService::class.java).getUsers(gender = gender)
    }
}