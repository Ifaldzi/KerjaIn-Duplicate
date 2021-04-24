package com.example.kerjainprojectduplicate.ui.task

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kerjainprojectduplicate.R
import com.example.kerjainprojectduplicate.TaskDetailActivity
import com.example.kerjainprojectduplicate.database.Task

class TaskAdapter() :
    ListAdapter<Task, TaskAdapter.ViewHolder>(TaskDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val topicTextView: TextView = view.findViewById(R.id.task_topic)
        val deadlineTextView: TextView = view.findViewById(R.id.deadline)
        val doneButton: Button = view.findViewById(R.id.done_btn)

        fun bind(task: Task){
            topicTextView.text = task.topic
            deadlineTextView.text = task.deadlineToString()
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<Task>(){
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, TaskDetailActivity::class.java)
            intent.putExtra("topic", getItem(position).topic)
            intent.putExtra("deadline", getItem(position).deadlineToString())
            intent.putExtra("description", getItem(position).description)
            it.context.startActivity(intent)
        }
    }
}