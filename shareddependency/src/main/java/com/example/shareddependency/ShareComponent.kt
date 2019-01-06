package com.example.shareddependency

import dagger.Component
import javax.inject.Singleton

@Component(modules = [ShareModule::class])
@Singleton
interface ShareComponent {
    fun exposeData() : Data
}