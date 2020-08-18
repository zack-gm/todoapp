package com.example.todoapp.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todoapp.presentation.fragment.TaskFragment
import com.example.todoapp.presentation.fragment.UserFragment

class PageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TaskFragment.newInstance()
            else -> UserFragment.newInstance()
        }
    }

    fun getName(position: Int): String{
        return when(position){
            0 -> "Task"
            else -> "User"
        }
    }
}