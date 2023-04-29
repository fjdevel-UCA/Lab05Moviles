package com.fjdevel.lab05.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.fjdevel.lab05.R
import com.fjdevel.lab05.data.model.MovieModel


class SecondFragment : Fragment() {
    private lateinit var submit:Button
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var quialificationEditText: EditText
    private lateinit var nameEditText: EditText
    private val movieViewModel:MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_secondFragment_to_FIrstFragment2)
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        submit = view?.findViewById(R.id.submit_action_button) as Button

        submit.setOnClickListener {
            addMovie()
            it.findNavController().navigate(R.id.action_secondFragment_to_FIrstFragment2)
        }
    }

    private fun bind(){
        nameEditText = view?.findViewById(R.id.nameEditText) as EditText
        descriptionEditText = view?.findViewById(R.id.descriptionEditText) as EditText
        categoryEditText = view?.findViewById(R.id.categoryEditText) as EditText
        quialificationEditText = view?.findViewById(R.id.calificationEditText) as EditText
    }

    private fun addMovie(){
        val name = nameEditText.text.toString()
        val category = categoryEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val rating = quialificationEditText.text.toString()
        val movie = MovieModel(name,category,description,rating)

        movieViewModel.addMovies(movie)
    }
}