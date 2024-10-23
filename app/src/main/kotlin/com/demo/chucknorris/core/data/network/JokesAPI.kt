package com.demo.chucknorris.core.data.network

import com.demo.chucknorris.core.data.model.Joke
import com.demo.chucknorris.core.data.model.JokeCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
interface JokesAPI {

    @GET("/jokes/categories")
     fun getJokesCategories(): Call<List<String>>

    @GET("/jokes/{category}")
     fun getJokes(@Path("category") category: String): Call<Joke>
}