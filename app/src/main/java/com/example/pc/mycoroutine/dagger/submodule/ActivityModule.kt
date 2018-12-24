package com.example.pc.mycoroutine.dagger.submodule

import com.example.pc.mycoroutine.dagger.scope.ActivityScope
import com.example.pc.mycoroutine.feature.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}