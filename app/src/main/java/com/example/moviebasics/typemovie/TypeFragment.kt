package com.example.moviebasics.typemovie

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
import com.example.moviebasics.network.checkForInternet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TypeFragment : Fragment() {

    // ==> lateinit property viewModel has not been initialized don't use by viewModels()
    private val viewModel: TypeViewModel by viewModels()

    private lateinit var binding : FragmentTypeMovieBinding

    private val args: TypeFragmentArgs by navArgs()
    private val genreId by lazy { args.genreId }

//    private val argsDetail: DetailFragmentArgs by navArgs()
//    private val movieId by lazy { argsDetail.movieId }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTypeMovieBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = viewLifecycleOwner
        binding.lifecycleOwner = this


//        Status update
        viewModel.status.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

//        TypeMovies update
        viewModel.typeMovies.observe(viewLifecycleOwner) {
            val adapter = TypeMoviesAdapter(it, genreId){
                val direction = TypeFragmentDirections.actionTypeFragmentToDetailFragment(it.id)
                findNavController().navigate(direction)
            }
            binding.fragmentContainerViewTypeMovie.adapter = adapter
        }
        viewModel.getTypeMovies(checkForInternet(requireContext()), genreId)

        return binding.root
    }

}