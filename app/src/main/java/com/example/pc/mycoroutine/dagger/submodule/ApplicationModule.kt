package com.example.pc.mycoroutine.dagger.submodule

import androidx.room.Room
import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.architecture.ViewModelFactory
import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.data.source.local.database.LocalDataBase
import com.example.pc.mycoroutine.data.source.remote.service.RemoteConfig
import com.example.pc.mycoroutine.util.AppExecutor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun providePostLocalDatabase(context: MainApplication): LocalDataBase {
        return Room.databaseBuilder(context, LocalDataBase::class.java, "LocalDatabase.db")
                .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideAppExecutor(): AppExecutor {
        return AppExecutor()
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(postRepository: PostRepository, context: MainApplication): ViewModelFactory {
        return ViewModelFactory(postRepository, context)
    }
}