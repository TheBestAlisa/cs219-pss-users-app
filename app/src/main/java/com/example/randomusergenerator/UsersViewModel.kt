package com.example.randomusergenerator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusergenerator.data.model.UsersResponse
import com.example.randomusergenerator.data.network.UsersRepo
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {
    private val _users: MutableLiveData<UsersResponse> = MutableLiveData()
    val users: LiveData<UsersResponse> = _users

    fun loadUsers() {
        viewModelScope.launch {
            try {
                val response = UsersRepo().getUsers()
                _users.postValue(response)
            } catch (e: Exception) {
                Log.d(">>>", e.message.toString())
            }
        }
    }

    fun loadUserWithGender(gender: String) {
        viewModelScope.launch {
            try {
                val response = UsersRepo().getUsers(gender = gender.lowercase())
                _users.postValue(response)
            } catch (e: Exception) {
                Log.d(">>>", e.message.toString())
            }
        }
    }
}