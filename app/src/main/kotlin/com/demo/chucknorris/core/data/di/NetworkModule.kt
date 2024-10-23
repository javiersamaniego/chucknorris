package com.demo.chucknorris.core.data.di

import com.demo.chucknorris.core.data.network.JokesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */


/**
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()
        return Retrofit.Builder().baseUrl("https://api.chucknorris.io")
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideJokesApi(retrofit: Retrofit): JokesAPI = retrofit.create(JokesAPI::class.java)
}