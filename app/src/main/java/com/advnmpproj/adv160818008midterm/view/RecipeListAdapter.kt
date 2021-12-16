package com.advnmpproj.adv160818008midterm.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.databinding.RecipeListItemBinding
import com.advnmpproj.adv160818008midterm.model.Recipes
import com.advnmpproj.adv160818008midterm.utility.loadImage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class RecipeListAdapter(val recipeList:ArrayList<Recipes>): RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>(), RecipeMoreDetailClick
{
    class RecipeViewHolder(var view:RecipeListItemBinding): RecyclerView.ViewHolder(view.root)

    fun updateRecList(newRecipesList:List<Recipes>)
    {
        recipeList.clear()
        recipeList.addAll(newRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.recipe_list_item, parent, false)
        val view = DataBindingUtil.inflate<RecipeListItemBinding>(inflater, R.layout.recipe_list_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        with(holder.view)
//        {
//            txtRecName.text = recipeList[position].recipeName
//            txtDesc.text = recipeList[position].description
//            imgFood.loadImage(recipeList[position].imgUrl, progressImgLoad)
//
//            btnMore.setOnClickListener {
//                val action = RecipeListFragmentDirections.actionRecDetail()
//                Navigation.findNavController(it).navigate(action)
//            }
//        }
        holder.view.recipe = recipeList[position]
        holder.view.moreDetailListener = this
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onRecipeMoreDetailClick(v: View) {
        val act = RecipeListFragmentDirections.actionToDetail(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(act)
    }
}