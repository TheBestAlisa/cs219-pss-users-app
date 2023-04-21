package com.example.randomusergenerator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.randomusergenerator.data.model.User
import com.example.randomusergenerator.utils.navigation.UsersScreens

@Composable
fun UsersList(navController: NavController, users: List<User>) {

    LazyColumn {
        itemsIndexed(users) { index, user ->
            UserCard(user = user) {
                navController.navigate(UsersScreens.DetailScreen.route + "/$index")
            }
        }
    }
}

@Composable
private fun UserCard(user: User, onClick: () -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick)
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = user.picture.large,
                contentDescription = "avatar",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )

            Column {
                Text(user.name.first)
                Text(user.name.last)
                Text(user.email)
            }
        }
    }
}