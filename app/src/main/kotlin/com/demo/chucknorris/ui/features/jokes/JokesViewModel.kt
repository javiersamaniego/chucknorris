package com.demo.chucknorris.ui.features.jokes

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.chucknorris.core.domain.model.Joke
import com.demo.chucknorris.core.domain.model.JokeCategory
import com.demo.chucknorris.core.domain.usecases.GetJokeCategoriesUseCase
import com.demo.chucknorris.core.domain.usecases.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
@HiltViewModel
class JokesViewModel @Inject  constructor(
    private val getJokeCategoriesUseCase: GetJokeCategoriesUseCase,
    private val getJokesUseCase: GetJokesUseCase
): ViewModel(){
    private val _jokesCategories: MutableStateFlow<List<JokeCategory>> = MutableStateFlow(emptyList())
    val jokesCategories: StateFlow<List<JokeCategory>> get() = _jokesCategories

    private val _jokes: MutableStateFlow<List<Joke>> = MutableStateFlow(emptyList())
    val jokes: StateFlow<List<Joke>> get() = _jokes

    fun getJokesCategories() {
        viewModelScope.launch {
            _jokesCategories.emit(getJokeCategoriesUseCase())
        }
    }

    fun getJokes(category: String) {
        viewModelScope.launch {
            _jokes.emit(getJokesUseCase(category))
        }
    }
}