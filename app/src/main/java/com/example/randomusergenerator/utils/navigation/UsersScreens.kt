package com.example.randomusergenerator.utils.navigation

sealed class UsersScreens(val route: String) {
    object HomeScreen : UsersScreens("home_screen")
    object DetailScreen : UsersScreens("detail_screen")
}
