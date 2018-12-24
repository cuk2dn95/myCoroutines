package com.example.pc.mycoroutine.data.source.local

import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.data.model.Post
import com.example.pc.mycoroutine.data.source.local.database.PostDao
import com.example.pc.mycoroutine.util.AppExecutor
import kotlinx.coroutines.withContext

class LocalPostRepository (private val postDao: PostDao,
                          private val appExecutor: AppExecutor) : PostRepository {

    override suspend fun getAllPost(): List<Post> = withContext(appExecutor.ioContext) {
        postDao.getAllPost()
    }

    override suspend fun deletePosts() = withContext(appExecutor.ioContext) {
        postDao.deletePost()
    }

    override suspend fun getPostById(id: Int): Post? = withContext(appExecutor.ioContext) {
        postDao.getPostById(id)
    }

    override suspend fun savePosts(list: List<Post>) = withContext(appExecutor.ioContext) {
        postDao.insertPost(*list.toTypedArray())
    }
}