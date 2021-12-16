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
import com.advnmpproj.adv160818008midterm.databinding.FragmentCreateRecipeBinding
import com.advnmpproj.adv160818008midterm.databinding.FragmentRegisterBinding
import com.advnmpproj.adv160818008midterm.model.Recipes
import com.advnmpproj.adv160818008midterm.viewmodel.RecDetailViewModel
import kotlinx.android.synthetic.main.fragment_create_recipe.*

/**
 * A simple [Fragment] subclass.
 * Use the [CreateRecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateRecipeFragment : Fragment(), CreateRecipeClick {
    private lateinit var viewModel:RecDetailViewModel
    private lateinit var dataBinding:FragmentCreateRecipeBinding
    var recName:String? = ""
    var desc:String? = ""
    var detail:String? = ""
    var imgUrl:String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_create_recipe, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentCreateRecipeBinding>(inflater, R.layout.fragment_create_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecDetailViewModel::class.java)

        dataBinding.createListener = this
    }

    override fun onCreateRecipeClick(v: View) {
        recName = dataBinding.recipename
        desc = dataBinding.desc
        detail = dataBinding.detail
        imgUrl = dataBinding.imgUrl

        var recipe = Recipes(recName.toString(), desc.toString(), detail.toString(), imgUrl.toString())
        viewModel.createRecipe(recipe)

        Toast.makeText(v.context, "Recipe Added", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()
    }
}