package com.example.pc.mycoroutine.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pc.mycoroutine.data.model.Post

@Database(version = 1, entities = [Post::class], exportSchema = false)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun postDao(): PostDao
}