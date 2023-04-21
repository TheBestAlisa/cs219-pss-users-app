package com.example.randomusergenerator.data.network

import com.example.randomusergenerator.data.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApiService {

    @GET("api/?inc=name,picture,email,nat")
    suspend fun getUsers(
        @Query("results") results: Int = 10,
        @Query("page") page: Int = 0,
        @Query("gender") gender: String = ""
    ): UsersResponse
}