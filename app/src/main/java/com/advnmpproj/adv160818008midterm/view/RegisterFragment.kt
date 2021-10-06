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
import com.advnmpproj.adv160818008midterm.model.Users
import com.advnmpproj.adv160818008midterm.viewmodel.LoginRegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
    private lateinit var loginRegisterViewModel: LoginRegisterViewModel
    var uname = ""
    var pass = ""
    var repass = ""
    var email = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginRegisterViewModel = ViewModelProvider(this).get(LoginRegisterViewModel::class.java)
        loginRegisterViewModel.userdataLoad()

        observeViewModel()
    }

    fun observeViewModel(){
        loginRegisterViewModel.usersLD.observe(viewLifecycleOwner, Observer {
            var listUsers = it
            btnRegister.setOnClickListener {
                uname = txtRegUname.text.toString()
                email = txtRegEmail.text.toString()
                pass = txtRegPass.text.toString()
                repass = txtRegRePass.text.toString()

                var unameTaken = false

                if (repass == pass)
                {
                    for (user in listUsers)
                    {
                        if (user.username.equals(uname))
                        {
                            unameTaken = true
                            break
                        }
                    }

                    if(unameTaken == true)
                    {
                        Toast.makeText(context, "Username is taken! Please choose another username!", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        val user = Users(uname, email, pass)
                        listUsers.toMutableList().add(user)

                        val action = RegisterFragmentDirections.actionLogFrag()
                        Navigation.findNavController(it).navigate(action)
                    }
                }
                else
                {
                    Toast.makeText(context, "Retype password is wrong!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}