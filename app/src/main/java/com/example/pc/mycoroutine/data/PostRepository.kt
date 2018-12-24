package com.example.pc.mycoroutine.data

import com.example.pc.mycoroutine.data.model.Post

interface PostRepository {

    suspend fun getAllPost(): List<Post>

    suspend fun deletePosts()

    suspend fun getPostById(id: Int): Post?

    suspend fun savePosts(list: List<Post>)
}