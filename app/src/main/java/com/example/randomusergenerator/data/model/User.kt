package com.example.randomusergenerator.data.model

data class User(
    val name: Name,
    val email: String,
    val picture: Picture,
    val nat: String
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)

data class UsersResponse(
    val results: List<User>,
    val info: Info
)
