package fr.erwandhe.rawg_api.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.erwandhe.rawg_api.R
import fr.erwandhe.rawg_api.data.Game
import fr.erwandhe.rawg_api.ui.GameListAdapter
import fr.erwandhe.rawg_api.databinding.FragmentGameListBinding

class GameListFragment : Fragment() {

    private lateinit var binding: FragmentGameListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Exemple de liste de jeux fictive
        val games = listOf(
            Game("Titre 1", "Description 1"),
            Game("Titre 2", "Description 2"),
            Game("Titre 3", "Description 3")
        )

        // Utilisation d'un LinearLayoutManager pour la liste
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager

        // Création d'un adaptateur pour la liste de jeux
        val adapter = GameListAdapter(games)
        binding.recyclerView.adapter = adapter

        // Ajout d'un espacement entre les éléments de la liste
        val itemDecoration = VerticalSpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.item_spacing))
        binding.recyclerView.addItemDecoration(itemDecoration)
    }

    // Classe pour définir l'espacement vertical entre les éléments de la liste
    class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.bottom = verticalSpaceHeight
        }
    }
}
