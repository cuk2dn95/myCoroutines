package com.example.pc.mycoroutine.dagger.submodule

import com.example.pc.mycoroutine.data.source.remote.service.PostService
import com.example.pc.mycoroutine.data.source.remote.service.RemoteConfig
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
class RestfulModule {
    @Singleton
    @Provides
    @Named("logger")
    fun provideHttpLogger(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofitClient(@Named("logger") logger: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(logger)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(RemoteConfig.BASE_URL)
                .build()
    }

    @Singleton
    @Provides
    fun providePostService(client: Retrofit): PostService {
        return client.create(PostService::class.java)
    }
}