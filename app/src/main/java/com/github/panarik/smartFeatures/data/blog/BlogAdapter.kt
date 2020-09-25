package com.github.panarik.smartFeatures.data.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.panarik.smartFeatures.R
import kotlinx.android.synthetic.main.blog_item.view.*

class BlogAdapter:
        RecyclerView.Adapter<BlogViewHolder>() //типовой RecyclerView.Adapter будет использовать кастомный BlogViewHolder
{

    //Создаём ArrayList, содержащий заголовки в вьюХолдерах
    val blogTitles = listOf<String>("First title", "Second title", "Third title", "Another title")



    //создаёт отдельный ВьюХолдер
    override fun onCreateViewHolder
            (parent: ViewGroup, viewType: Int): BlogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val blogItem = layoutInflater.inflate(R.layout.blog_item, parent, false) //разметка вьюХолдера = разметка blog_item
        return BlogViewHolder(blogItem)
    }

    //присваиваем ВьюХолдерам конкретные значения в полях разметки
    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {

        //1ый пример. Можно присвоить текст для отдельного view кастомного ВьюХолдера
        //holder.view.blog_title.text = "123" //

        //2ой пример. Привязываем текст к ArrayList
        val blogTitle = blogTitles.get(position)
        holder.view.blog_title.text = blogTitle



    }

    //количество ИьюХолдеров в RecyclerView
    override fun getItemCount(): Int {
        return blogTitles.size // количество строк в ArrayList blogTitles
    }
}

//Создаем свой ViewHolder
class BlogViewHolder(val view: View): RecyclerView.ViewHolder(view) {



}



