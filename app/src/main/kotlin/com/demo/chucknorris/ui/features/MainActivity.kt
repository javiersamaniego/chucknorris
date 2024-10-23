package com.demo.chucknorris.ui.features

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.demo.chucknorris.R
import com.demo.chucknorris.databinding.ActivityMainBinding
import com.demo.chucknorris.ui.features.jokes.JokesViewModel
import com.demo.chucknorris.ui.features.jokes.adapters.JokeCategoryAdapter
import com.demo.chucknorris.ui.features.jokes.adapters.JokesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: JokesViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    private val jokeAdapter: JokesAdapter = JokesAdapter()

    private val adapter = JokeCategoryAdapter {
        viewModel.getJokes("random")
        binding.rvCategories.adapter = jokeAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvCategories.adapter = adapter


        initObservers()
        viewModel.getJokesCategories()
    }

    private fun initObservers() {
        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.CREATED) {
                launch {
                    viewModel.jokesCategories.collect {
                        adapter.submitList(it)
                    }
                }
                launch {
                    viewModel.jokes.collect {
                        jokeAdapter.submitList(it)
                    }
                }
            }
        }
    }
}