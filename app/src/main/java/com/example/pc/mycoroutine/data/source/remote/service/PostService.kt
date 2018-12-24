package com.example.pc.mycoroutine.data.source.remote.service

import com.example.pc.mycoroutine.data.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface PostService {
    @GET("/posts")
    fun getAllPost(): Deferred<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(id: Int): Deferred<Post?>
}
