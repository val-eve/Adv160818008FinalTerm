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

        imgAbout.loadImage("https://pixabay.com/get/g4679678e6f93f147e9b4c01ea4321af6b5c9e957e72c1a227f8e4b839f3d643ef8360fa5596eb0ed5d7798b5fce1433157c728827ae68c6df4198597b4d0555f_640.jpg", progressAbout)
    }
}