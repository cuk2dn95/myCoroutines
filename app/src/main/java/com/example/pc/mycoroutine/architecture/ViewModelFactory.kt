package com.example.pc.mycoroutine.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val creators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
                ?: creators.entries.firstOrNull { it.key.isAssignableFrom(modelClass) }?.value
                ?: throw IllegalArgumentException("The class not support in View Model factory")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw  e
        }
    }
}