package com.example.pc.mycoroutine.dagger

import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.dagger.scope.AppScope
import com.example.pc.mycoroutine.dagger.submodule.*
import com.example.shareddependency.ShareComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, ApplicationModule::class,
    FragmentModule::class, RepositoryModule::class, RestfulModule::class, AndroidSupportInjectionModule::class,
    ViewModelModule::class], dependencies = [ShareComponent::class])
@AppScope
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): Builder
        fun shareComponent(shareComponent: ShareComponent) : Builder
        fun build(): AppComponent
    }
}