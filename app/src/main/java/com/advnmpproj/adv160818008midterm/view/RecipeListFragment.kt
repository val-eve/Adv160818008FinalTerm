package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.viewmodel.RecListViewModel
import kotlinx.android.synthetic.main.fragment_recipe_list.*

class RecipeListFragment : Fragment() {
    private lateinit var viewModel: RecListViewModel
    private val recipeListAdapter = RecipeListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecListViewModel::class.java)
        viewModel.loadData()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = recipeListAdapter

        observeViewModel()
    }

    fun observeViewModel()
    {
        viewModel.recipesLD.observe(viewLifecycleOwner, Observer {
            recipeListAdapter.updateRecList(it)
        })

        viewModel.recipeLoadErrorLD.observe(viewLifecycleOwner, Observer {
            txtError.visibility = if(it == true) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it == true)
            {
                recView.visibility = View.VISIBLE
                progLoad.visibility = View.GONE
            }
            else
            {
                recView.visibility = View.GONE
                progLoad.visibility = View.VISIBLE

            }
        })
    }
}