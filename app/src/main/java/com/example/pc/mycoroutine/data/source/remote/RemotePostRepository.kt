package com.example.pc.mycoroutine.data.source.remote

import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.data.model.Post
import com.example.pc.mycoroutine.data.source.remote.service.PostService
import com.example.pc.mycoroutine.util.AppExecutor
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemotePostRepository @Inject constructor(private val service: PostService,
                                               private val appExecutor: AppExecutor) : PostRepository {
    override suspend fun getAllPost(): List<Post> = withContext(appExecutor.networkContext) {
        service.getAllPost().await()
    }

    override suspend fun deletePosts() {
        // no required
    }

    override suspend fun getPostById(id: Int): Post? = withContext(appExecutor.networkContext) {
        service.getPostById(id).await()
    }

    override suspend fun savePosts(list: List<Post>) {
        // no required
    }
}