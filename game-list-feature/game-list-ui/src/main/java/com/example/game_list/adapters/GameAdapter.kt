package com.example.game_list.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.game_list.R
import com.example.game_list.domain.models.Game

class GameAdapter(private var gamesList: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

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

        fun bind(game: Game) {
            titleTextView.text = game.title
            descriptionTextView.text = game.description
            // Utilisez Glide pour charger l'image à partir de l'URL
            Glide.with(itemView.context)
                .load(game.imageUrl) // Fournit une image par défaut si imageUrl est null
                .into(imageView)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newGames: List<Game>) {
        gamesList = newGames
        notifyDataSetChanged() // Notifie que les données ont changé pour rafraîchir la vue
    }
}