package com.example.pc.mycoroutine.dagger.submodule

import com.example.pc.mycoroutine.dagger.scope.FragmentScope
import com.example.pc.mycoroutine.feature.post.MainPostFragment
import com.example.pc.mycoroutine.feature.post.MainPostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainPostModule::class])
    abstract fun contributeMainPost(): MainPostFragment
}