package com.advnmpproj.adv160818008midterm.utility

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.model.RecipeDatabase
import com.advnmpproj.adv160818008midterm.model.UserDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

val RDB_NAME = "newrecipedb"
val UDB_NAME = "newuserdb"

fun ImageView.loadImage(url:String, progressBar:ProgressBar){
    Picasso.get().load(url).resize(500,500).centerCrop().error(R.drawable.ic_baseline_error_24).into(this, object:Callback{
        override fun onSuccess() {
            progressBar.visibility = View.GONE
        }
        override fun onError(e: Exception?) {
        }
    })
}

fun buildRDB(context:Context):RecipeDatabase{
    val db = Room.databaseBuilder(context, RecipeDatabase::class.java, RDB_NAME).build()
    return db
}

fun buildUDB(context:Context):UserDatabase{
    val db = Room.databaseBuilder(context, UserDatabase::class.java, UDB_NAME).build()
    return db
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadImgUrl(v:ImageView, url:String, pB:ProgressBar){
    v.loadImage(url, pB)
}