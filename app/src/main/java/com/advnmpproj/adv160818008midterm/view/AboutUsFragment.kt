package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.utility.loadImage
import kotlinx.android.synthetic.main.fragment_about_us.*

class AboutUsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgAbout.loadImage("https://cdn.pixabay.com/photo/2021/02/18/09/27/people-6026674_1280.png", progressAbout)
    }
}