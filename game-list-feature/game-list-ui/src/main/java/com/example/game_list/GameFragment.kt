package com.example.game_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_list.databinding.FragmentGameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    private val gameListViewModel : GameListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameListViewModel.getGames()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gameListViewModel.getGames().observe(viewLifecycleOwner) { games ->
            val adapter = GameAdapter(games)
            binding.gamesRecyclerView.adapter = adapter
            binding.gamesRecyclerView.layoutManager = LinearLayoutManager(context)
        }
    }
}


//Intéraction utilisateur