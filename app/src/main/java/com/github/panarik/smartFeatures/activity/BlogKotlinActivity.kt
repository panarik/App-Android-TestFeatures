package com.github.panarik.smartFeatures.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.data.blog.BlogAdapter
import kotlinx.android.synthetic.main.activity_blog_kotlin.*

class BlogKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_kotlin)
        blog_recyclerview.layoutManager = LinearLayoutManager(this)
        blog_recyclerview.adapter = BlogAdapter()
    }
}