package com.advnmpproj.adv160818008midterm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.advnmpproj.adv160818008midterm.model.Users
import com.advnmpproj.adv160818008midterm.utility.buildUDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginRegisterViewModel(application:Application):AndroidViewModel(application), CoroutineScope {
//    val usersLD = MutableLiveData<List<Users>>()
    val usersLD = MutableLiveData<Users>()
    private var job = Job()


//    fun userdataLoad()
//    {
//        val user1 = Users("Anne", "annemary@email.com", "pass123")
//        val user2 = Users("Mitch", "mitchelin@email.com", "12345")
//        val user3 = Users("Sean", "seanery@email.com", "yesno")
//        val user4 = Users("Baldy", "thebaldguy@email.com", "bald123")
//
//        var usersList:ArrayList<Users> = arrayListOf(user1, user2, user3, user4)
//
//        usersLD.value = usersList
//    }

    fun findUser(uname:String?){
        launch {
            val db = buildUDB(getApplication())
            usersLD.value = db.userDao().findUser(uname)
        }
    }

//    fun getAllUser()
//    {
//        launch {
//            val db = buildUDB(getApplication())
//            usersLD.value = db.userDao().getAllUser()
//        }
//    }

    fun registerUser(users:Users?){
        launch {
            val db= buildUDB(getApplication())
            db.userDao().insertAll(users)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}