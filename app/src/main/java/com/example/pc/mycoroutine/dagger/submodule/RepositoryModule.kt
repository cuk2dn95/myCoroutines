package com.example.pc.mycoroutine.dagger.submodule

import com.example.pc.mycoroutine.dagger.scope.AppScope
import com.example.pc.mycoroutine.data.PostRepository
import com.example.pc.mycoroutine.data.source.PostSource
import com.example.pc.mycoroutine.data.source.local.LocalPostRepository
import com.example.pc.mycoroutine.data.source.local.database.LocalDataBase
import com.example.pc.mycoroutine.data.source.remote.RemotePostRepository
import com.example.pc.mycoroutine.data.source.remote.service.PostService
import com.example.pc.mycoroutine.util.AppExecutor
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepositoryModule.PostSourceModule::class])
abstract class RepositoryModule {

    @AppScope
    @Binds
    abstract fun providePostRepository(postRepository: PostSource): PostRepository

    @Module
    class PostSourceModule {
        @AppScope
        @Provides
        fun provideLocalPostRepository(database: LocalDataBase, appExecutor: AppExecutor): LocalPostRepository {
            return LocalPostRepository(database.postDao(), appExecutor)
        }

        @AppScope
        @Provides
        fun provideRemotePostRepository(postService: PostService, appExecutor: AppExecutor): RemotePostRepository {
            return RemotePostRepository(postService, appExecutor)
        }

    }
}