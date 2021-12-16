package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.databinding.FragmentEditRecipeBinding
import com.advnmpproj.adv160818008midterm.model.Recipes
import com.advnmpproj.adv160818008midterm.viewmodel.RecDetailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [EditRecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditRecipeFragment : Fragment(), RecipeEditConfirmClick {
    private lateinit var viewModel: RecDetailViewModel
    private lateinit var dataBinding:FragmentEditRecipeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentEditRecipeBinding>(inflater, R.layout.fragment_edit_recipe, container, false)
//        return inflater.inflate(R.layout.fragment_edit_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = EditRecipeFragmentArgs.fromBundle(requireArguments()).recId
        Log.d("tes", id.toString())

        viewModel = ViewModelProvider(this).get(RecDetailViewModel::class.java)
        viewModel.selectRecipeId(id)

        dataBinding.confirmListener = this

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.recDetLD.observe(viewLifecycleOwner, Observer {
            dataBinding.recipe = it
            Log.d("tes", it.toString())
        })
    }

    override fun onRecipeEditConfirmClick(v: View, obj: Recipes) {
        viewModel.editRecipe(obj.recipeName.toString(), obj.description.toString(), obj.moreDetail.toString(), obj.imgUrl.toString(), obj.id)
        Toast.makeText(v.context, "Recipe Edited", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()
    }
}