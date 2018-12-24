package com.example.pc.mycoroutine.feature.post

import androidx.lifecycle.ViewModelProviders
import com.example.pc.mycoroutine.architecture.ViewModelFactory
import com.example.pc.mycoroutine.dagger.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class MainPostModule {

    @FragmentScope
    @Provides
    fun providePostViewModel(context: MainPostFragment, factory: ViewModelFactory): MainPostViewModel {
        return ViewModelProviders.of(context, factory).get(MainPostViewModel::class.java)
    }

}