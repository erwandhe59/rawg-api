package com.example.game_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_list.adapters.GameAdapter
import com.example.game_list.databinding.FragmentGameBinding
import com.example.game_list.viewmodel.GameListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val gameListViewModel: GameListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.gamesRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun observeViewModel() {
        gameListViewModel.getGames().observe(viewLifecycleOwner) { games ->
            binding.gamesRecyclerView.adapter = GameAdapter(games)
        }

        // Ajoutez ici l'observation d'un potentiel état de chargement ou d'erreur
        // Exemple :
        // gameListViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
        //     if (isLoading) {
        //         // Afficher un indicateur de chargement
        //     } else {
        //         // Cacher l'indicateur de chargement
        //     }
        // }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
