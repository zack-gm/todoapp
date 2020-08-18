package com.example.todoapp.presentation.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.todoapp.R
import com.example.todoapp.presentation.PageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_pager.view.*

/**
 * A fragment representing a list of Items.
 */
class PagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PageAdapter(this)
        view.page_todo.adapter = adapter

        TabLayoutMediator(view.tab_todo as TabLayout, view.page_todo as ViewPager2){ tab, position ->
            tab.text = adapter.getName(position)
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = PagerFragment()
    }
}