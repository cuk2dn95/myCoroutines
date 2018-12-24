package com.example.pc.mycoroutine.dagger

import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.dagger.submodule.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, ApplicationModule::class,
    FragmentModule::class, RepositoryModule::class, RestfulModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): Builder

        fun build(): AppComponent
    }


}