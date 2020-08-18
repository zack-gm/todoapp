package com.example.todoapp.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.task.Task
import com.example.todoapp.data.repository.remote.task.TaskDataSourceRemote
import com.example.todoapp.data.repository.room.task.TaskDataSourceRoom
import com.example.todoapp.domain.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class TaskViewModel @Inject constructor(
    var remote: TaskDataSourceRemote,
    var room: TaskDataSourceRoom
): ViewModel() {

    var tasks = MutableLiveData<Result<List<Task>?>>()

    init {
        list()
    }

    fun list() {
        viewModelScope.launch {
            tasks.value = Result.progress()
            tasks.value = withContext(Dispatchers.IO) {
                try {
                    var result: List<Task>? = null
                    try {
                        result = remote.list()
                    } catch (e: Exception) {
                    }
                    if (result != null)
                        room.addAll(result)
                    else
                        result = room.list()
                    Result.success(result)
                } catch (e: Exception) {
                    Result.failure<List<Task>>(e)
                }
            }
        }
    }
}