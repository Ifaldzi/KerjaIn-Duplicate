package com.example.kerjainprojectduplicate.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kerjainprojectduplicate.R

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val button = root.findViewById<Button>(R.id.add_task_button)
        button.setOnClickListener(View.OnClickListener {
            val intent = Intent("com.example.kerjainprojectduplicate.AddTaskActivity")
            startActivity(intent)
        })
        return root
    }
}