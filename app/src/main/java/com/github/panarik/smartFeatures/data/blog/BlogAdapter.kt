package com.github.panarik.smartFeatures.data.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.panarik.smartFeatures.R

class BlogAdapter: RecyclerView.Adapter<BlogViewHolder>() //типовой RecyclerView.Adapter будет использовать кастомный BlogViewHolder
{

    //создаёт отдельный ВьюХолдер
    override fun onCreateViewHolder
            (parent: ViewGroup, viewType: Int): BlogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val blogItem = layoutInflater.inflate(R.layout.blog_item, parent, false)
        return BlogViewHolder(blogItem)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {

    }

    //количество ИьюХолдеров в RecyclerView
    override fun getItemCount(): Int {
        return 3
    }
}

//Создаем свой ViewHolder
class BlogViewHolder(v: View): RecyclerView.ViewHolder(v) {



}



