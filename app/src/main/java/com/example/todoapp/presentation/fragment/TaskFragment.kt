package com.example.todoapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.di.DaggerFragComponent
import com.example.todoapp.presentation.ViewModelFactory
import com.example.todoapp.presentation.task.TaskAdapter
import com.example.todoapp.presentation.user.TaskViewModel
import com.example.todoapp.presentation.user.UserViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_task.*
import kotlinx.android.synthetic.main.fragment_task.view.*
import javax.inject.Inject

class TaskFragment: Fragment() {

    val adapter = TaskAdapter()

    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var taskViewModel: TaskViewModel
    @Inject lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerFragComponent.builder().application(activity?.application!!).build().inject(this)
        taskViewModel = ViewModelProvider(this, viewModelFactory).get(taskViewModel::class.java)
        userViewModel = ViewModelProvider(this, viewModelFactory).get(userViewModel::class.java)

        view.task_recycle.adapter = adapter

        view.task_recycle.layoutManager = LinearLayoutManager(context)
        taskViewModel.tasks.observe(viewLifecycleOwner, Observer { result ->
            if(result.isProcess)
                task_progress.visibility = View.VISIBLE

            result.fold(
                {
                    adapter.setTask(it)
                    task_progress.visibility = View.GONE
                },
                {
                    task_progress.visibility = View.GONE
                    onFailure(it)
                })
        })
        userViewModel.users.observe(viewLifecycleOwner, Observer { result ->
            result.fold(
                {
                    task_progress.visibility = View.GONE
                    adapter.setUser(it)
                },
                {
                    task_progress.visibility = View.GONE
                    onFailure(it)
                })
        })
    }

    private fun onFailure(e: Throwable){
        Snackbar.make(task_layout, e.message.toString(), Snackbar.LENGTH_LONG).show()
    }

    companion object{
        fun newInstance() = TaskFragment()
    }

}