package com.example.recycleviewmovies.recycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleviewmovies.R
import com.example.recycleviewmovies.pojo.Movie

class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {
    var movies:List<Movie> = listOf()
        set(value:List<Movie>){
            field = value
            notifyDataSetChanged()
        }
    class MoviesHolder(itemView: CardView):RecyclerView.ViewHolder(itemView){
        private val textViewRating = itemView.findViewById<TextView>(R.id.textViewRating)
        private  val imageViewPoster = itemView.findViewById<ImageView>(R.id.imageViewPoster)

        fun bind(movie: Movie) {
            textViewRating.text = movie.rating.kp.toString()

            Glide.with(itemView)
                .load(movie.poster.url)
                .into(imageViewPoster)

        }

        companion object {
            fun inflateFrom(p0: ViewGroup): MoviesAdapter.MoviesHolder {
                val inflater = LayoutInflater.from(p0.context)
                val view = inflater.inflate(R.layout.item_movie,p0,false) as CardView
                return MoviesHolder(view)
            }
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MoviesHolder = MoviesHolder.inflateFrom(p0)

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(p0: MoviesHolder, p1: Int) {
        val movie = movies[p1]
        p0.bind(movie)
    }
}