package com.advnmpproj.adv160818008midterm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Users::class), version = 1)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao():UserDao

    companion object{
        @Volatile private var instace:UserDatabase ?=null
        private val LOCK = Any()

        private fun buildDB(context: Context) = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "newuserdb").build()

        operator fun invoke(context: Context){
            if(instace!=null)
            {
                synchronized(LOCK){
                    instace ?: buildDB(context).also {
                        instace = it
                    }
                }
            }
        }
    }
}