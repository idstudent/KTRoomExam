package com.example.ktroomexam

import android.arch.persistence.room.*

@Dao // 설명안해줌
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll() : List<Todo>

    @Insert
    fun insert(todo : Todo)

    @Update
    fun update(todo : Todo)

    @Delete
    fun delete(todo : Todo)
}