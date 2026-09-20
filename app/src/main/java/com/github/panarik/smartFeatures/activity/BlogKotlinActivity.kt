package com.github.panarik.smartFeatures.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.panarik.smartFeatures.data.blog.BlogAdapter
import com.github.panarik.smartFeatures.databinding.ActivityBlogKotlinBinding

class BlogKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBlogKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.blogRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.blogRecyclerview.adapter = BlogAdapter()
    }
}