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
import com.advnmpproj.adv160818008midterm.databinding.FragmentRegisterBinding
import com.advnmpproj.adv160818008midterm.model.Users
import com.advnmpproj.adv160818008midterm.viewmodel.LoginRegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(), RegisterClick {
    private lateinit var loginRegisterViewModel: LoginRegisterViewModel
    private lateinit var dataBinding: FragmentRegisterBinding
    var uname:String? = ""
    var pass:String? = ""
    var repass:String? = ""
    var email:String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater, R.layout.fragment_register, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginRegisterViewModel = ViewModelProvider(this).get(LoginRegisterViewModel::class.java)

        dataBinding.registerListener = this

        observeViewModel()
    }

    fun observeViewModel(){
        loginRegisterViewModel.usersLD.observe(viewLifecycleOwner, Observer {
            dataBinding.user = it

//            var listUsers = it
//            btnRegister.setOnClickListener {
//                uname = txtRegUname.text.toString()
//                email = txtRegEmail.text.toString()
//                pass = txtRegPass.text.toString()
//                repass = txtRegRePass.text.toString()
//
//                var unameTaken = false

//                if (repass == pass)
//                {
//                    for (user in listUsers)
//                    {
//                        if (user.username.equals(uname))
//                        {
//                            unameTaken = true
//                            break
//                        }
//                    }
//
//                    if(unameTaken == true)
//                    {
//                        Toast.makeText(context, "Username is taken! Please choose another username!", Toast.LENGTH_SHORT).show()
//                    }
//                    else
//                    {
//                        val user = Users(uname, email, pass)
//                        listUsers.toMutableList().add(user)
//
//                        val action = RegisterFragmentDirections.actionLogFrag()
//                        Navigation.findNavController(it).navigate(action)
//                    }
//                }
//                else
//                {
//                    Toast.makeText(context, "Retype password is wrong!", Toast.LENGTH_SHORT).show()
//                }
//            }
        })
    }

    override fun onRegisterClick(v: View) {
        uname = dataBinding.username
        pass = dataBinding.pass
        repass = dataBinding.confPass
        email = dataBinding.email

        var user = Users(uname, email, pass)

        loginRegisterViewModel.findUser(uname)

        var userFind = dataBinding.user

        if (repass == pass)
        {
            if (userFind == null)
            {
                loginRegisterViewModel.registerUser(user)
                val action = RegisterFragmentDirections.actionLogFrag()
                Navigation.findNavController(v).navigate(action)
            }
            else
            {
                Toast.makeText(context, "Username is taken! Please choose another username!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(context, "Retype password is wrong!", Toast.LENGTH_SHORT).show()
        }
    }
}