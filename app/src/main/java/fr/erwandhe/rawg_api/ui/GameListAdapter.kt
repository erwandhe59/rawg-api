package fr.erwandhe.rawg_api.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.erwandhe.rawg_api.data.Game
import fr.erwandhe.rawg_api.databinding.ItemGameBinding

class GameListAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {

    inner class GameViewHolder(val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGameBinding.inflate(layoutInflater, parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]

        // Mettez à jour la vue avec les détails du jeu
        holder.binding.titleTextView.text = game.title
        holder.binding.descriptionTextView.text = game.description
    }

    override fun getItemCount(): Int = games.size
}