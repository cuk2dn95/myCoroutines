package com.example.pc.mycoroutine.architecture

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.pc.mycoroutine.MainApplication
import kotlinx.coroutines.*

open class BaseViewModel(application: MainApplication) : AndroidViewModel(application) {

    private val parentJob = Job()
    private val parentScope = CoroutineScope(parentJob + Dispatchers.Main)


    fun launch(block: suspend CoroutineScope.() -> Unit) {
        parentScope.launch {
            block()
        }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}