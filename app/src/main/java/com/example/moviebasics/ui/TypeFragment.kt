package com.example.moviebasics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moviebasics.adapter.TypeMoviesAdapter
import com.example.moviebasics.databinding.FragmentTypeMovieBinding
import com.example.moviebasics.viewmodel.TypeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TypeFragment : Fragment() {

    private val viewModel: TypeViewModel by viewModels()
    private lateinit var binding: FragmentTypeMovieBinding

    private val args: TypeFragmentArgs by navArgs()
    private val genreId by lazy { args.genreId }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTypeMovieBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        viewModel.status.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.typeMovies.observe(viewLifecycleOwner) {
            val adapter = TypeMoviesAdapter(it) { data ->
                val direction =
                    TypeFragmentDirections.actionTypeFragmentToDetailFragment(
                        data.id
                    )
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewTypeMovie.adapter = adapter
        }
        viewModel.getTypeMovies(genreId)

        return binding.root
    }

}