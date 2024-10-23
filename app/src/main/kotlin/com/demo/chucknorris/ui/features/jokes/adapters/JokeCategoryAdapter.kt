package com.demo.chucknorris.ui.features.jokes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.demo.chucknorris.core.domain.model.JokeCategory
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

class JokeCategoryViewHolder(
    private val binding: CustomItemJokeCategoryBinding,
    private val onCategoryClickListener: (String) -> Unit
) :
    ViewHolder(binding.root) {

    fun bind(jokeCategory: JokeCategory) {


        binding.tvCategory.text = jokeCategory.name

        binding.root.setOnClickListener {
            onCategoryClickListener(jokeCategory.name)
        }
    }
}

class JokeCategoryAdapter(private val onCategoryClickListener: (String) -> Unit) :
    ListAdapter<JokeCategory, JokeCategoryViewHolder>(object :
        DiffUtil.ItemCallback<JokeCategory>() {
        override fun areItemsTheSame(oldItem: JokeCategory, newItem: JokeCategory): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JokeCategory, newItem: JokeCategory): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeCategoryViewHolder {
        return JokeCategoryViewHolder(
            CustomItemJokeCategoryBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            ), onCategoryClickListener
        )
    }

    override fun onBindViewHolder(holder: JokeCategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}