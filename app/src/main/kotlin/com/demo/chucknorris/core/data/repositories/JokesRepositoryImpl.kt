package com.demo.chucknorris.core.data.repositories

import com.demo.chucknorris.core.data.mappers.toDomain
import com.demo.chucknorris.core.data.network.JokesAPI
import com.demo.chucknorris.core.domain.model.Joke
import com.demo.chucknorris.core.domain.model.JokeCategory
import com.demo.chucknorris.core.domain.repositories.JokesRepository
import javax.inject.Inject

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
class JokesRepositoryImpl @Inject constructor(
    private val jokesAPI: JokesAPI
) : JokesRepository {

    override suspend fun getJokeCategories(): List<JokeCategory> {
        val response = jokesAPI.getJokesCategories().execute()
        if (response.isSuccessful) {
            response.body()?.let {
                return it.map { category -> JokeCategory(category) }
            } ?: run {
                return emptyList()
            }
        } else {
            return emptyList()
        }
    }

    override suspend fun getJokes(category: String): List<Joke> {

        val response = jokesAPI.getJokes(category).execute()
        if (response.isSuccessful) {
            response.body()?.let {
                return listOf(it).map { it.toDomain() }
            } ?: run {
                return emptyList()
            }
        } else {
            return emptyList()
        }
    }
}