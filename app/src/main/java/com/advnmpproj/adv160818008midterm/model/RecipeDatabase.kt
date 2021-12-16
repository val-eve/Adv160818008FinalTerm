package com.advnmpproj.adv160818008midterm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Recipes::class), version = 1)
abstract class RecipeDatabase:RoomDatabase() {
    abstract fun recipeDao():RecipeDao

    companion object{
        @Volatile private var instace:RecipeDatabase ?=null
        private val LOCK = Any()

        private fun buildDB(context:Context) = Room.databaseBuilder(context.applicationContext, RecipeDatabase::class.java, "newrecipedb").build()

        operator fun invoke(context:Context){
            if(instace!=null)
            {
                synchronized(LOCK){
                    instace ?: buildDB(context).also {
                        instace = it
                    }
                }
            }
        }
    }
}