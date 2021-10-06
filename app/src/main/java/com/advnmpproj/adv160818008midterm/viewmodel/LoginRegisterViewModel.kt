package com.advnmpproj.adv160818008midterm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.advnmpproj.adv160818008midterm.model.Users

class LoginRegisterViewModel:ViewModel() {
    val usersLD = MutableLiveData<List<Users>>()

    fun userdataLoad()
    {
        val user1 = Users("Anne", "annemary@email.com", "pass123")
        val user2 = Users("Mitch", "mitchelin@email.com", "12345")
        val user3 = Users("Sean", "seanery@email.com", "yesno")
        val user4 = Users("Baldy", "thebaldguy@email.com", "bald123")

        var usersList:ArrayList<Users> = arrayListOf(user1, user2, user3, user4)

        usersLD.value = usersList
    }
}