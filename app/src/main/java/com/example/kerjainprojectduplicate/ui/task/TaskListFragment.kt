package com.example.kerjainprojectduplicate.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.kerjainprojectduplicate.KerjainApplication
import com.example.kerjainprojectduplicate.R
import com.example.kerjainprojectduplicate.database.Task
import com.example.kerjainprojectduplicate.database.TaskRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.*
import kotlin.Comparator

class TaskListFragment : Fragment() {

    private val taskViewModel: TaskViewModel by viewModels{
        TaskViewModelFactory((activity?.application as KerjainApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_task_list, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.task_recycler_view)
        val taskAdapter = TaskAdapter()
        recyclerView.adapter = taskAdapter
        taskViewModel.tasks.observe(viewLifecycleOwner){tasks ->
            tasks.let { taskAdapter.submitList(it) }
        }
        return root
    }
}