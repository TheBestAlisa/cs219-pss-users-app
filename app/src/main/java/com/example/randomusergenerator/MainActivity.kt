package com.example.randomusergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.randomusergenerator.utils.navigation.UsersScreens
import com.example.randomusergenerator.ui.screens.UserDetailsScreen
import com.example.randomusergenerator.ui.screens.UsersScreen

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<UsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadUsers()
        viewModel.users.observe(this) { users ->
            setContent {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = UsersScreens.HomeScreen.route
                ) {

                    // Home Screen
                    composable(route = UsersScreens.HomeScreen.route) {
                        UsersScreen(
                            navController = navController,
                            users = users.results,
                            onRefresh = viewModel::loadUsers,
                            //onSearch = viewModel::search, // for search | not implemented
                            onSelectFilter = {
                                viewModel.loadUserWithGender(it)
                            }
                        )
                    }

                    // Details Screen
                    composable(
                        route = UsersScreens.DetailScreen.route + "/{index}",
                        arguments = listOf(navArgument(name = "index") {
                            type = NavType.IntType
                        })
                    ) { entry ->
                        val index = entry.arguments?.getInt("index")

                        index?.let {
                            users.results[it]
                        }?.let {
                            UserDetailsScreen(navController, it)
                        }

                    }
                }
            }
        }
    }
}


