package com.github.panarik.smartFeatures.data.blog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.panarik.smartFeatures.databinding.BlogItemBinding

class BlogAdapter:
        RecyclerView.Adapter<BlogViewHolder>() //типовой RecyclerView.Adapter будет использовать кастомный BlogViewHolder
{

    //Создаём ArrayList, содержащий заголовки в вьюХолдерах
    val blogTitles = listOf<String>("First title", "Second title", "Third title", "Another title", "Again title", "More titles", "More titles!")



    //создаёт отдельный ВьюХолдер
    override fun onCreateViewHolder
            (parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = BlogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(binding)
    }

    //присваиваем ВьюХолдерам конкретные значения в полях разметки
    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {

        //1ый пример. Можно присвоить текст для отдельного view кастомного ВьюХолдера
        //holder.view.blog_title.text = "123" //

        //2ой пример. Привязываем текст к ArrayList
        val blogTitle = blogTitles.get(position)
        holder.binding.blogTitle.text = blogTitle
    }

    //количество ИьюХолдеров в RecyclerView
    override fun getItemCount(): Int {
        return blogTitles.size // количество строк в ArrayList blogTitles
    }
}

//Создаем свой ViewHolder
class BlogViewHolder(val binding: BlogItemBinding): RecyclerView.ViewHolder(binding.root) {
}
