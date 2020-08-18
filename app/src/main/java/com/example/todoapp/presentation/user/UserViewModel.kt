package com.example.todoapp.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.user.User
import com.example.todoapp.data.repository.remote.user.UserDataSourceRemote
import com.example.todoapp.data.repository.room.user.UserDataSourceRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import com.example.todoapp.domain.Result


class UserViewModel @Inject constructor(
    var remote: UserDataSourceRemote,
    var room: UserDataSourceRoom
): ViewModel() {

    var users = MutableLiveData<Result<List<User>?>>()
    var user = MutableLiveData<Result<User?>>()

    init {
        list()
    }

    fun get(id: String) {
        viewModelScope.launch {
            user.value = Result.progress()
            user.value = withContext(Dispatchers.IO) {
                try {
                    var result: User? = null
                    try {
                        result = remote.get(id)
                    } catch (e: Exception) { }

                    if (result == null)
                        result = room.get(id)

                    Result.success(result)
                } catch (e: Exception) {
                    Result.failure<User>(e)
                }
            }
        }
    }

    fun list() {
        viewModelScope.launch {
            user.value = Result.progress()
            users.value = withContext(Dispatchers.IO){
                try{
                    var result: List<User>? = null
                    try {
                        result = remote.list()
                    }
                    catch (e: Exception){}
                    if(result != null)
                        room.addAll(result)
                    else
                        result = room.list()
                    Result.success(result)
                } catch (e: Exception) {
                    Result.failure<List<User>>(e)
                }
            }
        }
    }
}