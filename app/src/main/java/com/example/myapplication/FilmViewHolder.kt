package com.example.myapplication

import android.view.View
import com.example.myapplication.databinding.FilmItemBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : ViewHolder(itemView) {

    val filmBinding = FilmItemBinding.bind(itemView)

    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        filmBinding.title.text = film.title
        filmBinding.poster.setImageResource(film.poster)
        filmBinding.description.text = film.description
    }
}