package com.demo.chucknorris.core.domain.repositories

import com.demo.chucknorris.core.domain.model.Joke
import com.demo.chucknorris.core.domain.model.JokeCategory

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
interface JokesRepository {


    suspend fun getJokeCategories(): List<JokeCategory>
    suspend fun getJokes(category: String): List<Joke>
}