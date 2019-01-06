package com.example.pc.mycoroutine.dagger.submodule

import com.example.feature1.BlankFragment
import com.example.pc.mycoroutine.feature.post.MainPostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainPost(): MainPostFragment

    @ContributesAndroidInjector()
    abstract fun  contributeBlankFragment() : BlankFragment
}