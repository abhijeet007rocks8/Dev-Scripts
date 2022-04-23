package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.adapter.TodoAdapter
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.viewModel.TodoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mTodoViewModel: TodoViewModel
    private var doubleBackToExitPressedOnce = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mTodoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        val recyclerView = mBinding.todoRecyclerView
        val todoAdapter = TodoAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = todoAdapter

        setTodosCount()

        mTodoViewModel.allTodos.observe(this) {
            todoAdapter.setAllTodosList(it)
            setTodosCount()
        }

        mBinding.addTaskFabButton.setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
        }

        mBinding.deleteAllTodos.setOnClickListener {
            deleteAllTodos()
        }
    }

    // deletes all todos
    private fun deleteAllTodos() {
        val builder = AlertDialog.Builder(this)
            .setTitle("Delete All")
            .setMessage("Do you want to delete all todos?")
            .setPositiveButton("Continue") { _, _ ->
                mTodoViewModel.deleteAllTodos()
            }
            .setNegativeButton("Cancel") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }

    // get number of todos and set it on home screen
    private fun setTodosCount() {
        val size = mTodoViewModel.allTodos.value?.size ?: 0
        if (size > 1) {
            val text = "$size Todos Today"
            mBinding.countTodoTextView.text = text
        } else if (size == 1) {
            val text = "1 Todo Today"
            mBinding.countTodoTextView.text = text
        } else {
            val text = "No Todos Today"
            mBinding.countTodoTextView.text = text
        }
    }

    // code for Double tap to exit
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}
