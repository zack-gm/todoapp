package com.example.todoapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.di.DaggerFragComponent
import com.example.todoapp.presentation.ViewModelFactory
import com.example.todoapp.presentation.user.UserAdapter
import com.example.todoapp.presentation.user.UserViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.view.*
import kotlinx.android.synthetic.main.fragment_user.view.user_progress
import javax.inject.Inject


class UserFragment: Fragment(){

//    val userViewModel: UserViewModel by activityViewModels()
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        userViewModel.list()

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerFragComponent.builder().application(activity?.application!!).build().inject(this)
        userViewModel = ViewModelProvider(this, viewModelFactory).get(userViewModel::class.java)
        userViewModel.list()

        view.user_recycle.layoutManager = LinearLayoutManager(context)
        userViewModel.users.observe(viewLifecycleOwner, Observer { result ->
            if(result.isProcess)
                user_progress.visibility = View.VISIBLE

            result.fold(
                {
                    user_progress.visibility = View.GONE
                    view.user_recycle.adapter = it?.let { list ->
                        UserAdapter(list) { user ->
                            findNavController().navigate(R.id.userDatailFragment,
                                bundleOf(UserDatailFragment.USER_ID to user.id)
                            )
                        }
                    }
                },
                {
                    user_progress.visibility = View.GONE
                    onFailure(it)
                })
        })
    }

    fun onFailure(e: Throwable){
        Snackbar.make(user_layout, e.message.toString(), Snackbar.LENGTH_LONG).show()
    }

    companion object{
        fun newInstance() = UserFragment()
    }
}