package com.example.todo.adapter

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.ModifyTodoActivity
import com.example.todo.R
import com.example.todo.data.ToDo

class TodoAdapter() : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    var allTodos = emptyList<ToDo>()

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val todoTitleTextView: TextView = itemView.findViewById(R.id.tvTitle)
        val todoIsCompleted: ImageView = itemView.findViewById(R.id.cbIsTodoCompleted)
        val currentTodoView: ConstraintLayout = itemView.findViewById(R.id.wholeTodoItem)
        val colorIndicator: View = itemView.findViewById(R.id.viewColorTagIndicator)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = allTodos[position]
        holder.todoTitleTextView.text = todo.title

        setColorTextAndCheckMark(holder, todo)

        holder.currentTodoView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ModifyTodoActivity::class.java)
            intent.putExtra("currentTask", todo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return allTodos.size
    }


    private fun setColorTextAndCheckMark(holder: TodoViewHolder, todo: ToDo) {
        val textView = holder.todoTitleTextView
        if (todo.isCompleted) {
            textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            textView.alpha = 0.75F
            holder.todoIsCompleted.setImageResource(R.drawable.checked)
        } else {
            textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            textView.alpha = 1F
            holder.todoIsCompleted.setImageResource(R.drawable.not_checked)
        }

        val unwrappedDrawable = holder.colorIndicator.background
        if (unwrappedDrawable != null) {
            val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable)
            val color = if (todo.isCompleted) {
                Color.parseColor("#21B06B")
            } else {
                Color.parseColor("#EBA10F")
            }
            DrawableCompat.setTint(wrappedDrawable, color)
        }
    }

    fun setAllTodosList(tasks: List<ToDo>) {
        allTodos = tasks
        notifyDataSetChanged()
    }
}