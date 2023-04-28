package com.example.laboratorio05.ui.movies


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Locale.Category

class NewMovieFragment : Fragment() {

    private lateinit var nametv: EditText
    private lateinit var CategoryTv: EditText
    private lateinit var DescriptionTv: EditText
    private lateinit var CalificationTv: EditText
    private lateinit var Submmitbtn: Button

    private val movieViewModel : MovieVIewModel by activityViewModels {
        MovieVIewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nametv = view.findViewById(R.id.nameET)
        CategoryTv= view.findViewById(R.id.categoryET)
        DescriptionTv= view.findViewById(R.id.descriptionET)
        CalificationTv= view.findViewById(R.id.calificationET)
        Submmitbtn = view.findViewById(R.id.SubmmitBtn)

        Submmitbtn.setOnClickListener{
            var Name = nametv.text.toString()
            var Category = CategoryTv.text.toString()
            var Description = DescriptionTv.text.toString()
            var Calification = CalificationTv.text.toString()
            var NewMovie = MovieModel(Name, Category, Description, Calification)
            movieViewModel.addMovies(NewMovie)
            Log.d("movie", movieViewModel.getMovies().toString())
        }

    }
}