package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.todo.data.ToDo
import com.example.todo.databinding.ActivityAddTodoBinding
import com.example.todo.viewModel.TodoViewModel

class AddTodoActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityAddTodoBinding
    private lateinit var mTaskViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mTaskViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        mBinding.addTaskButton.setOnClickListener {
            createAndAddTodo()
        }

        mBinding.backToMain.setOnClickListener {
            navigateToMainActivity()
        }
    }

    // get task title and create new one
    private fun createAndAddTodo() {
        val title = mBinding.todoNameEditText.text.toString().trim()

        if (title.isNotEmpty()) {
            mTaskViewModel.addTodo(ToDo(title = title, isCompleted = false))
            Toast.makeText(this, "Todo Added Successfully", Toast.LENGTH_SHORT).show()
        }

        navigateToMainActivity()
    }

    // to navigate back to home screen - MainActivity
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}