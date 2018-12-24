package com.example.pc.mycoroutine.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pc.mycoroutine.data.model.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(vararg post: Post)

    @Query("SELECT * FROM Post")
    fun getAllPost(): List<Post>

    @Query("SELECT * FROM Post WHERE id = :postId")
    fun getPostById(postId: Int): Post?

    @Query("DELETE FROM Post")
    fun deletePost()
}