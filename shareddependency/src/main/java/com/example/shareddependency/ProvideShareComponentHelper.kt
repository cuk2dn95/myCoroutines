package com.example.shareddependency

import android.content.Context
import java.lang.IllegalArgumentException

object ProvideShareComponentHelper {
    fun provideShareComponent(application : Context) : ShareComponent {
        (application as? ProvideShareComponent)?.let {
            return it.provideShareComponent()
        } ?: run {
            throw IllegalArgumentException("Application need to implement provideShareComponent interface")
        }
    }
}