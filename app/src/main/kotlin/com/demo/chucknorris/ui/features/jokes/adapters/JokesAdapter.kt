package com.demo.chucknorris.ui.features.jokes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.demo.chucknorris.core.domain.model.Joke
import com.demo.chucknorris.core.domain.model.JokeCategory
import com.demo.chucknorris.databinding.CustomItemJokeBinding
import com.demo.chucknorris.databinding.CustomItemJokeCategoryBinding
import com.squareup.picasso.Picasso

/**
 * @author Munt Green on 2024/10/23
 * @version 1.0
 * @since 1.0
 */

/**
 *
 */

class JokesViewHolder(private val binding: CustomItemJokeBinding) :
    ViewHolder(binding.root) {

    fun bind(joke: Joke) {

        Picasso.get().load(joke.icon).into(binding.ivJoke);
        binding.tvJoke.text = joke.text
    }
}

class JokesAdapter() : ListAdapter<Joke, JokesViewHolder>(object :
    DiffUtil.ItemCallback<Joke>() {
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.text == newItem.text
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        return JokesViewHolder(
            CustomItemJokeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}