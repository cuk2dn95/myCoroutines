package com.example.pc.mycoroutine.dagger.submodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pc.mycoroutine.architecture.ViewModelFactory
import com.example.pc.mycoroutine.dagger.key.ViewModelKey
import com.example.pc.mycoroutine.dagger.scope.AppScope
import com.example.pc.mycoroutine.feature.post.MainPostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainPostViewModel::class)
    abstract fun providePostViewModel(viewModel: MainPostViewModel): ViewModel


    @AppScope
    @Binds
    abstract fun provideViewModelFactory(factory : ViewModelFactory): ViewModelProvider.Factory
}