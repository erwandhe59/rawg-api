package com.example.game_list.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.game_list.R
import com.example.game_list.models.Game

class GameAdapter(private val gamesList: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currentItem = gamesList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = gamesList.size

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.gameImage)
        private val titleTextView: TextView = itemView.findViewById(R.id.gameTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.gameDescription)
        private val releaseYearTextView: TextView = itemView.findViewById(R.id.gameReleaseYear)

        fun bind(game: Game) {
            titleTextView.text = game.title
            descriptionTextView.text = game.description
            releaseYearTextView.text = game.releaseYear.toString()
            imageView.setImageResource(game.imageResId) // Utilisez l'identifiant de ressource pour définir l'image
        }
    }
}
