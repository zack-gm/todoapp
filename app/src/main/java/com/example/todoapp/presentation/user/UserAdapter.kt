package com.example.todoapp.presentation.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.user.User
import com.example.todoapp.R
import com.example.todoapp.presentation.onClick
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(
    val users: List<User>,
    val listner: (item: User) -> Unit = {}
): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val avatar: ImageView = view.user_avatar
        val name: TextView = view.user_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view).onClick {
            listner.invoke(users[it])
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = users[position]
        holder.name.text = item.name

//        Glide.with()
//            .load(item.avatar)
//            .into(holder.avatar)
    }
}