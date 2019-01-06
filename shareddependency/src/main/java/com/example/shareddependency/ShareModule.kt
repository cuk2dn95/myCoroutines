package com.example.shareddependency

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ShareModule {

    @Provides
    @Singleton
    fun provideData() : Data = Data("data")
}