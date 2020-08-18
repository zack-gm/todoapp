package com.example.todoapp.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.presentation.user.UserViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.address_entry.*
import kotlinx.android.synthetic.main.company_entry.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_task.*

class UserDatailFragment: Fragment() {

    val userViewModel: UserViewModel by activityViewModels()
    var userID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userID = arguments?.getInt(USER_ID) ?: 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.users .observe(viewLifecycleOwner, Observer { result ->
            result.fold(
                {
                    it?.find { item -> item.id == userID }?.let { user ->
                        user_name.text = user.name
                        user_username.text = user.username
                        user_email.text = user.email
                        user_address_street.text = user.address.street
                        user_address_city.text = user.address.city
                        user_address_suite.text = user.address.suite
                        user_address_zipcode.text = user.address.zipcode
                        user_address_geo.text = "${user.address.geo.lat} | ${user.address.geo.lng}"
                        user_phone.text = user.phone
                        user_website.text = user.website
                        user_company_name.text = user.company.name
                        user_company_catchPhrase.text = user.company.catchPhrase
                        user_company_bs.text = user.company.bs
                    }
                },
                {
                    task_progress.visibility = View.GONE
                    onFailure(it)
                })

        })
    }

    fun onFailure(e: Throwable){
        Snackbar.make(task_layout, e.message.toString(), Snackbar.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        val USER_ID = "USER_ID"

        fun newInstance(id: String) = UserDatailFragment().apply {
            arguments = bundleOf(USER_ID to id)
        }
    }
}