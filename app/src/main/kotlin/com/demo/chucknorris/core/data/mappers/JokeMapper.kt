package com.demo.chucknorris.core.data.mappers

import com.demo.chucknorris.core.data.model.Joke
import com.demo.chucknorris.core.data.model.JokeCategory

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
fun JokeCategory.toDomain() = com.demo.chucknorris.core.domain.model.JokeCategory(name)
fun Joke.toDomain() = com.demo.chucknorris.core.domain.model.Joke(text, icon)