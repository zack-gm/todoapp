package com.example.todoapp.presentation.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.domain.task.Task
import com.example.domain.user.User
import com.example.todoapp.R
import com.example.todoapp.presentation.onClick
import kotlinx.android.synthetic.main.task_item.view.*
import kotlinx.android.synthetic.main.user_item.view.user_avatar
import kotlinx.android.synthetic.main.user_item.view.user_name

class TaskAdapter(
    var tasks: List<Task>? = null,
    var users: List<User>? = null,
    val listner: (item: Task) -> Unit = {}
): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val id: TextView = view.task_id
        val title: TextView = view.task_title
        val status: TextView = view.task_status

        val avatar: ImageView = view.user_avatar
        val name: TextView = view.user_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view).onClick {
            tasks?.get(it)?.let { task -> listner.invoke(task) }
        }
    }

    fun setTask(tasks: List<Task>?){
        this.tasks = tasks
        notifyDataSetChanged()
    }

    fun setUser(users: List<User>?){
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return tasks?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tasks?.get(position)?.let{ task ->
            holder.id.text = task.id.toString()
            holder.title.text = task.title
            holder.status.text = if(task.status)
                holder.itemView.context.getString(R.string.task_completed)
            else holder.itemView.context.getString(R.string.task_performed)

            task.user_id.let { id ->
                users?.get(id)?.let {user ->
                    holder.name.text = user.name
                }
            }
        }

//        Glide.with()
//            .load(item.avatar)
//            .into(holder.avatar)
    }
}