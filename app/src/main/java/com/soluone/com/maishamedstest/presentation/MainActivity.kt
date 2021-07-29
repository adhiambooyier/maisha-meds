package com.soluone.com.maishamedstest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.soluone.com.maishamedstest.R
import com.soluone.com.maishamedstest.databinding.ActivityMainBinding
import com.soluone.com.maishamedstest.domain.Post

class MainActivity : AppCompatActivity() {
    private val postsViewModel: PostsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initViewModel()
    }

    private fun initViewModel() {
        postsViewModel.getPosts()
        postsViewModel.posts.observe(this, { results ->
            showPosts(results)
        })
    }

    private fun showPosts(list: ArrayList<Post>) {
        binding.rvPosts.apply {
            adapter = PostsAdapter(list)
        }
    }
}