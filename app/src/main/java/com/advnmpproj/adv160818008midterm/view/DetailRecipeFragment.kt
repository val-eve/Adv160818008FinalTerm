package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.utility.loadImage
import com.advnmpproj.adv160818008midterm.viewmodel.RecDetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_recipe.*

class DetailRecipeFragment : Fragment() {
    private lateinit var viewModel: RecDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecDetailViewModel::class.java)
        viewModel.LoadRecDetail()

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.recDetLD.observe(viewLifecycleOwner, Observer {
            txtRecNameDetail.text = it.recipeName
            txtDetDesc.text = it.description
            txtDetDirection.text = it.moreDetail
            imgDetFood.loadImage(it.imgUrl, progressDetImgLoad)
        })
    }
}