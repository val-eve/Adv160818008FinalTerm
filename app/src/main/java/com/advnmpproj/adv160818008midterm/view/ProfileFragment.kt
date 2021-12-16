package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
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
import com.advnmpproj.adv160818008midterm.databinding.FragmentDetailRecipeBinding
import com.advnmpproj.adv160818008midterm.databinding.FragmentLoginBindingImpl
import com.advnmpproj.adv160818008midterm.databinding.FragmentProfileBinding
import com.advnmpproj.adv160818008midterm.viewmodel.LoginRegisterViewModel
import com.advnmpproj.adv160818008midterm.viewmodel.RecDetailViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), GoToLoginClick {
    private lateinit var dataBinding: FragmentProfileBinding

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.fragment_profile, container, false)
            dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
            return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var username:String? = ProfileFragmentArgs.fromBundle(requireArguments()).unameProfile
        var email:String? = ProfileFragmentArgs.fromBundle(requireArguments()).emailProf
        var statusLogin = ProfileFragmentArgs.fromBundle(requireArguments()).statusLogin

        if(!statusLogin)
        {
            txtProfile.visibility = View.INVISIBLE
            txtProfUname.visibility = View.INVISIBLE
            txtProfEmail.visibility = View.INVISIBLE
            btnProfLogin.visibility = View.VISIBLE
        }
        else
        {
            txtProfile.visibility = View.VISIBLE
            txtProfUname.visibility = View.VISIBLE
            txtProfEmail.visibility = View.VISIBLE
            btnProfLogin.visibility = View.INVISIBLE

            txtProfUname.text = username
            txtProfEmail.text = email
        }

//        btnProfLogin.setOnClickListener {
//            val action = ProfileFragmentDirections.actionLogin()
//            Navigation.findNavController(it).navigate(action)
//        }
        dataBinding.listenerButton = this
    }

    override fun onGoToLoginClick(v: View) {
        val action = ProfileFragmentDirections.actionLogin()
        Navigation.findNavController(v).navigate(action)
    }
}