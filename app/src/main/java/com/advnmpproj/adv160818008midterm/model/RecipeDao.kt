package com.advnmpproj.adv160818008midterm.model

import androidx.room.*

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipes:Recipes)

    @Query("SELECT * FROM recipes")
    suspend fun selectAllRec():List<Recipes>

    @Query("SELECT * FROM recipes WHERE id=:rId")
    suspend fun selectRecipe(rId:Int):Recipes

    @Query("UPDATE recipes SET recipeName=:name, description=:desc, moreDetail=:det, imgUrl=:imgUrl WHERE id=:rId")
    suspend fun updateEditRec(name:String, desc:String, det:String, imgUrl:String, rId:Int)

    @Delete
    suspend fun deleteRec(recipes:Recipes)
}