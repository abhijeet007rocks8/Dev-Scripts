package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.todo.data.ToDo
import com.example.todo.databinding.ActivityModifyTodoBinding
import com.example.todo.viewModel.TodoViewModel

class ModifyTodoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityModifyTodoBinding
    private lateinit var mTodoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityModifyTodoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mTodoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        // to update a task, get the task first and assign it initially
        val currentTodo = intent.getParcelableExtra<ToDo>("currentTask")
        if (currentTodo != null) {
            mBinding.taskNameEditText.setText(currentTodo.title)
            mBinding.completedRadioButton.isChecked = currentTodo.isCompleted
            mBinding.notCompletedRadioButton.isChecked = !currentTodo.isCompleted
        }

        // if one is clicked, turn it on and off the other
        mBinding.completedRadioButton.setOnClickListener {
            mBinding.completedRadioButton.isChecked = true
            mBinding.notCompletedRadioButton.isChecked = false
        }
        mBinding.notCompletedRadioButton.setOnClickListener {
            mBinding.completedRadioButton.isChecked = false
            mBinding.notCompletedRadioButton.isChecked = true
        }

        mBinding.deleteTask.setOnClickListener {
            deleteTodoFromDb(currentTodo)
        }

        mBinding.backToMain.setOnClickListener {
            navigateToMainActivity()
        }

        mBinding.updateTaskButton.setOnClickListener {
            updateTodoTitle(currentTodo)
        }
    }

    // update a single task
    private fun updateTodoTitle(currentTodo: ToDo?) {
        if (currentTodo == null) return
        val currentTodoTitle = mBinding.taskNameEditText.text.toString().trim()
        val isTodoCompleted = mBinding.completedRadioButton.isChecked

        if (currentTodoTitle.isNotEmpty()) {
            val modifiedTask =
                ToDo(currentTodo.id, currentTodoTitle, isTodoCompleted)
            mTodoViewModel.updateTodo(modifiedTask)
            Toast.makeText(this, "Todo Updated Successfully!", Toast.LENGTH_SHORT).show()
            navigateToMainActivity()
        } else {
            Toast.makeText(this, "Please enter todo title!", Toast.LENGTH_SHORT).show()
        }
    }

    // delete a single task
    private fun deleteTodoFromDb(currentTodo: ToDo?) {
        if (currentTodo != null) {
            mTodoViewModel.deleteTodo(currentTodo)
            Toast.makeText(this, "Todo Deleted Successfully!", Toast.LENGTH_SHORT).show()
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