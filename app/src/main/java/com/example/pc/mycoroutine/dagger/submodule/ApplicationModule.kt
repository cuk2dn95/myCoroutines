package com.example.pc.mycoroutine.dagger.submodule

import androidx.room.Room
import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.dagger.scope.AppScope
import com.example.pc.mycoroutine.data.source.local.database.LocalDataBase
import com.example.pc.mycoroutine.util.AppExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @AppScope
    @Provides
    fun providePostLocalDatabase(context: MainApplication): LocalDataBase {
        return Room.databaseBuilder(context, LocalDataBase::class.java, "LocalDatabase.db")
                .fallbackToDestructiveMigration().build()
    }

    @AppScope
    @Provides
    fun provideAppExecutor(): AppExecutor {
        return AppExecutor()
    }

}