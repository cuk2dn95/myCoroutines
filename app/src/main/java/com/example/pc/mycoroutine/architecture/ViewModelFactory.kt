package com.example.pc.mycoroutine.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.feature.post.MainPostViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val postRepository: PostRepository,
                                           private val context: MainApplication) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        with(modelClass) {
            return when {
                isAssignableFrom(MainPostViewModel::class.java) -> {
                    MainPostViewModel(repository = postRepository, context = context) as T
                }
                else -> {
                    throw IllegalArgumentException("The class not support in View Model factory")
                }
            }
        }
    }
}