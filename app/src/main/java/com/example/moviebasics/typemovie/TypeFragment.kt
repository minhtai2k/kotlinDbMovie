package com.example.moviebasics.typemovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.moviebasics.R
import com.example.moviebasics.databinding.FragmentTypeMovieBinding

class TypeFragment : Fragment() {

    private lateinit var viewModel: TypeViewModel

    private lateinit var binding : FragmentTypeMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTypeMovieBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

//        Status update
        viewModel.status.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

//        TypeMovies update
        viewModel.typeMovies.observe(viewLifecycleOwner) {

        }

        return binding.root
    }

}