package com.example.pc.mycoroutine.data.source

import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.data.model.Post
import com.example.pc.mycoroutine.data.source.local.LocalPostRepository
import com.example.pc.mycoroutine.data.source.remote.RemotePostRepository
import javax.inject.Inject

class PostSource @Inject constructor(private val remote: RemotePostRepository, private val local: LocalPostRepository) : PostRepository {

    private val cachedPosts: MutableMap<Int, Post> = mutableMapOf()

    override suspend fun getAllPost(): List<Post> {
        return when {
            cachedPosts.values.isNotEmpty() -> {
                cachedPosts.values.toMutableList()
            }
            local.getAllPost().isNotEmpty() -> {
                val result = local.getAllPost()
                cacheListPost(result)
                result
            }
            else -> {
                val result = remote.getAllPost()
                local.savePosts(result)
                cacheListPost(result)
                result
            }
        }
    }

    private fun cacheListPost(posts: List<Post>) {
        cachedPosts.clear()
        posts.forEach { cachedPosts[it.id] = it }
    }

    private fun cachePost(post: Post) {
        cachedPosts[post.id] = post
    }

    override suspend fun deletePosts() {
        cachedPosts.clear()
        local.deletePosts()
    }

    override suspend fun getPostById(id: Int): Post? {
        return when {
            cachedPosts.keys.contains(id) -> cachedPosts[id]!!
            local.getPostById(id) != null -> {
                val result = local.getPostById(id)
                cachePost(result!!)
                result
            }
            else -> {
                val result = remote.getPostById(id)
                if (result != null) {
                    local.savePosts(arrayListOf(result))
                    result
                } else {
                    null
                }
            }
        }
    }

    override suspend fun savePosts(list: List<Post>) {
        local.savePosts(list)
        cachedPosts.putAll(list.map { it.id to it }.toMap())
    }
}