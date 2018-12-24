package com.example.pc.mycoroutine.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlin.coroutines.CoroutineContext

const val THREAD_COUNT = 3

class AppExecutor(val ioContext: CoroutineContext = Dispatchers.Default,
                  val networkContext: CoroutineContext = newFixedThreadPoolContext(THREAD_COUNT, "networkThreadPool"))