package com.advnmpproj.adv160818008midterm.view

import android.view.View
import com.advnmpproj.adv160818008midterm.model.Recipes
import com.advnmpproj.adv160818008midterm.model.Users

interface CreateRecipeClick{
    fun onCreateRecipeClick(v:View)
}

interface RecipeMoreDetailClick{
    fun onRecipeMoreDetailClick(v:View)
}

interface RecipeEditConfirmClick{
    fun onRecipeEditConfirmClick(v:View, obj:Recipes)
}

interface EditRecipeClick{
    fun onEditRecipeClick(v:View)
}

interface GoToLoginClick{
    fun onGoToLoginClick(v:View)
}

interface GoToRegister{
    fun onGoToRegister(v:View)
}

interface LoginClick{
    fun onLoginClick(v:View)
}

interface RegisterClick{
    fun onRegisterClick(v:View)
}