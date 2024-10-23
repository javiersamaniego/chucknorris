package com.demo.chucknorris.core.domain.usecases

import com.demo.chucknorris.core.domain.repositories.JokesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
class GetJokeCategoriesUseCase @Inject constructor(
    private val jokesRepository: JokesRepository
) {

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        jokesRepository.getJokeCategories()
    }
}