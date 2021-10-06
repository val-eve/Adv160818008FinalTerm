package com.advnmpproj.adv160818008midterm.utility

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.advnmpproj.adv160818008midterm.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadImage(url: String?, progressBar: ProgressBar){
    Picasso.get().load(url).resize(500,500).centerCrop().error(R.drawable.ic_baseline_error_24).into(this, object:Callback{
        override fun onSuccess() {
            progressBar.visibility = View.GONE
        }
        override fun onError(e: Exception?) {
        }
    })
}