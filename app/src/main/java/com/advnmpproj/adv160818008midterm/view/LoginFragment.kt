package com.advnmpproj.adv160818008midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.advnmpproj.adv160818008midterm.R
import com.advnmpproj.adv160818008midterm.viewmodel.LoginRegisterViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var loginRegisterViewModel: LoginRegisterViewModel
    var username = ""
    var pass = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogRegis.setOnClickListener {
            val action = LoginFragmentDirections.actionRegFrag()
            Navigation.findNavController(it).navigate(action)
        }

        loginRegisterViewModel = ViewModelProvider(this).get(LoginRegisterViewModel::class.java)
        loginRegisterViewModel.userdataLoad()

        observeViewModel()
    }

    fun observeViewModel()
    {
        loginRegisterViewModel.usersLD.observe(viewLifecycleOwner, Observer {
            var listUsers = it
            btnLogin.setOnClickListener {
                username = txtLogUname.text.toString()
                pass = txtLogPass.text.toString()

                var userFound = false
                var datbasePass = ""

                for(user in listUsers)
                {
                    if (user.username.equals(username)) {
                        userFound = true
                        datbasePass = user.password.toString()

                        if (pass.equals(datbasePass)) {
                            val action = LoginFragmentDirections.actionBackProfile(username, user.email.toString(), true)
                            Navigation.findNavController(it).navigate(action)
                        } else {
                            Toast.makeText(context, "Please check your password!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                if (userFound == false)
                {
                    Toast.makeText(context, "Username not found!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}