package com.example.ktroomexam

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var todo : Todo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "todo-db" // todo-db는 db이름 임의로 지정
        ).allowMainThreadQueries() // 메인쓰레드에서도 하도록 함 실무에서는 백그라운드 쓰레드에서 하니 잘안쓴다고함
            .build()

        add_button.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            todo = Todo(todo_edit.text.toString()) // [title=exam] 이런형태로 나와서 이걸 없애기 위해 씀
            result_text.text = todo.title.toString()
            Log.e("tag", db.todoDao().getAll().toString())
        }

    }
}
