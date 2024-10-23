package com.demo.chucknorris.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */
data class JokeCategory(
    @SerializedName("name")
    val name: String
)