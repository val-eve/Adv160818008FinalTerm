package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.databinding.FragmentDetailRecipeBinding
import com.advnmpproj.adv160818008midterm.databinding.RecipeListItemBinding
import com.advnmpproj.adv160818008midterm.viewmodel.RecDetailViewModel

class DetailRecipeFragment : Fragment(), EditRecipeClick {
    private lateinit var viewModel: RecDetailViewModel
    private lateinit var dataBinding:FragmentDetailRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentDetailRecipeBinding>(inflater, R.layout.fragment_detail_recipe, container, false)
//        return inflater.inflate(R.layout.fragment_detail_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recId = DetailRecipeFragmentArgs.fromBundle(requireArguments()).detailId

        viewModel = ViewModelProvider(this).get(RecDetailViewModel::class.java)
        viewModel.selectRecipeId(recId)

        dataBinding.editListener = this

        observerViewModel()
    }

    fun observerViewModel()
    {
        viewModel.recDetLD.observe(viewLifecycleOwner, Observer {
            dataBinding.recipe = it

//            txtRecNameDetail.text = it.recipeName
//            txtDetDesc.text = it.description
//            txtDetDirection.text = it.moreDetail
//            imgDetFood.loadImage(it.imgUrl, progressDetImgLoad)
        })
    }

    override fun onEditRecipeClick(v: View) {
        val act = DetailRecipeFragmentDirections.actionEditRecipe(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(act)
    }
}