package com.fjdevel.lab05.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.fjdevel.lab05.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FIrstFragment : Fragment() {
    private lateinit var buttonFirstFragment:FloatingActionButton
    private lateinit var cardMovie:CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_irst, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonFirstFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_FIrstFragment_to_secondFragment)
        }
        cardMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_FIrstFragment_to_moviesFragment)
        }
    }

    private fun bind(){
        buttonFirstFragment = view?.findViewById(R.id.button_first_fragment) as FloatingActionButton
        cardMovie = view?.findViewById(R.id.movie_card) as CardView
    }
}