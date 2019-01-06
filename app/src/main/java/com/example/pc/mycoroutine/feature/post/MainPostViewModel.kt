package com.example.pc.mycoroutine.feature.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.architecture.BaseViewModel
import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.data.model.Post
import com.example.shareddependency.Data
import javax.inject.Inject

class MainPostViewModel @Inject constructor(private val repository: PostRepository,
                                            context: MainApplication) : BaseViewModel(context) {

    @Inject
    lateinit var data : Data

    val adapter = PostAdapter()
    lateinit var layoutManager: LinearLayoutManager

    val allPost: LiveData<List<Post>>
        get() = _allPost

    // to avoid external set value of live data
    private val _allPost: MutableLiveData<List<Post>> = MutableLiveData()

    fun getAllPost() = launch {
        val posts = repository.getAllPost()
        _allPost.value = posts
        adapter.setData(posts)
    }

    fun deleteAllPost() = launch {
        repository.deletePosts()
    }

    fun getPostId(id: Int) = launch {
        repository.getPostById(id)
    }

}