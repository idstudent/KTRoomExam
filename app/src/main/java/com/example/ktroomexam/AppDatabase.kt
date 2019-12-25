package com.example.ktroomexam

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Todo::class], version = 1) // entities = [] 괄호안에 여러개 클래스넣을수있다함
abstract class AppDatabase : RoomDatabase(){
    abstract fun todoDao() : TodoDao
}