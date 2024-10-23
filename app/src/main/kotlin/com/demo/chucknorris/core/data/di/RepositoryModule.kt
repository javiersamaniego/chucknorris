package com.demo.chucknorris.core.data.di

import com.demo.chucknorris.core.data.repositories.JokesRepositoryImpl
import com.demo.chucknorris.core.domain.repositories.JokesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
interface RepositoryModule {

    @Binds
    fun bindJokesRepositoryImpl(jokesRepositoryImpl: JokesRepositoryImpl): JokesRepository
}