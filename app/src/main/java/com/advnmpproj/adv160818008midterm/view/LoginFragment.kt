package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import android.util.Log
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
import com.advnmpproj.adv160818008midterm.databinding.FragmentLoginBinding
import com.advnmpproj.adv160818008midterm.databinding.FragmentProfileBinding
import com.advnmpproj.adv160818008midterm.viewmodel.LoginRegisterViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), LoginClick, GoToRegister {
    private lateinit var loginRegisterViewModel: LoginRegisterViewModel
    private lateinit var dataBinding:FragmentLoginBinding
    var username:String? = ""
    var pass:String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        btnLogRegis.setOnClickListener {
//            val action = LoginFragmentDirections.actionRegFrag()
//            Navigation.findNavController(it).navigate(action)
//        }

        loginRegisterViewModel = ViewModelProvider(this).get(LoginRegisterViewModel::class.java)

        dataBinding.goRegisListener = this
        dataBinding.loginButtonListener =this

//        username = dataBinding.user.username.toString()
//        pass = dataBinding.user.username.toString()

        observeViewModel()
    }

    fun observeViewModel()
    {
        loginRegisterViewModel.usersLD.observe(viewLifecycleOwner, Observer {
            dataBinding.user = it

//            var user = it
//            btnLogin.setOnClickListener {
//                username = txtLogUname.text.toString()
//                pass = txtLogPass.text.toString()
//
//                var userFound = false
//                var datbasePass = ""

//                for(user in listUsers)
//                {
//                    if (user.username.equals(username)) {
//                        userFound = true
//                        datbasePass = user.password.toString()
//
//                        if (pass.equals(datbasePass)) {
//                            val action = LoginFragmentDirections.actionBackProfile(username, user.email.toString(), true)
//                            Navigation.findNavController(it).navigate(action)
//                        } else {
//                            Toast.makeText(context, "Please check your password!", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }

//                if (user.username.equals(username)) {
//                    userFound = true
//                    datbasePass = user.password.toString()
//
//                    if (pass.equals(datbasePass)) {
//                        val action = LoginFragmentDirections.actionBackProfile(username, user.email.toString(), true)
//                        Navigation.findNavController(it).navigate(action)
//                    } else {
//                        Toast.makeText(context, "Please check your password!", Toast.LENGTH_SHORT).show()
//                    }
//                }

//                if (userFound == false)
//                {
//                    Toast.makeText(context, "Username not found!", Toast.LENGTH_SHORT).show()
//                }
//            }
        })
    }

    override fun onGoToRegister(v: View) {
        val action = LoginFragmentDirections.actionRegFrag()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onLoginClick(v: View) {
        username = dataBinding.username
        pass = dataBinding.pass

        loginRegisterViewModel.findUser(username)

        var userFind = dataBinding.user

        if (userFind == null)
        {
            Toast.makeText(context, "Username not found!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            val datpass = userFind?.password
            val email = userFind?.email
            Log.d("datPass",  datpass + " " + email)
            if(pass.equals(datpass))
            {
                val action = LoginFragmentDirections.actionBackProfile(username.toString(), email.toString(), true)
                Navigation.findNavController(v).navigate(action)
            }
            else {
                Toast.makeText(context, "Please check your password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}